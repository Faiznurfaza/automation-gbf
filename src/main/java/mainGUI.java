import FreeQuest.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGUI {
    private Event freeQuestEvent = new Event();

    public static void main(String[] args) {
        mainGUI mainGUI = new mainGUI();
        mainGUI.createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Automation Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JButton freeQuestButton = new JButton("Play FreeQuest");
        JButton stopButton = new JButton("Stop");

        freeQuestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freeQuestEvent.startEvent();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freeQuestEvent.stopEvent();
            }
        });

        JPanel panel = new JPanel();
        panel.add(freeQuestButton);
        panel.add(stopButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}