package Raid;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;
import com.example.utils.Summon;

public class RaidEvent {
    public static void main(String[] args) {
        RaidEvent object = new RaidEvent();
        object.startRaidLoop();
    }

    Screen screenInstance = new Screen();
    Summon summon = new Summon();
    int initialValue = 0;

    private synchronized void startRaidLoop() {
        Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
        while (true) {
            try {
                executeRaidEventFarm();
                initialValue++;
                System.out.println("Raid count: " + initialValue);
            } catch (FindFailed e) {
                System.out.println("Failed to find an element. Restarting..");
            }
        }
    }

    private void selectRaid() throws FindFailed {
        System.out.println("Choosing raid from raidfinder...");

        while (screenInstance.exists(ImagePath.Shenxian, Constants.SHORT_WAIT) == null) {
            screenInstance.type(Key.F5);
        }

        while (true) {
            screenInstance.click(ImagePath.Shenxian);

            if (screenInstance.exists(ImagePath.MaxBackup150, Constants.SHORT_WAIT) != null) {
                // System.out.println("3/3 Akasha");
                screenInstance.type(Key.F5);
                screenInstance.wait(2.0);
                continue;
            }

            if (screenInstance.exists(ImagePath.PendingBattle150, Constants.SHORT_WAIT) != null) {
                // System.out.println("Akasha pending...");
                screenInstance.wait(ImagePath.PendingBookmark, 5).click();

                while (screenInstance.exists(ImagePath.PendingShenxian, Constants.SHORT_WAIT) != null) {
                    screenInstance.click(ImagePath.PendingShenxian);
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

        screenInstance.wait(ImagePath.PartyOkBTN, Constants.SHORT_WAIT).click(ImagePath.PartyOkBTN);
    }

    private void executeTurn1() throws FindFailed {
        screenInstance.wait(ImagePath.LoadingSplash150, 15).click();

        try {
            Thread.sleep(900);
        } catch (Exception e) {
            System.out.println(e);
        }
        screenInstance.wait(ImagePath.YourTurn150, 15);
        System.out.println("Moving to the next raid..");
    }

    private void executeRaidEventFarm() throws FindFailed {
        System.out.println("Starting Shenxian raid...");
        screenInstance.wait(ImagePath.RaidEvent, 15).click(ImagePath.RaidEvent);
        selectRaid();
        selectSummon();
        executeTurn1();
    }
}
