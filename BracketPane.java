import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author chapo
 */

public class BracketPane{
    
    // private Bracket b;
    private TilePane[][] brackets;
    private ArrayList<String> teams;
    private Regions r;
    private FileInitializer fz;
    public BracketPane(){
        
		
        brackets = new TilePane[10][8];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 8; j++){
                // initial round - all teams present
                if(i == 0 || i == 9){
                    Label l = new Label("Sample Team " + j);
                    
                brackets[i][j] = new TilePane(l);
                }
                // second round - winners from each game
                else if (i == 1 || i == 8){
                    if(j % 2 == 0){
                        Label l = new Label("Sample");
                    
                    brackets[i][j] = new TilePane(l);
                    }
                    else{
                        Label l = new Label("");
                        brackets[i][j] = new TilePane(l);
                    }
                }
                
                else if (i == 3 || i == 6){
                    if(j % 5 == 0){
                        Label l = new Label("Sample");
                    
                    brackets[i][j] = new TilePane(l);
                    }
                    else{
                        Label l = new Label("");
                        brackets[i][j] = new TilePane(l);
                    }
                }
                else if (i == 4 || i == 5){
                    if(j % 10 == 0){
                        Label l = new Label("Sample");
                    
                    brackets[i][j] = new TilePane(l);
                    }
                    else{
                        Label l = new Label("");
                        brackets[i][j] = new TilePane(l);
                    }
                }
                else{
                    Label l = new Label("");
                        brackets[i][j] = new TilePane(l);
                }
            }
            
        }
        
    }
    

    
        public void display(){
        Stage window = new Stage();
        
        window.setTitle("Brackets");
        window.setMinWidth(250);
        //window.setFullScreen(true);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());
        
        
        GridPane layout = new GridPane();
        layout.setMinWidth(500);
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 8; j++)
                layout.add(brackets[i][j], i + 1, j + 1);
        }
        layout.add(closeButton, 5, 10);
        
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    
    }

}


