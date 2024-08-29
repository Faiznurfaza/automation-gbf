package main.java.com.example;

import org.sikuli.script.Screen;

import main.java.com.example.utils.ImageChecker;

import org.sikuli.script.FindFailed;
import org.sikuli.basics.Settings;

public class Example {
    public static void main(String[] args) {
        Screen screen = new Screen();
        Settings.MoveMouseDelay = 0;
        // try {
        // // screen.wait(ImageChecker.IMAGE, 10);
        // // screen.click(ImageChecker.IMAGE);
        // } catch (FindFailed e) {
        // e.printStackTrace();
        // }
    }
}