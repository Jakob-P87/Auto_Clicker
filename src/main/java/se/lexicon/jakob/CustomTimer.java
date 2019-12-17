package se.lexicon.jakob;

import java.util.Timer;
import java.util.TimerTask;

public class CustomTimer{
    
    //Custom variables
    public int seconds;
    boolean keepRunning = true;
    
    //Objects
    public Timer timerKeeper;
    private Graphics graphics;
    private RobotController robot = new RobotController();
    
    public void customTimer() {
        timerKeeper.schedule(new TimerTask(){
            int second = seconds;
            
            @Override
            public void run() {
                graphics.gc.clearRect(0, 0, graphics.sceneWidth, graphics.sceneHeight);
                graphics.gc.fillText("Seconds ", 10, 130);
                graphics.gc.fillText("" + second + "", 120, 130);
                
                second -= 1;
                
                if(second <= 0 && keepRunning) {
                    System.out.println("Seconds:" + seconds);
                    robot.robotShift();
                    second = seconds;
                }
            }
        }, 0, 1000);
    }
}
