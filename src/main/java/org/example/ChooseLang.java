package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseLang {
    private JButton BahasaButton;
    private JButton EnglishButton;
    public JPanel PanelLanguage;

public static JFrame main() {
    JFrame frame = new JFrame("ChooseLang");
    frame.setContentPane(new ChooseLang().PanelLanguage);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    return frame;
}

public ChooseLang() {

    BahasaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame next = PinBahasa.main();
            next.setContentPane(new PinBahasa().PanelPinBahasa);
            PanelLanguage.setVisible(false);
        }
    });

    EnglishButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame next = PinEnglish.main();
            next.setContentPane(new PinEnglish().PanelPinEnglish);
            PanelLanguage.setVisible(false);
        }
    });
}
}
