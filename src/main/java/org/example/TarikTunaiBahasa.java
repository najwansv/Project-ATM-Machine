package org.example;

import javax.swing.*;

public class TarikTunaiBahasa {

    public JPanel PanelTarikTunaiBahasa;
    private JButton a100Button;
    private JButton a300Button;
    private JButton a200Button;
    private JTextArea pilihNominalYangInginTextArea;
    private JTextField textField1;

    public static JFrame main() {
        JFrame frame = new JFrame("TarikTunaiBahasa");
        frame.setContentPane(new TarikTunaiBahasa().PanelTarikTunaiBahasa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
}
