package se.lexicon.jakob;

import com.sun.javafx.application.PlatformImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Graphics extends Application{
    //Objects
    private CustomTimer timer = new CustomTimer();
    private Buttons buttons = new Buttons();
    /**
     * ---------Button Initialization-----------------
     */
    public Button btnOn;
    public Button btnOff;
    public Button btnSelect;
    public Button decSec;
    public Button incSec;
    public Button btnW;
    public Button btnShift;
    /**
     * ---------Scene initialization------------------
     */
    public int sceneWidth = 300;
    public int sceneHeight = 150;
    public Canvas canvas = new Canvas(sceneWidth, sceneHeight);
    public GraphicsContext gc;
    
    
    public void start(Stage theStage) {
        
        /**------------Window settings-------------*/
        theStage.setTitle("Auto Clicker");  //Window title
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        theStage.setResizable(false);
    
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        
        /**------------Text settings-------------*/
        gc.setFill(Color.BLACK);
        javafx.scene.text.Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 14);
        gc.setFont(theFont);
        gc.fillText("Seconds ", 10, 130);
        gc.fillText("" + timer.seconds + "", 120, 130);
        
        /**------------Button graphic settings-------------*/
        btnOn = new Button("ON");
        btnOff = new Button("Off");
        btnSelect = new Button("Select Key");
        decSec = new Button("-");
        Button incSec = new Button("+");
        Button btnW = new Button("W");
        Button btnShift = new Button("Shift");
        
        root.getChildren().add(btnOn);
        root.getChildren().add(btnOff);
        root.getChildren().add(btnSelect);
        root.getChildren().add(decSec);
        root.getChildren().add(incSec);
        root.getChildren().add(btnW);
        root.getChildren().add(btnShift);
        
        btnOn.setPrefSize(80, 20);
        btnOff.setPrefSize(80, 20);
        btnSelect.setPrefSize(80, 20);
        incSec.setPrefSize(35, 30);
        decSec.setPrefSize(35, 30);
        btnW.setPrefSize(60, 20);
        btnShift.setPrefSize(60, 20);
        
        btnOn.setLayoutX(70);
        btnOn.setLayoutY(10);
        btnOff.setLayoutX(70);
        btnOff.setLayoutY(40);
        
        btnSelect.setLayoutX(70);
        btnSelect.setLayoutY(70);
        
        decSec.setLayoutX(70);
        decSec.setLayoutY(110);
        incSec.setLayoutX(145);
        incSec.setLayoutY(110);
        
        btnW.setLayoutX(220);
        btnW.setLayoutY(10);
        btnShift.setLayoutX(220);
        btnShift.setLayoutY(40);
        
        buttons.buttons();
        
        theStage.show();
    }
}
