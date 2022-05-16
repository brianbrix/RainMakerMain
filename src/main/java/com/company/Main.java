package com.company;


import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws GitAPIException, IOException, URISyntaxException {
        ClipboardTextListener b = new ClipboardTextListener();
        Thread thread = new Thread(b);
        thread.start();
//        JOptionPane.showMessageDialog(null, "RainMaker Started Successfully...");
//        push();


    }

}
