package org.example;

import javax.swing.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        JFrame next = ChooseLang.main();
        next.setContentPane(new ChooseLang().PanelLanguage);
    }



}