package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bezier Curve Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        frame.add(new BezierPanel());

        frame.setVisible(true);
    }
}