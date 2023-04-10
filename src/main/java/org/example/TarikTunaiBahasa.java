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
        int NominalTarik = userBalance[0];

        nominalLainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nominalLain = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nominal Yang Ingin Ditarik"));
                int opsiLain = userBalance[0] - nominalLain;
                JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp." + opsiLain);
            }
        });

        a100Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opsi100 = userBalance[0] - 100;
                JOptionPane.showMessageDialog(null, "Rp." + opsi100);
            }
        });
        a200Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opsi200 = userBalance[0] - 200;
                JOptionPane.showMessageDialog(null, "Rp." + opsi200);
            }
        });
        a300Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opsi300 = userBalance[0] - 300;
                JOptionPane.showMessageDialog(null, "Rp." + opsi300);
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
