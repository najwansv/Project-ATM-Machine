package org.example;
import com.google.firebase.cloud.FirestoreClient;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class PinBahasa {

    private JPasswordField passwordField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton cancelButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton clearButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton enterButton;
    private JButton a0Button;
    public JPanel PanelPinBahasa;
    int i = 0;

    public PinBahasa() {
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

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField1.setText("");
            }
        });

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    int go = 0;
                    String inputtedPin = passwordField1.getText();
                    boolean checking = user.getUserPin(inputtedPin);
                    if (checking) {
                        go = 1;
                        System.out.println("PIN is correct");
                    } else {
                        System.out.println("PIN is incorrect");
                        JOptionPane.showMessageDialog(null, "PIN is incorrect");
                        if(i !=2){
                                var YesNo = JOptionPane.showConfirmDialog(null, "Do you want to Exit?", "Try Again", JOptionPane.YES_NO_OPTION);
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
                        JFrame next = MenuBahasa.main();
                        next.setContentPane(new MenuBahasa().PanelMenuBahasa);
                        PanelPinBahasa.setVisible(false);
                    } else if (go == 2) {
                        JOptionPane.showMessageDialog(null, "Take ur atm card");
                        System.exit(0);
                    } else if (go == 3) {
                        JOptionPane.showMessageDialog(null, "Try again");
                    } else if(i == 3){
                        JOptionPane.showMessageDialog(null, "You have entered the wrong PIN 3 times. Please try again later.");
                        System.exit(0);
                    }

                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static JFrame main() {
        JFrame frame = new JFrame("PinBahasa");
        frame.setContentPane(new PinBahasa().PanelPinBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

}

