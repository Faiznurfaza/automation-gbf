package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Mouse;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class PickupCrate {
    public static void main(String[] args) {
        PickupCrate object = new PickupCrate();
        object.Play();
    }

    Screen screenInstance = new Screen();

    private synchronized void Play() {

        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                PickingUp();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void PickingUp() throws FindFailed {
        screenInstance.wait(ImagePath.PickAll, 15).click(ImagePath.PickAll);

        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println(e);
        }

        screenInstance.wait(ImagePath.OkButton, 15).click(ImagePath.OkButton);

        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println(e);
        }

        screenInstance.wait(ImagePath.OkButton, 15).click(ImagePath.OkButton);

    }
}
