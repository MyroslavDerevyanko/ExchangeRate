package com.myroslav.derevyanko.exchangerate.PrivatbankAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Myroslav_D
 */
public class CourseRequest
{

    private static final String USER_AGENT = "Mozilla/5.0";
    final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    public List<PrivatAnswer> getExchangeRate(String url) throws IOException
    {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        logger.info("Sending 'GET' request to URL : " + url);
        logger.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }
        in.close();

        List<PrivatAnswer> answ = new ObjectMapper().readValue(response.toString(), new TypeReference<List<PrivatAnswer>>(){});
        
        return answ;
    }
}
