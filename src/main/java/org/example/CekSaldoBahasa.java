package org.example;

import javax.swing.*;

public class CekSaldoBahasa {
    public JPanel PanelCekSaldoBahasa;

    public static JFrame main() {
        JFrame frame = new JFrame("CekSaldoBahasa");
        frame.setContentPane(new CekSaldoBahasa().PanelCekSaldoBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
