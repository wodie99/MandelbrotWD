package net.wodie;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot {
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1056;
    public static final int DETAIL = 1024;

    private static double top = -1.0;
    private static double left = -2.0;
    private static double zoom = 1.0 / 512.0;

    private static BufferedImage image;
    private static JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            JLabel label = new JLabel(new ImageIcon(image));
            label.addMouseListener(mouseListener());

            frame = new JFrame("The Mandelbrot Set");
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
            frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            calculateImage();
        });
    }
