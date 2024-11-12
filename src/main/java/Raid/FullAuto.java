package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;
import com.example.utils.Summon;

public class FullAuto {
    public static void main(String[] args) {
        FullAuto object = new FullAuto();
        object.Play();
    }

    Screen screenInstance = new Screen();
    Summon summon = new Summon();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PlayFullAuto();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PlayFullAuto() throws FindFailed {
        screenInstance.click(ImagePath.GWQuest150);
        summon.selectSummon(ImagePath.Zephy150);

        screenInstance.wait(ImagePath.YourTurn150, 15);
        screenInstance.wait(ImagePath.BackButton150, 15).click();

        try {
            Thread.sleep(800);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
