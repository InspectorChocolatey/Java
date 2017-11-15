import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

//A synchronization aid that allows one or more threads to wait until 
//a set of operations being performed in other threads completes. 
import java.util.concurrent.CountDownLatch; 


import javax.swing.SwingUtilities;


public class MediaTools
{
	public static void main(String[] args) 
	{
		//String argOne = args[0];	
		
		String mp3 = "C:/Users/InspectorChocolatey/Desktop/Square Hammer.mp3";
		
		File f = new File(mp3);
		
		
		if(f.exists() && !f.isDirectory()) 
		{
			//Media med = new Media(new File(mp3).toURI().toString());
			
			final CountDownLatch latch = new CountDownLatch(1);
			SwingUtilities.invokeLater(new Runnable() {
			    public void run() {
			        new JFXPanel(); // initializes JavaFX environment
			        latch.countDown();
			    }
			});
			
			try 
			{
				latch.await();
				playMp3(mp3);
			}
			catch (InterruptedException ex)
			{
				
			}
			
			
			//final JFXPanel fxPanel = new JFXPanel(); 
			// JFXPanel needs to be instantiated for new MediaPlayer(med) 
			
			//MediaPlayer mediaPlayer = new MediaPlayer(med);
			//mediaPlayer.play();
		}
		else 
		{
			System.out.println("File not found: " + f);
			
		}
	}
	
	public static void playMp3(String mp3) 
	{
		File f = new File(mp3);
		Media med = new Media(new File(mp3).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(med);
		mediaPlayer.play();
	}
}