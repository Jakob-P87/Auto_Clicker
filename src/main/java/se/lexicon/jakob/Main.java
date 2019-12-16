package se.lexicon.jakob;

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

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application
{
    /**
     * ---------Button Initialization-----------------
     */
    private Button btnOn = new Button("ON");
    private Button btnOff = new Button("Off");
    private Button btnSelect = new Button("Select Key");
    private Button decSec = new Button("-");
    private Button incSec = new Button("+");
    private Button btnW = new Button("W");
    private Button btnShift = new Button("Shift");

    /**
     * ---------Scene initialization------------------
     */
    private int sceneWidth = 300;
    private int sceneHeight = 150;
    private Canvas canvas = new Canvas(sceneWidth, sceneHeight);
    private GraphicsContext gc = canvas.getGraphicsContext2D();

    /**
     * ---------Functional variables initialization---
     */
    private int seconds;
    
    private Timer timerKeeper;
    private boolean keepRunning = true;

    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage theStage)
    {
        /**------------Window settings-------------*/
        theStage.setTitle("Auto Clicker");  //Window title
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        theStage.setResizable(false);


        root.getChildren().add(canvas);

        /**------------Text settings-------------*/
        gc.setFill(Color.BLACK);
        javafx.scene.text.Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 14);
        gc.setFont(theFont);
        gc.fillText("Seconds ", 10, 130);
        gc.fillText("" + seconds + "", 120, 130);

        /**------------Button graphic settings-------------*/
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

        buttons();

        theStage.show();
    }

    private void buttons()
    {
        /**------------Buttons functions-------------*/
        btnOn.setOnAction(e ->
        {
            timerKeeper = new Timer(); //Need to instantiate a new timer here
            if (seconds >= 1)
            {
                keepRunning = true;
                customTimer();
            }
        });

        btnOff.setOnAction(e ->
        {
            timerKeeper.cancel(); //Cancel the timer and remove the used timer
            keepRunning = false;
            System.out.println("Stop");
        });

        decSec.setOnAction(e ->
        {
            if (seconds > 0)
            {
                seconds -= 1;
                gc.clearRect(0, 0, sceneWidth, sceneHeight);
                gc.fillText("Seconds ", 10, 130);
                gc.fillText("" + seconds + "", 120, 130);
            }
        });

        incSec.setOnAction(e ->
        {
            if (seconds < 30)
            {
                seconds += 1;
                gc.clearRect(0, 0, sceneWidth, sceneHeight);
                gc.fillText("Seconds ", 10, 130);
                gc.fillText("" + seconds + "", 120, 130);
            }
        });

        btnW.setOnAction(e ->
        {

        });

        btnShift.setOnAction(e ->
        {

        });
    }

    private void customTimer()
    {
        timerKeeper.schedule(new TimerTask()
        {
            int second = seconds;

            @Override
            public void run()
            {
                

                gc.clearRect(0, 0, sceneWidth, sceneHeight);
                gc.fillText("Seconds ", 10, 130);
                gc.fillText("" + second + "", 120, 130);
                
                second -= 1;
                
                if (second <= 0 && keepRunning)
                {
                    System.out.println("Seconds:" + seconds);
                    startRobot();
                    second = seconds;
                }
            }
        }, 0, 1000);
    }

    private Robot robot;

    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
            e.printStackTrace();
        }
    }

    public void startRobot()
    {
        System.out.println("Button pressed");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(30);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        System.out.println("Button released");
    }
}
