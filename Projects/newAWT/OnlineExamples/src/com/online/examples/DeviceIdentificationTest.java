package com.online.examples;


import java.util.concurrent.TimeUnit;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
  *		References:   
  *        
  *        
  *        https://alvinalexander.com/java/jwarehouse/openjdk-8/jdk/test/java/awt/Multiscreen/DeviceIdentificationTest/DeviceIdentificationTest.java.shtml
  *        https://stackoverflow.com/questions/10630738/how-to-set-strings-font-size-style-in-java-using-the-font-class
  *        
  *        https://stackoverflow.com/questions/24104313/how-to-delay-in-java
  *        
  **/

public class DeviceIdentificationTest 
{
	
	

	/* main */
    public static void main(String args[]) 
    {
    	
        final Frame f = new Frame("DeviceIdentificationTest");
        
        /* Window Listener */
        f.addWindowListener(
        		
        		/*Window Adapter*/        		
        		new WindowAdapter()
        		{
        			public void windowClosing(WindowEvent e) 
        			{
        				f.dispose();
        			}
        		}
        		/*Window Adapter*/
        		
        	);
        /* Window Listener */
    
        
        
        
        /* Component Listener */
        f.addComponentListener(
        		
        		/*Component Adapter*/
        		new ComponentAdapter() 
        		{
        			public void componentMoved(ComponentEvent e) 
        			{
        				f.setTitle("Currently on: " + f.getGraphicsConfiguration().getDevice());
        			}
        		}
        		/*Component Adapter*/
        		
        	);
        /* Component Listener */
        
        
        
        
        
        
        Panel p = new Panel();

        
        
        
        
        // Print Current Devices button
        Button b = new Button("Print Current Devices");
        /* ActionListener */
        b.addActionListener(
        		
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				GraphicsDevice gds[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        				int i = 0;
        				
        				System.out.println("--- Devices: ---");
                
        				for (GraphicsDevice gd : gds) 
        				{
        					System.out.println("Device["+i+"]= "+ gd);
        					System.out.println("  bounds = " + gd.getDefaultConfiguration().getBounds());
        					i++;
        				}
        				System.out.println("-------------------");
        			}
        		}
        		
        	);
        /* ActionListener */
        p.add(b);
        // Print Current Devices button        
        
        
        

        
        // Print My Device button
        b = new Button("Print My Device");
        /* ActionListener */
        b.addActionListener(
        		
        		new ActionListener() 
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				GraphicsConfiguration gc = f.getGraphicsConfiguration();
        				GraphicsDevice gd = gc.getDevice();
        				System.out.println("--- My Device ---");
        				System.out.println("Device  = " + gd);
        				System.out.println(" bounds = " + gd.getDefaultConfiguration().getBounds());
        			}
        		}
        	
        	);
        /* ActionListener */
        p.add(b);
        // Button: Print My Device
        
        
        
        // Button: FullScreen
        b = new Button("FullScreen");
        /* ActionListener */
        b.addActionListener(
        		
        		new ActionListener() 
        		{
        			public void actionPerformed(ActionEvent e)
        			{
        				GraphicsConfiguration gc = f.getGraphicsConfiguration();
        				final GraphicsDevice gd = gc.getDevice();
        				
        				System.out.println("--- Creating FS Frame on Device ---");
        				System.out.println("Device  = " + gd);
        				System.out.println(" bounds = " + gd.getDefaultConfiguration().getBounds());
                
        				/* AWT fullscreen */
        				final Frame fsf = new Frame("FullScreen" + gd, gc) 
        				{
        					public void paint(Graphics g)
        					{
        						g.setColor(Color.black);
        						g.fillRect(0, 0, getWidth(), getHeight());
        						g.setColor(Color.gray );
        						
        						Font myFont = new Font("Serif", Font.BOLD, 24);
        						
        						g.setFont(myFont);
        						g.drawString("FS on device: " + gd, 200, 200);
        						g.drawString("Click to exit Full-screen.", 200, 250);
        						
    							int i = 1;
        						
    							int yLoc = 300;
    							
        						while(i < 10) 
        						{
        							yLoc = yLoc + 25;
        							
        							g.drawString("Lorum ipsum quia dolor sit amet, consectetur, adipisci velit: " + i, 200, yLoc);
        							
        							try 
        							{
										TimeUnit.SECONDS.sleep(1);
									} 
        							catch (InterruptedException e) 
        							{
        								g.drawString(e.getMessage().toString(), 200, yLoc);
									}
        							++i;
        						}
        						g.drawString("Input Command: ", 200, yLoc+25);
        					}
        				};
                
        				fsf.setUndecorated(true);
                
        				fsf.addMouseListener(
                		
        						new MouseAdapter() 
        						{
        							public void mouseClicked(MouseEvent e) 
        							{
        								gd.setFullScreenWindow(null);
        								fsf.dispose();
        							}
        						}
        					);
        				
        				gd.setFullScreenWindow(fsf);
        		}
        	}
        
        	);
        /* ActionListener */
        p.add(b);
        // Button: Create FS Frame on my Device        
        
        
        
        
        
        f.add("North", p);
        p = new Panel();
        b = new Button("Test Passed");
        
        // b.setBackground(Color.cyan);

        
        
        
        /* ActionListener */        
        b.addActionListener(
        		
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				System.out.println("Test Passed");
        				f.dispose();
        			}
        		}
        	
        	);
        /* ActionListener */
        
        
        
        p.add(b);
        b = new Button("Test Failed");
        //b.setBackground(Color.red);
        
        
        
        
        
        
        /* ActionListener */
        b.addActionListener(
        		
        		new ActionListener() 
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				System.out.println("Test FAILED");
        				f.dispose();
                
        				throw new RuntimeException("Test FAILED");
        			}
        		}
        	
        	);
        /* ActionListener */
        
        
        
        
        
        
        p.add(b);
        f.add("South", p);
        f.pack();
        f.setVisible(true);
        
    }
	/* main */
    
    
    

}