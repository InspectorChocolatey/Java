package com.generalparts.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
  * 
  * @author NicholasJ
  *
  *	References:
  *
  *		https://docs.oracle.com/javase/7/docs/api/java/awt/Button.html
  *
  *
  **/

public class FullScreenFrame extends JFrame implements KeyListener 
{
	/* Instance of the class */
	public FullScreenFrame() 
	{
        addKeyListener(this);
        //setUndecorated(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        
        //Button button = new Button("Exit");
        
        
        
        if (gd.isFullScreenSupported()) 
        {
            //try {
        	setUndecorated(true);
            gd.setFullScreenWindow(this);
            //}
            //finally {
            //    gd.setFullScreenWindow(null);
            //}
        }
        else 
        {
            System.err.println("Full screen not supported");
        }

        setVisible(true);
    }

    public void keyTyped(KeyEvent e) 
    {
    	
    }
    public void keyPressed(KeyEvent e) 
    {
    	
    }
    public void keyReleased(KeyEvent e) 
    {
        setVisible(false);
        dispose();
    }

    public static void main (String [] args) {
        new FullScreenFrame();
    }
	
}
