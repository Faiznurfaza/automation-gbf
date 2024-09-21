package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class CEQ {
    public static void main(String[] args) {
        CEQ object = new CEQ();
        object.Play();
    }

    Screen screenInstance = new Screen();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayCEQ();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayCEQ() throws FindFailed {
        screenInstance.click(ImagePath.GWQuest150);
        screenInstance.wait(ImagePath.Kaguya150, 15).click();
        screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.YourTurn150, 15);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        try {
            Thread.sleep(600);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
