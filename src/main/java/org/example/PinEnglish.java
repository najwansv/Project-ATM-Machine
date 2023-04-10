package org.example;

import com.google.firebase.cloud.FirestoreClient;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

//this is a test
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
        try {
            UserData.initBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserData user = new UserData(FirestoreClient.getFirestore());

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
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField1.setText("");
            }
        });
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputtedPin = passwordField1.getText();
                try {
                    boolean checking = user.getUserPin(inputtedPin);
                    if (checking) {
                        System.out.println("PIN is correct");
                        JFrame next = MenuBahasa.main();
                        next.setContentPane(new MenuBahasa().PanelMenuBahasa);
                        PanelPinEnglish.setVisible(false);
                    } else {
                        System.out.println("PIN is incorrect");
                        JOptionPane.showMessageDialog(null, "PIN is incorrect");
                    }

                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
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
