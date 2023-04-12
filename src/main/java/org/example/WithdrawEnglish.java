package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawEnglish {
    public JPanel PanelWithdrawEnglish;
    private JButton a100Button;
    private JButton a300Button;
    private JButton otherAmountButton;
    private JButton a200Button;
    private JTextArea chooseTheAmountYouTextArea;
    public WithdrawEnglish() {
        a100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a200Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a300Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        otherAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static JFrame main() {
        JFrame frame = new JFrame("WithdrawEnglish");
        frame.setContentPane(new WithdrawEnglish().PanelWithdrawEnglish);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
