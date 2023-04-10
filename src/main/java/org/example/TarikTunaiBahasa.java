package org.example;

import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TarikTunaiBahasa {

    public JPanel PanelTarikTunaiBahasa;
    private JButton a100Button;
    private JButton a300Button;
    private JButton a200Button;
    private JTextArea pilihNominalYangInginTextArea;
    private JButton nominalLainButton;

    public TarikTunaiBahasa() throws ExecutionException, InterruptedException{
        try {
            UserData.initBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserData user = new UserData(FirestoreClient.getFirestore());
        final Integer[] userBalance = {user.getBalance()};
        int balance = userBalance[0];

        nominalLainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nominalLain = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nominal Yang Ingin Ditarik"));
                if(nominalLain > balance){
                    JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi");
                }else {
                    int opsiLain = balance - nominalLain;
                    JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp." + opsiLain);
                    try {
                        user.updateUserBalance(opsiLain);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                var YesNo = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Melakukan Transaksi Lain?", "Transaksi Lain", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinBahasa.main();
                    PanelTarikTunaiBahasa.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });

        a100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 100){
                    JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi");
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
                var YesNo = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Melakukan Transaksi Lain?", "Transaksi Lain", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinBahasa.main();
                    PanelTarikTunaiBahasa.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        a200Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 200){
                    JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi");
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
                var YesNo = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Melakukan Transaksi Lain?", "Transaksi Lain", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinBahasa.main();
                    PanelTarikTunaiBahasa.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
        a300Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(balance < 300){
                    JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi");
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
                var YesNo = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Melakukan Transaksi Lain?", "Transaksi Lain", JOptionPane.YES_NO_OPTION);
                if (YesNo == JOptionPane.YES_OPTION) {
                    PinBahasa.main();
                    PanelTarikTunaiBahasa.setVisible(false);
                } else {
                    System.exit(0);
                }
            }
        });
    }

    public static JFrame main() throws ExecutionException, InterruptedException {
        JFrame frame = new JFrame("TarikTunaiBahasa");
        frame.setContentPane(new TarikTunaiBahasa().PanelTarikTunaiBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
