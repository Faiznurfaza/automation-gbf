package FreeQuest;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.example.utils.Constants;
import com.example.utils.ImagePath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event {
    private Screen screenInstance = new Screen();
    private volatile boolean running = false;
    private Thread eventThread;

    public static void main(String[] args) {
        Event object = new Event();
        object.createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Automation Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEvent();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEvent();
            }
        });

        JPanel panel = new JPanel();
        panel.add(playButton);
        panel.add(stopButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public synchronized void startEvent() {
        if (running) {
            return;
        }
        running = true;
        eventThread = new Thread(() -> {
            Settings.MoveMouseDelay = Constants.MOUSE_DELAY;
            while (running) {
                try {
                    PlayEvent();
                } catch (FindFailed e) {
                    System.out.println("Failed to find an element. Restarting..");
                }
                break;
            }
        });
        eventThread.start();
    }

    public synchronized void stopEvent() {
        running = false;
        System.out.println("Stopping the program..");
        if (eventThread != null) {
            try {
                eventThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void PlayEvent() throws FindFailed {
        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (!running) {
            System.out.println("Stopping the program..");
            return;
        }
        selectQuest();
        if (!running) {
            System.out.println("Stopping the program..");
            return;
        }
        selectSummon();
        if (!running) {
            System.out.println("Stopping the program..");
            return;
        }
        finishEvent();
    }

    private void selectQuest() throws FindFailed {
        System.out.println("Choosing quest");

        screenInstance.wait(ImagePath.GWQuest150).click(ImagePath.GWQuest150);
        while (running && screenInstance.exists(ImagePath.RandomSummon150, 15) == null) {
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
        if (!running)
            return;
        screenInstance.wait(ImagePath.YourTurn150, 15);
        if (!running)
            return;
        screenInstance.wait(ImagePath.BackButton150, 15).click();
    }
}