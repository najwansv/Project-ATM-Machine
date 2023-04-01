package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinEnglish {
    private JPasswordField passwordField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton CANCELButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton CLEARButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton ENTERButton;
    private JButton a0Button;
    public JPanel PanelPinEnglish;

    public PinEnglish() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(((JButton) e.getSource()).getText().trim());
                passwordField1.setText(passwordField1.getText() + value);
            }
        };
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a0Button.addActionListener(listener);
    }

    public static JFrame main() {
        JFrame frame = new JFrame("PinEnglish");
        frame.setContentPane(new PinEnglish().PanelPinEnglish);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        return frame;
    }
}
