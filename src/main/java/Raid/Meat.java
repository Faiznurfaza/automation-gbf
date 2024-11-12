package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
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
        int run = 0;

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (run < 499) {
            try {
                run++;
                System.out.println("Run NM90: " + run);
                PlayFarmMeat();

            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayFarmMeat() throws FindFailed {
        screenInstance.click(ImagePath.GWQuest150);
        int tries = 0;
        while (screenInstance.exists(ImagePath.Zephy150, 2) == null) {
            if (tries == 3) {
                screenInstance.click(ImagePath.RandomSummon150);
                break;
            }
            tries++;
            screenInstance.type(Key.PAGE_DOWN);
        }
        // screenInstance.click(ImagePath.Zephy150);
        if (screenInstance.exists(ImagePath.Zephy150, 2) != null) {
            screenInstance.click(ImagePath.Zephy150);
        }

        // screenInstance.wait(ImagePath.Zephy150, 15).click(ImagePath.Zephy150);
        // screenInstance.wait(ImagePath.RandomSummon150,
        // 15).click(ImagePath.RandomSummon150);
        screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
        // screenInstance.wait(ImagePath.FA150, 15).click(ImagePath.FA150);
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click(ImagePath.LoadingSplash150);

        screenInstance.wait(ImagePath.YourTurn150, 15);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        while (screenInstance.exists(ImagePath.FA150, 4) != null) {
            screenInstance.click(ImagePath.FA150);
            screenInstance.wait(ImagePath.YourTurn150, 15);
            screenInstance.wait(ImagePath.BackButton150, 15).click();
        }

    }
}