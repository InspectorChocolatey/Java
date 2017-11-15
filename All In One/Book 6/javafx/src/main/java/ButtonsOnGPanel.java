import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * https://stackoverflow.com/questions/24715911/javafx-adding-button-to-grid-pane
 * 
 * */

public class ButtonsOnGPanel extends Application 
{
    private int i = 0;
    private GridPane gpnael = new GridPane();
    

    @Override
    public void start(Stage stage) throws Exception 
    {
        Pane root = new Pane();
        while(i<9)
        {
            addButton();
        }
        root.getChildren().add(gpnael);
        
        // create Scene-object scene with the Pane-object root as constructor.
        Scene scene = new Scene(root);
        
        // set the stage to Scene-object scene
        stage.setScene(scene);
        
        stage.setTitle("My Title");
        
        // show the stage to the user
        stage.show();
    }
    
    private void addButton()
    {
        i++;
        final Button temp = new Button("Button " + i);
        final int numButton= i;
        temp.setId("" + i);
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("id(" + temp.getId()  + ") =  " + numButton);
            }
        });
        gpnael.add(temp, i, 1);
    }
 
    public static void main(String[] args)
    {
        launch(args);
    }
}