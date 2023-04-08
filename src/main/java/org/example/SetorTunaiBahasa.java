package org.example;

import javax.swing.*;

public class SetorTunaiBahasa {
    public JPanel PanelSetorTunaiBahasa;
    public static JFrame main() {
        JFrame frame = new JFrame("SetorTunaiBahasa");
        frame.setContentPane(new SetorTunaiBahasa().PanelSetorTunaiBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
