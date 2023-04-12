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
    int i = 0;

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
                try {
                    int go = 0;
                    String inputtedPin = passwordField1.getText();
                    boolean checking = user.getUserPin(inputtedPin);
                    if (checking) {
                        go = 1;
                        System.out.println("The PIN is Correct");
                    } else {
                        System.out.println("The PIN is Incorrect");
                        JOptionPane.showMessageDialog(null, "The PIN is Incorrect");
                        if(i !=2){
                            var YesNo = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Try again", JOptionPane.YES_NO_OPTION);
                            if(YesNo == JOptionPane.YES_OPTION) {
                                go = 2;
                            } else if (YesNo == JOptionPane.NO_OPTION) {
                                go = 3;
                                i++;
                            }
                        }else{
                            i++;
                        }
                    }
                    if(go == 1){
                        JFrame next = MenuEnglish.main();
                        next.setContentPane(new MenuEnglish().PanelMenuEnglish);
                        PanelPinEnglish.setVisible(false);
                    } else if (go == 2) {
                        JOptionPane.showMessageDialog(null, "Please Take your Card");
                        System.exit(0);
                    } else if (go == 3) {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    } else if(i == 3){
                        JOptionPane.showMessageDialog(null, "You have entered the PIN 3 times incorrectly. Please Try again Later.");
                        System.exit(0);
                    }

                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Please take your card");
                System.exit(0);
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
