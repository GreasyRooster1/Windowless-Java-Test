package main.java.com.WindowlessGraphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

public class WindowlessGraphicsTest extends JFrame {
    private int displayWidth = 300;
    private int displayHeight = 200;
    private int mouseX,mouseY;
    public WindowlessGraphicsTest(){
        super();
        this.setSize(500, 400);
        this.setLocation(50, 50);
        setUndecorated(true);
        setBackground(new Color(0,0,0,0)); // this is the critical line - that fourth 0 represents alpha (or opacity)

        setAlwaysOnTop( true );  // keeps it in the foreground, so you don't click away from it - note that clicks on the transparent part DO pass through to the desktop, at least on Lion

        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("\\src\\main\\java\\QuantumDeity\\WindowlessGraphics\\assets\\Axolotl_Base.png");



        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        JLabel imageLabel = new JLabel(new ImageIcon(filePath));
        this.add(imageLabel);

    }
    public static void main(String[] args){
        System.out.println("Sup");
        WindowlessGraphicsTest t = new WindowlessGraphicsTest();
        t.setVisible(true);
    }
}