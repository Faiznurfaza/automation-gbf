package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class Replicard {
    public static void main(String[] args) {
        Replicard object = new Replicard();
        object.Play();
    }

    Screen screenInstance = new Screen();

    int run = 0;

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayReplicard();
                run++;
                System.out.println("Replicard Run: " + run);
                if (run == 200) {
                    break;
                }
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayReplicard() throws FindFailed {
        screenInstance.click(ImagePath.GWQuest150);
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
