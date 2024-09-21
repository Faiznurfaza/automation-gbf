package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

public class Akasha {
    public static void main(String[] args) {
        Akasha object = new Akasha();
        object.startRaidLoop();
    }

    Screen screenInstance = new Screen();
    int initialValue = 1;

    private synchronized void startRaidLoop() {
        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;

        while (true) {
            try {
                executeAkashaRaid();
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void selectRaid() throws FindFailed {
        System.out.println("Choosing raid from raidfinder...");

        while (screenInstance.exists(ImagePath.RaidTargetAkasha, Constants.SHORT_WAIT) == null) {
            // System.out.println("Tidak ada akasha");
            screenInstance.type(Key.F5);
        }

        while (true) {
            screenInstance.click(ImagePath.RaidTargetAkasha);

            if (screenInstance.exists(ImagePath.MaxBackup150, Constants.SHORT_WAIT) != null) {
                // System.out.println("3/3 Akasha");
                screenInstance.type(Key.F5);
                screenInstance.wait(2.0);
                continue;
            }

            if (screenInstance.exists(ImagePath.PendingBattle150, Constants.SHORT_WAIT) != null) {
                // System.out.println("Akasha pending...");
                screenInstance.wait(ImagePath.PendingBookmark, 5).click();

                while (screenInstance.exists(ImagePath.AkashaPending150, Constants.SHORT_WAIT) != null) {
                    screenInstance.click(ImagePath.AkashaPending150);
                    screenInstance.wait(ImagePath.PendingBookmark, 5).click();
                }
                screenInstance.click(ImagePath.RaidBookmark);
                continue;
            }

            break;
        }
    }

    private void selectSummon() throws FindFailed {
        System.out.println("Choosing summon");

        while (screenInstance.exists(ImagePath.Hades150, 2) == null) {
            screenInstance.type(Key.PAGE_DOWN);
        }

        screenInstance.click(ImagePath.Hades150);
        try {
            Thread.sleep(Constants.SLEEP_DURATION);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.PartyOkBTN, Constants.LONG_WAIT).click(ImagePath.PartyOkBTN);
    }

    private void executeTurn1() throws FindFailed {
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();
        screenInstance.wait(ImagePath.Bubz150, 15);
        try {
            Thread.sleep(Constants.SLEEP_DURATION);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.BackButton150, 15).click();
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();
        try {
            Thread.sleep(Constants.SLEEP_DURATION);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.YourTurn150, 15);
        screenInstance.wait(ImagePath.BackButton150, 15).click();
        System.out.println("Waiting attack button and Turn 2");
    }

    private void executeTurn2() throws FindFailed {
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();
        screenInstance.wait(ImagePath.YourTurn150, 15);
        System.out.println("Moving to the next raid..");
    }

    private void executeAkashaRaid() throws FindFailed {
        System.out.println("Starting farm gold bar..");
        screenInstance.click(ImagePath.RaidBookmark);
        selectRaid();
        selectSummon();
        executeTurn1();
        executeTurn2();
    }
}