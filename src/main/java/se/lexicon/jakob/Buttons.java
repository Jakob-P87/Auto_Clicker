package se.lexicon.jakob;

import java.util.Timer;

public class Buttons{
    
    //Objects
    public RobotController robot;
    private CustomTimer timer = new CustomTimer();
    private Graphics graphics;
    
    public void buttons()
    {
        try{
            /**------------Buttons functions-------------*/
            graphics.btnOn.setOnAction(e ->
                                   {
                                       timer.timerKeeper = new Timer();
                                       if(timer.seconds >= 1) {
                                           timer.keepRunning = true;
                                           timer.customTimer();
                                       }
                                   });
    
            graphics.btnOff.setOnAction(e ->
                                    {
                                        timer.timerKeeper.cancel(); //Cancel the timer and remove the used timer
                                        timer.timerKeeper.purge();
                                        timer.keepRunning = false;
                                        System.out.println("Stop");
                                    });
    
            graphics.decSec.setOnAction(e ->
                                    {
                                        if(timer.seconds > 0) {
                                            timer.seconds -= 1;
                                            graphics.gc.clearRect(0, 0, graphics.sceneWidth, graphics.sceneHeight);
                                            graphics.gc.fillText("Seconds ", 10, 130);
                                            graphics.gc.fillText("" + timer.seconds + "", 120, 130);
                                        }
                                    });
    
            graphics.incSec.setOnAction(e ->
                                    {
                                        if(timer.seconds < 30) {
                                            timer.seconds += 1;
                                            graphics.gc.clearRect(0, 0, graphics.sceneWidth, graphics.sceneHeight);
                                            graphics.gc.fillText("Seconds ", 10, 130);
                                            graphics.gc.fillText("" + timer.seconds + "", 120, 130);
                                        }
                                    });
    
            graphics.btnW.setOnAction(e ->
                                  {
        
                                  });
    
            graphics.btnShift.setOnAction(e ->
                                      {
        
                                      });
        }catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
