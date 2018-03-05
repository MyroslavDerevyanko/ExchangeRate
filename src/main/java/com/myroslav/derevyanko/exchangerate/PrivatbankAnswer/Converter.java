package com.myroslav.derevyanko.exchangerate.PrivatbankAnswer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Myroslav_D
 */
public class Converter
{

    public static double convertBuy(List<PrivatAnswer> answer, double value, String initialCurrency, String finalCurrency)
    {
        double result = 0;
        if (initialCurrency.equalsIgnoreCase("uah"))
        {
            if (finalCurrency.equalsIgnoreCase("uah"))
            {
                result = value;
            }
            else
            {
                for (PrivatAnswer a : answer)
                {
                    if (a.getCcy().equalsIgnoreCase(finalCurrency))
                    {
                        result = new BigDecimal(value / a.getBuy()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    }

                }
            }
        }

        for (PrivatAnswer a : answer)
        {
            if (a.getCcy().equalsIgnoreCase(initialCurrency))
            {
                if (finalCurrency.equalsIgnoreCase("uah"))
                {
                    result = new BigDecimal(a.getBuy() * value).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
                else
                {
                    for (PrivatAnswer a1 : answer)
                    {
                        if (a1.getCcy().equalsIgnoreCase(finalCurrency))
                        {
                            result = new BigDecimal((a.getBuy() * value) / a1.getBuy()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        }
                    }
                }
            }
        }
        return result;
    }

    public static double convertSell(List<PrivatAnswer> answer, double value, String initialCurrency, String finalCurrency)
    {
        double result = 0;
        if (initialCurrency.equalsIgnoreCase("uah"))
        {
            if (finalCurrency.equalsIgnoreCase("uah"))
            {
               result = value;
            }
            else
            {
                for (PrivatAnswer a : answer)
                {
                    if (a.getCcy().equalsIgnoreCase(finalCurrency))
                    {
                        result = new BigDecimal(value / a.getSale()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    }

                }
            }
        }
        for (PrivatAnswer a : answer)
        {
            if (a.getCcy().equalsIgnoreCase(initialCurrency))
            {
                if (finalCurrency.equalsIgnoreCase("uah"))
                {
                    result = new BigDecimal(a.getSale() * value).setScale(2, RoundingMode.HALF_UP).doubleValue();
                }
                else
                {
                    for (PrivatAnswer a1 : answer)
                    {
                        if (a1.getCcy().equalsIgnoreCase(finalCurrency))
                        {
                            result = new BigDecimal((a.getSale() * value) / a1.getSale()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        }
                    }
                }
            }
        }
        return result;
    }
}
