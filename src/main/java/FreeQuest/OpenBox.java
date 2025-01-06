package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Mouse;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class OpenBox {
    public static void main(String[] args) {
        OpenBox object = new OpenBox();
        object.Play();
    }

    Screen screenInstance = new Screen();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                OpenBoxing();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void OpenBoxing() throws FindFailed {
        screenInstance.click(ImagePath.ResultBookmark);
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e);
        }

        // screenInstance.wheel(Mouse.WHEEL_DOWN, 3);
        screenInstance.wait(ImagePath.DrawAll, 15).click(ImagePath.DrawAll);

        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println(e);
        }

        screenInstance.click(ImagePath.ResultBookmark);
        screenInstance.wait(ImagePath.ResetBox, 15).click(ImagePath.ResetBox);

        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }

        screenInstance.wait(ImagePath.OkReset, 15).click(ImagePath.OkReset);

        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.ConfirmedReset, 15).type(Key.F5);

    }
}
