package com.company;



public class Main {

    public static void main(String[] args) {
        ClipboardTextListener b = new ClipboardTextListener();
        Thread thread = new Thread(b);
        thread.start();

    }

}
