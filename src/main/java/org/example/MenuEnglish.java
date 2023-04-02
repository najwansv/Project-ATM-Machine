/*
 * Created by JFormDesigner on Sun Apr 02 22:10:21 ICT 2023
 */

package org.example;

import javax.swing.*;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 * @author Najwan S
 */
public class MenuEnglish extends JPanel {
    public MenuEnglish() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Muhammad Najwan Sulvadli
        label1 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("JIKA INGIN MEMBATALKAN TRANSAKSI TEKAN \"CANCEL");

        //---- button5 ----
        button5.setText("1");

        //---- button6 ----
        button6.setText("5");

        //---- button7 ----
        button7.setText("4");

        //---- button8 ----
        button8.setText("2");

        //---- button9 ----
        button9.setText("3");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .add(GroupLayout.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(70, Short.MAX_VALUE)
                    .add(label1, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
                    .add(53, 53, 53))
                .add(layout.createSequentialGroup()
                    .add(53, 53, 53)
                    .add(layout.createParallelGroup()
                        .add(layout.createSequentialGroup()
                            .add(button9, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(359, Short.MAX_VALUE))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup()
                                .add(button5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .add(button8, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.RELATED, 183, Short.MAX_VALUE)
                            .add(layout.createParallelGroup()
                                .add(GroupLayout.TRAILING, button7, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .add(GroupLayout.TRAILING, button6, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                            .add(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .add(GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(71, 71, 71)
                    .add(label1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .add(31, 31, 31)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(button5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .add(button7, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                    .add(31, 31, 31)
                    .add(layout.createParallelGroup(GroupLayout.BASELINE)
                        .add(button8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .add(button6, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                    .add(30, 30, 30)
                    .add(button9, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Muhammad Najwan Sulvadli
    private JLabel label1;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    
    
}
