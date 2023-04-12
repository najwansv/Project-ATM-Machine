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
                JFrame next = null;
                next = WithdrawEnglish.main();
                next.setContentPane(new WithdrawEnglish().PanelWithdrawEnglish);
                PanelMenuEnglish.setVisible(false);
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
                String NamaTujuan = "";
                int TransferTujuan = 0;

                String AccountNumber = JOptionPane.showInputDialog(null, "Enter your destination account number");
                try {
                    NamaTujuan = user.getName(AccountNumber);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    if(NamaTujuan == user.getName(AccountNumber)){
                        JOptionPane.showMessageDialog(null, "The Account number is not registered");
                        return;
                    }else{
                        JOptionPane.showMessageDialog(null, "The Account Name : " + NamaTujuan);
                    }
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                }
                int transfer = Integer.parseInt(JOptionPane.showInputDialog("Enter The Amount to Transfer"));
                // cek saldo
                if(transfer > balance){
                    JOptionPane.showMessageDialog(null, "Your balance is insufficient");
                }else {
                    try {
                        TransferTujuan = user.getUserBalance(user.getDestinationDocument(AccountNumber)) + transfer;
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    int transferTunai = balance - transfer;
                    var tru = JOptionPane.showConfirmDialog(null, "Are you Certain to Transfer to:\nA/N : "+ NamaTujuan + "\nAccount Number : " + AccountNumber,"Confirm the Transfer", JOptionPane.YES_NO_OPTION);
                    if(tru == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "The Transfer is Complete, Your Balance is Rp. " + transferTunai);
                        try {
                            user.updateUserBalance(transferTunai);
                            user.updateBalance(user.getDestinationDocument(AccountNumber),TransferTujuan);
                        } catch (ExecutionException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "The Transfer is Cancelled");
                    }
                }
                // opsi untuk melakukan transaksi lain
                var YesNo = JOptionPane.showConfirmDialog(null, "Do you have any more transaction", "Other Transaction", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinEnglish.main();
                    PanelMenuEnglish.setVisible(false);
                } else {
                    System.exit(0);
                }
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
