package main.java.com.example;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import main.java.com.example.utils.Constants;
import main.java.com.example.utils.ImageChecker;

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
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void selectRaid() throws FindFailed {
        System.out.println("Choosing raid from raidfinder...");

        while (screenInstance.exists(ImageChecker.RaidTargetAkasha, Constants.SHORT_WAIT) == null) {
            System.out.println("Tidak ada akasha");
            screenInstance.type(Key.F5);
        }

        while (true) {
            screenInstance.click(ImageChecker.RaidTargetAkasha);

            if (screenInstance.exists(ImageChecker.MaxBackup150, Constants.SHORT_WAIT) != null) {
                System.out.println("3/3 Akasha");
                screenInstance.type(Key.F5);
                screenInstance.wait(2.0);
                continue;
            }

            if (screenInstance.exists(ImageChecker.PendingBattle150, Constants.SHORT_WAIT) != null) {
                System.out.println("Akasha pending...");
                screenInstance.wait(ImageChecker.PendingBookmark, 5).click();

                while (screenInstance.exists(ImageChecker.AkashaPending150, Constants.SHORT_WAIT) != null) {
                    screenInstance.click(ImageChecker.AkashaPending150);
                    screenInstance.wait(ImageChecker.PendingBookmark, 5).click();
                }

                screenInstance.click(ImageChecker.RaidBookmark);
                continue;
            }

            break;
        }
    }

    private void selectSummon() throws FindFailed {
        System.out.println("Choosing summon");

        while (screenInstance.exists(ImageChecker.Hades150, 2) == null) {
            screenInstance.type(Key.PAGE_DOWN);
        }

        screenInstance.click(ImageChecker.Hades150);
        pause(Constants.SLEEP_DURATION);
        screenInstance.wait(ImageChecker.PartyOkBTN, Constants.LONG_WAIT).click(ImageChecker.PartyOkBTN);
    }

    private void executeTurn1() throws FindFailed {
        screenInstance.wait(ImageChecker.LoadingSplash150, 15).click();
        screenInstance.wait(ImageChecker.Bubz150, 15);
        pause(Constants.SLEEP_DURATION);
        screenInstance.wait(ImageChecker.BackButton150, 15).click();
        screenInstance.wait(ImageChecker.LoadingSplash150, 15).click();
        pause(Constants.SLEEP_DURATION);
        screenInstance.wait(ImageChecker.YourTurn150, 15);
        screenInstance.wait(ImageChecker.BackButton150, 15).click();
        System.out.println("Waiting attack button and Turn 2");
    }

    private void executeTurn2() throws FindFailed {
        screenInstance.wait(ImageChecker.LoadingSplash150, 15).click();
        screenInstance.wait(ImageChecker.YourTurn150, 15);
        System.out.println("Moving to the next raid..");
    }

    private void executeAkashaRaid() throws FindFailed {
        System.out.println("Starting farm gold bar..");
        screenInstance.click(ImageChecker.RaidBookmark);
        selectRaid();
        selectSummon();
        executeTurn1();
        executeTurn2();
    }

    private void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}