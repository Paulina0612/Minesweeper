package minesweeper;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

public class Frame extends JFrame {
    private int WIDTH=460;
    private int HEIGHT=280;
    //private JButton[] button = new JButton[3];
    private Menu sizesMenu = new Menu();

    public Frame(){
        //Panel panel = new Panel();
        this.setSize(WIDTH, HEIGHT);
        //this.add(panel);
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Minesweeper");
        this.setVisible(true);
        
        //sizesMenu.setBounds(0,0,10,10);
        //sizesMenu.setLayout(null);
        //sizesMenu.setVisible(true);
        //sizesMenu.setBackground(Color.BLACK);
        this.add(sizesMenu);
    }
}
