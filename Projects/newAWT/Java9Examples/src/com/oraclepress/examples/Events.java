package com.oraclepress.examples;

import java.awt.*;
import java.awt.event.*;

/**
  * 
  * @author NicholasJ
  *
  * pages 787-789
  *
  * 
  *
  **/

public class Events extends Frame implements MouseListener, MouseMotionListener
{
	String msg = "";
	int mouseX = 0, mouseY = 0; // coordinates
	
	public Events() 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new MyWindowAdapter());		
	}
	
	/**
	  *	Handler Implementations 
	  **/
	
	
	
	
	// handles mouse clicked
	public void mouseClicked(MouseEvent me)
	{
		msg = msg + " -- click received";
		repaint();
	}
	// handles mouse clicked	
	
	
	
	
	
	
	
	// handles mouse entered
	public void mouseEntered(MouseEvent me) 
	{
		mouseX = 100;
		mouseY = 100;
		msg = "mouse entered";
		repaint();		
	}
	// handles mouse entered
	
	
	
	
	// handles mouse exited
	public void mouseExited(MouseEvent me) 
	{
		mouseX = 100;
		mouseY = 100;
		msg = "mouse exited";
		repaint();	
	}
	// handles mouse exited
	
	
	
	
	
	// handles mouse pressed	
	public void mousePressed(MouseEvent me) 
	{
		// save the coordinates
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "button down";
		repaint();	
	}
	// handles mouse pressed	
	
	
	
	
	// handles mouse released
	public void mouseReleased(MouseEvent me)
	{
		// save the coordinates
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Button released";
		repaint();	
	}
	// handles mouse released
	
	
	
	
	// handles mouse dragged
	public void mouseDragged(MouseEvent me) 
	{
		// save the coordinates
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "*" + " mouse at " + mouseX + ", " + mouseY;
		repaint();	
	}
	// handles mouse dragged
	
	
	
	
	
	// handles mouse moved
	public void mouseMoved(MouseEvent me) 
	{
		msg = "Moving mouse at " + me.getX() + ", " + me.getY();
		repaint();	
	}
	// handles mouse moved
	
	
	
	
	
	
	
	// Display msg current x,y location:
	public void paint(Graphics g) 
	{
		g.drawString(msg, mouseX, mouseY);
	}
	
	
	
	public static void main(String args[])
	{
		Events events = new Events();
		
		events.setSize(new Dimension(300,300));
		events.setTitle("Mouse Events dEMO");
		events.setVisible(true);
	}
	
	class MyWindowAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent we) 
		{
			System.exit(0);
		}
	}
}
