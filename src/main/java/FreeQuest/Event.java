package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class Event {
    public static void main(String[] args) {
        Event object = new Event();
        object.Play();
    }

    Screen screenInstance = new Screen();

    int run = 0;

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayEvent();
                run++;
                System.out.println("Event Run: " + run);
                if (run == 1000) {
                    try {
                        Thread.sleep(4200000); // 1 hour 10 minutes
                        System.out.println("Break for 1 hour 10 minutes");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayEvent() throws FindFailed {

        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println(e);
        }

        selectQuest();
        selectSummon();
        finishEvent();

    }

    private void selectQuest() throws FindFailed {
        System.out.println("Choosing quest");

        screenInstance.wait(ImagePath.GWQuest150).click(ImagePath.GWQuest150);
        while (screenInstance.exists(ImagePath.RandomSummon150, 15) == null) {
            screenInstance.type(Key.F5);
        }
    }

    private void selectSummon() throws FindFailed {
        System.out.println("Choosing summon");

        screenInstance.click(ImagePath.RandomSummon150);
        screenInstance.wait(ImagePath.PartyOkBTN, 3600).click();
    }

    private void finishEvent() throws FindFailed {
        System.out.println("Attacking...");

        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();
        try {
            Thread.sleep(900);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.YourTurn150, 15);
        screenInstance.wait(ImagePath.BackButton150, 15).click();
    }
}
