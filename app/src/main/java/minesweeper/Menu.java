package minesweeper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel {
    private JButton[] sizes = new JButton[3];
    private JLabel label;
    private int x = 20;
    private int y = 20;
    private int componentHeight = 30;
    private int componentWidth = 100;

    public Menu(){
        this.setSize(Frame.MENU_WIDTH, Frame.MENU_HEIGHT);
        this.setLocation(0,0);
        this.setLayout(null);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.LIGHT_GRAY);
        this.setFont(new Font("Arial", Font.PLAIN, 15));

        createLabel();
        createButtons();
    }

    private void createButtons(){
        sizes[0] = new JButton("Small");
        sizes[1] = new JButton("Medium");
        sizes[2] = new JButton("Large");
        Border border = 
                BorderFactory.createLineBorder(Color.darkGray, 1);

        for(int i=0; i<sizes.length; i++){
            sizes[i].setBounds(x, (i+1)*(y*2)+10, componentWidth, componentHeight);
            sizes[i].setBackground(Color.GRAY);
            sizes[i].setBorder(border);
            this.add(sizes[i]);
        }
    }

    private void createLabel(){
        label = new JLabel("Choose size");
        label.setBounds(x+10,y, componentWidth,componentHeight);
        this.add(label);
    }

    public JButton[] getSizes() {
        return sizes;
    }
}
