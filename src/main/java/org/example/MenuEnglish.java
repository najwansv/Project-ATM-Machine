/*
 * Created by JFormDesigner on Mon Apr 03 09:47:11 ICT 2023
 */

package org.example;

import javax.swing.*;
import org.jdesktop.layout.GroupLayout;

/**
 * @author Najwan S
 */
public class MenuEnglish extends JFrame {
    public MenuEnglish() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Muhammad Najwan Sulvadli
        PanelMenuEnglish = new JFrame();
        label1 = new JLabel();

        //======== this ========
        var PanelMenuEnglishContentPane = getContentPane();

        //---- label1 ----
        label1.setText("MENU ENGLISH");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout PanelMenuEnglishContentPaneLayout = new GroupLayout(PanelMenuEnglishContentPane);
        PanelMenuEnglishContentPane.setLayout(PanelMenuEnglishContentPaneLayout);
        PanelMenuEnglishContentPaneLayout.setHorizontalGroup(
            PanelMenuEnglishContentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, PanelMenuEnglishContentPaneLayout.createSequentialGroup()
                    .addContainerGap(183, Short.MAX_VALUE)
                    .add(label1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                    .add(171, 171, 171))
        );
        PanelMenuEnglishContentPaneLayout.setVerticalGroup(
            PanelMenuEnglishContentPaneLayout.createParallelGroup()
                .add(PanelMenuEnglishContentPaneLayout.createSequentialGroup()
                    .add(131, 131, 131)
                    .add(label1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(151, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Muhammad Najwan Sulvadli
    public JFrame PanelMenuEnglish;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static JFrame main() {
        MenuEnglish menu = new MenuEnglish();
        menu.setVisible(true);
        return menu.PanelMenuEnglish;
    }
}
