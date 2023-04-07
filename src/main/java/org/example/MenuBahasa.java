package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBahasa {
    public JPanel PanelMenuBahasa;
    private JButton tarikTunaiButton;
    private JButton setorTunaiButton;
    private JButton transferButton;
    private JButton cekSaldoRekeningButton;
    private JButton keluarButton;

    public MenuBahasa() {

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
                JFrame next = CekSaldoBahasa.main();
                next.setContentPane(new CekSaldoBahasa().PanelCekSaldoBahasa);
                PanelMenuBahasa.setVisible(false);
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame next = ChooseLang.main();
                next.setContentPane(new ChooseLang().PanelLanguage);
                PanelMenuBahasa.setVisible(false);
            }
        });
    }

    public static JFrame main() {
        JFrame frame = new JFrame("MenuBahasa");
        frame.setContentPane(new MenuBahasa().PanelMenuBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
