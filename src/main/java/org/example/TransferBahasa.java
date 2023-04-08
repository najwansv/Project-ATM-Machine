package org.example;

import javax.swing.*;

public class TransferBahasa {
    public JPanel PanelTransferBahasa;

    public static JFrame main() {
        JFrame frame = new JFrame("TransferBahasa");
        frame.setContentPane(new TransferBahasa().PanelTransferBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
