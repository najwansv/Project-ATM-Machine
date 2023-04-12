package org.example;

import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class WithdrawEnglish {
    public JPanel PanelWithdrawEnglish;
    private JButton a100Button;
    private JButton a300Button;
    private JButton otherAmountButton;
    private JButton a200Button;
    private JTextArea chooseTheAmountYouTextArea;
    public WithdrawEnglish() throws ExecutionException, InterruptedException{
        try {
            UserData.initBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserData user = new UserData(FirestoreClient.getFirestore());
        final Integer[] userBalance = {user.getBalance()};
        int balance = userBalance[0];
        a100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 100){
                    JOptionPane.showMessageDialog(null, "Your Balance is Insufficient");
                }else {
                    int opsi100 = balance - 100;
                    JOptionPane.showMessageDialog(null, "Rp." + opsi100);
                    try {
                        user.updateUserBalance(opsi100);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Do You Want to do Another Transaction?", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelWithdrawEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        a200Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 200){
                    JOptionPane.showMessageDialog(null, "Your Balance is Insufficient");
                }else {
                    int opsi200 = balance - 200;
                    JOptionPane.showMessageDialog(null, "Rp." + opsi200);
                    try {
                        user.updateUserBalance(opsi200);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Do You Want to do Another Transaction?", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelWithdrawEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        a300Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 300){
                    JOptionPane.showMessageDialog(null, "Your Balance is Insufficient");
                }else {
                    int opsi300 = balance - 300;
                    JOptionPane.showMessageDialog(null, "Rp." + opsi300);
                    try {
                        user.updateUserBalance(opsi300);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Do You Want to do Another Transaction?", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelWithdrawEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        otherAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nominalLain = Integer.parseInt(JOptionPane.showInputDialog("Input The Amount you Want to Withdraw"));
                if(nominalLain > balance){
                    JOptionPane.showMessageDialog(null, "Your Balance is Insufficient");
                }else {
                    int opsiLain = balance - nominalLain;
                    JOptionPane.showMessageDialog(null, "Your Balance is Rp." + opsiLain);
                    try {
                        user.updateUserBalance(opsiLain);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Do You Want to do Another Transaction?", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelWithdrawEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
    }
    public static JFrame main() throws ExecutionException, InterruptedException {
        JFrame frame = new JFrame("WithdrawEnglish");
        frame.setContentPane(new WithdrawEnglish().PanelWithdrawEnglish);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
