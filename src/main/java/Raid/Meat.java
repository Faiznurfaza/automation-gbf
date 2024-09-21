package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class Meat {
    public static void main(String[] args) {
        Meat object = new Meat();
        object.Play();
    }

    Screen screenInstance = new Screen();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayFarmMeat();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayFarmMeat() throws FindFailed {
        screenInstance.click(ImagePath.GWQuest150);
        screenInstance.wait(ImagePath.Ygg150, 15).click(ImagePath.Ygg150);
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
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}