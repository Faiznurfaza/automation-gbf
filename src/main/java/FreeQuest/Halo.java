package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class Halo {
    public static void main(String[] args) {
        Halo object = new Halo();
        object.Play();
    }

    Screen screenInstance = new Screen();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayHalo();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayHalo() throws FindFailed {
        selectQuest();
        // selectSummon();
        finishHalo();
    }

    // private void selectQuest() throws FindFailed {
    // try {
    // Thread.sleep(1200);
    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // screenInstance.wait(ImagePath.GWQuest150, 15).click(ImagePath.GWQuest150);
    // screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
    // }

    // private void finishHalo() throws FindFailed {
    // System.out.println("Attack and Finishing Halo");

    // screenInstance.wait(ImagePath.LoadingSplashHalo, 15).click();
    // screenInstance.wait(ImagePath.YourTurn150, 70);
    // screenInstance.wait(ImagePath.BackButton150, 15).click();

    // while (screenInstance.exists(ImagePath.LoadingSplashHalo, 4) != null) {
    // screenInstance.wait(ImagePath.LoadingSplashHalo, 15).click();
    // screenInstance.wait(ImagePath.YourTurn150, 90);
    // screenInstance.wait(ImagePath.BackButton150, 15).click();
    // }
    // try {
    // Thread.sleep(800);
    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // }

    // Quick version
    private void selectQuest() throws FindFailed {
        screenInstance.wait(ImagePath.GWQuest150, 15).click(ImagePath.GWQuest150);
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
    }

    private void finishHalo() throws FindFailed {
        System.out.println("Attack and Finishing Halo");

        screenInstance.wait(ImagePath.LoadingSplashHalo, 15).click();
        screenInstance.wait(ImagePath.YourTurn150, 70);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        screenInstance.wait(ImagePath.LoadingSplashHalo, 15).click();
        screenInstance.wait(ImagePath.YourTurn150, 70);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        screenInstance.wait(ImagePath.LoadingSplashHalo, 15).click();
        screenInstance.wait(ImagePath.YourTurn150, 70);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
