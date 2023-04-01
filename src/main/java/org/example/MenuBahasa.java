package org.example;

import javax.swing.*;

public class MenuBahasa {
    public JPanel PanelMenuBahasa;
    private JButton tarikTunaiButton;
    private JButton setorTunaiButton;
    private JButton transferButton;
    private JButton cekSaldoRekeningButton;
    private JButton keluarButton;

    public static JFrame main() {
        JFrame frame = new JFrame("MenuBahasa");
        frame.setContentPane(new MenuBahasa().PanelMenuBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
