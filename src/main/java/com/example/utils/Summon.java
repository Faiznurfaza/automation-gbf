package com.example.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Summon {
    Screen screenInstance = new Screen();

    public void selectSummon(ImagePath summon) throws FindFailed {
        System.out.println("Choosing summon");

        screenInstance.wait(summon).click(summon);
        screenInstance.wait(ImagePath.PartyOkBTN, 15).click(ImagePath.PartyOkBTN);
    }
}