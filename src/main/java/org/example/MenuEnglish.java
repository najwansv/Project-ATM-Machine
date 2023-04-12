package org.example;

import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MenuEnglish {
    private JButton withdrawButton;
    private JButton balanceButton;
    private JButton depositButton;
    private JButton exitButton;
    private JButton transferButton;
    public JPanel PanelMenuEnglish;

    public MenuEnglish() throws ExecutionException, InterruptedException {
        try {
            UserData.initBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserData user = new UserData(FirestoreClient.getFirestore());
        final Integer[] userBalance = {user.getBalance()};
        int balance = userBalance[0];
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int setor = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount to deposit"));
                int setorTunai = balance + setor;
                JOptionPane.showMessageDialog(null, "Your balance is Rp. " + setorTunai);
                try {
                    user.updateUserBalance(setorTunai);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Do you have any more transaction", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelMenuEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your Balance is Rp. " + balance);
                var YesNo = JOptionPane.showConfirmDialog(null, "Do you have any more transaction", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelMenuEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static JFrame main() throws ExecutionException, InterruptedException{
        JFrame frame = new JFrame("MenuEnglish");
        frame.setContentPane(new MenuEnglish().PanelMenuEnglish);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
