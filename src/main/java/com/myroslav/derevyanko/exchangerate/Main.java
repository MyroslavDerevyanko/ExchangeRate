package com.myroslav.derevyanko.exchangerate;

import com.myroslav.derevyanko.exchangerate.GUI.MainFrame;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myroslav_D
 */
public class Main
{

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    new MainFrame().setVisible(true);
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }
}
