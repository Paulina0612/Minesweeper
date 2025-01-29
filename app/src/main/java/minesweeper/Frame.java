package minesweeper;

import javax.swing.JFrame;

public class Frame extends JFrame {
    private int WIDTH=460;
    private int HEIGHT=280;

    public Frame(){
        Panel panel = new Panel();
        this.setSize(WIDTH, HEIGHT);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Minesweeper");
        this.setVisible(true);
    }
}
