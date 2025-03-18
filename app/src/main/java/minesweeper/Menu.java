package minesweeper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {
    private int WIDTH=150;
    private int HEIGHT=400;
    private JButton[] sizes = new JButton[3];
    private JLabel label = new JLabel("Choose size");

    public Menu(){
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);

        this.setForeground(Color.BLACK);
        
        this.setBackground(Color.LIGHT_GRAY);
        label.setBounds(25,20, 100,20);
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.add(label);

        createButtons();
    }

    private void createButtons(){
        sizes[0] = new JButton("Small");
        sizes[1] = new JButton("Medium");
        sizes[2] = new JButton("Large");
        for(int i=0; i<sizes.length; i++){
            sizes[i].setBounds(20, (i+1)*40+10, 90, 30);
            sizes[i].setBackground(Color.GRAY);
            this.add(sizes[i]);
        }
    }

    public int getWidth() {
        return WIDTH;
    }
}
