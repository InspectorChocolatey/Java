import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class TestAlerts extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	
	Button btnAlertMe;
	Button btnAlertMe2;
	
	// Class field for stage
	Stage stage;
	
	@Override public void start(Stage primaryStage)
	{
		btnAlertMe = new Button();
		btnAlertMe.setText("Alert!");
		btnAlertMe.setOnAction( e -> btnAlertMe_Click() );
		
		btnAlertMe2 = new Button();
		btnAlertMe2.setText("Alert2!");
		btnAlertMe2.setOnAction( e -> btnAlertMe2_Click() );
		
		HBox pane = new HBox(10);
		
		pane.getChildren().addAll(btnAlertMe, btnAlertMe2);
		
		Scene scene = new Scene(pane, 250, 125);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Red Alert!");
		primaryStage.show();
	}
/*================================================================*/	
	
	public static void btnAlertMe_Click()
	{
		Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked one...");
		a.showAndWait();
	}
	public static void btnAlertMe2_Click()
	{
		Alert b = new Alert(Alert.AlertType.WARNING, "You have clicked two...");
		b.showAndWait();
	}
	
}