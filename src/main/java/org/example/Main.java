package org.example;

import com.google.api.services.storage.Storage;

import javax.swing.*;


public class Main {
    /**
     * gua udah ubah UserData yang initbase itu jadi lu bisa run juga
     */
    public static void main(String[] args) {
        GetCard.main();
        JFrame next = ChooseLang.main();
        next.setContentPane(new ChooseLang().PanelLanguage);
    }

}