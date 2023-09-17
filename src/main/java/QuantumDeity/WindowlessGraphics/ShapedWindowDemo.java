package main.java.QuantumDeity.WindowlessGraphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.io.File;

import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class ShapedWindowDemo extends JFrame {
    private int displayWidth = 300;
    private int displayHeight = 200;
    public ShapedWindowDemo(){
        super();
        this.setSize(500, 400);
        this.setLocation(50, 50);
        setUndecorated(true);
        setBackground(new Color(0,0,0,0)); // this is the critical line - that fourth 0 represents alpha (or opacity)

        setAlwaysOnTop( true );  // keeps it in the foreground, so you don't click away from it - note that clicks on the transparent part DO pass through to the desktop, at least on Lion

        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        filePath = filePath.concat("\\src\\main\\java\\QuantumDeity\\WindowlessGraphics\\assets\\Axolotl_Base.png");
        System.out.println(filePath);
        JLabel imageLabel = new JLabel(new ImageIcon(filePath));
        this.add(imageLabel);

    }
    public static void main(String[] args){
        System.out.println("Sup");
        ShapedWindowDemo t = new ShapedWindowDemo();
        t.setVisible(true);
    }
}