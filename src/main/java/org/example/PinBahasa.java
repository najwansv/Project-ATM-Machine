package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public PinBahasa() {

        UserData user = new UserData();
        final String[] UserPin = {user.getUserPin()};

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
                UserPin[0] = passwordField1.getText();
                if (UserPin[0].equals("1234")) {
//                    JOptionPane.showMessageDialog(null, "Pin benar");

                    JFrame next = MenuBahasa.main();
                    next.setContentPane(new MenuBahasa().PanelMenuBahasa);
                } else {
                    JOptionPane.showMessageDialog(null, "Pin salah");
                }
                System.out.println(UserPin[0]);
                passwordField1.setText("");
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

