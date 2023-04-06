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
