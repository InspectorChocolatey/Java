import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Calcy extends Application
{
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	Button btn;
	
	Button btn0;
	Button btn1;
	Button btn2;
	Button btn3;
	Button btn4;
	Button btn5;
	Button btn6;
	Button btn7;
	Button btn8;
	Button btn9;
	
	@Override public void start(Stage primaryStage) 
	{
		// Create the button
		btn = new Button();
		btn.setText("Click on me please!");		
		btn.setOnAction(e -> buttonClick());
		
		// Add the button to a layout pane
		BorderPane pane = new BorderPane();
		pane.setCenter(btn);
		
		
		btn0 = new Button();
		
		btn0.setText("0");
		btn0.setTranslateX(100);
		btn0.setTranslateY(100);
		
		pane.
		
		// Add the layout pane to a scene
		Scene scene = new Scene(pane, 600, 250); //(pane, width, height)
		
		// Finalize and show the stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calcy"); // text for program name (upper left hand corner in the GUI) 
		primaryStage.show();
	}
	
	public void buttonClick() 
	{
		if(btn.getText() == "Click on me please!") 
		{
			btn.setText("You clicked me!");
		}
		else 
		{
			btn.setText("Click on me please!");
		}
	}
}