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
                int setor = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Jumlah Uang Yang Akan Disetor"));
                int setorTunai = balance + setor;
                JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp. " + setorTunai);
                try {
                    user.updateUserBalance(setorTunai);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                var YesorNo = JOptionPane.showConfirmDialog(null, "Apakah anda mempunyai transaksi lainnya?");
                if (YesorNo == JOptionPane.YES_OPTION) {
                    PanelMenuBahasa.setVisible(false);
                    PinBahasa.main();
                } else if (YesorNo == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else if (YesorNo == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                }
            }
        });
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog("Masukkan Nomor Rekening Tujuan");
                int transfer = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Jumlah Uang Yang Akan Ditransfer"));
                if(transfer > balance){
                    JOptionPane.showMessageDialog(null, "Saldo Anda Tidak Mencukupi");
                }else {
                    int transferTunai = userBalance[0] - transfer;
                    JOptionPane.showMessageDialog(null, "Transfer Berhasil, Saldo Anda Saat Ini Adalah Rp. " + transferTunai);
                }
                var YesorNo = JOptionPane.showConfirmDialog(null, "Apakah anda mempunyai transaksi lainnya?");
                if (YesorNo == JOptionPane.YES_OPTION) {
                    PanelMenuBahasa.setVisible(false);
                    PinBahasa.main();
                } else if (YesorNo == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }else if (YesorNo == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                }
            }
        });
        cekSaldoRekeningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo Anda Saat Ini Adalah Rp. " + balance);
                var YesorNo = JOptionPane.showConfirmDialog(null, "Apakah anda mempunyai transaksi lainnya?");
                if (YesorNo == JOptionPane.YES_OPTION) {
                    PanelMenuBahasa.setVisible(false);
                    PinBahasa.main();
                } else if (YesorNo == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }else if (YesorNo == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                }
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
