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
        final Integer[] Userb = {user.getBalance()};

        tarikTunaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame next = TarikTunaiBahasa.main();
                next.setContentPane(new TarikTunaiBahasa().PanelTarikTunaiBahasa);
                PanelMenuBahasa.setVisible(false);
            }
        });
        setorTunaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame next = SetorTunaiBahasa.main();
                next.setContentPane(new SetorTunaiBahasa().PanelSetorTunaiBahasa);
                PanelMenuBahasa.setVisible(false);
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
                int balbal = Userb[0];
                JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp. " + balbal);
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
