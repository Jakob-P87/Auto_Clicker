package se.lexicon.jakob;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SelectiveKeys
{
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

    public void robotShift()
    {
        System.out.println("Shift pressed");
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        System.out.println("Shift released");
    }

    public void robotKeyW()
    {
        System.out.println("Button pressed");
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_W);
        System.out.println("Button released");
    }
}
