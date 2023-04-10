package org.example;

import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MenuBahasa {
    public JPanel PanelMenuBahasa;
    private JButton tarikTunaiButton;
    private JButton setorTunaiButton;
    private JButton transferButton;
    private JButton cekSaldoRekeningButton;
    private JButton keluarButton;


    public MenuBahasa() throws ExecutionException, InterruptedException {
        try {
            UserData.initBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserData user = new UserData(FirestoreClient.getFirestore());
        final Integer[] userBalance = {user.getBalance()};
        int balance = userBalance[0];
        tarikTunaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame next = null;
                try {
                    next = TarikTunaiBahasa.main();
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    next.setContentPane(new TarikTunaiBahasa().PanelTarikTunaiBahasa);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                PanelMenuBahasa.setVisible(false);
            }
        });
        setorTunaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            JOptionPane.showInputDialog("Masukkan Jumlah Uang Yang Akan Disetor")
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame next = TransferBahasa.main();
                next.setContentPane(new TransferBahasa().PanelTransferBahasa);
                PanelMenuBahasa.setVisible(false);
            }
        });
        cekSaldoRekeningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp. " + balance);
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static JFrame main() throws ExecutionException, InterruptedException {
        JFrame frame = new JFrame("MenuBahasa");
        frame.setContentPane(new MenuBahasa().PanelMenuBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
