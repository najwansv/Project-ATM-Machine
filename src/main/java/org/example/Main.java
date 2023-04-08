package org.example;

import javax.swing.*;
import java.util.Scanner;


public class Main {
    /**
     * gua udah ubah UserData yang initbase itu jadi lu bisa run juga
     */
    public static void main(String[] args) {
        JFrame next = ChooseLang.main();
        next.setContentPane(new ChooseLang().PanelLanguage);
    }

}