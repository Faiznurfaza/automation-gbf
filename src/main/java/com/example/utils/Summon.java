package com.example.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Summon {
    Screen screenInstance = new Screen();

    public void selectSummon(Pattern summon) throws FindFailed {
        System.out.println("Choosing summon");

        int tries = 0;
        while (screenInstance.exists(summon, 2) == null) {
            if (tries == 3) {
                screenInstance.click(ImagePath.RandomSummon150);
                break;
            }
            tries++;
            screenInstance.type(Key.PAGE_DOWN);
        }
        // screenInstance.click(summon);
        if (screenInstance.exists(summon, 2) != null) {
            screenInstance.click(summon);
        }
        screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
    }
}