package minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel implements ActionListener {
    private int WIDTH=140;
    private int HEIGHT=10000;
    private JButton[] sizes = new JButton[3];
    private JLabel label;
    private int x = 20;
    private int y = 20;
    private int componentHeight = 30;
    private int componentWidth = 100;
    private BoardSize boardSize = null;

    public Menu(){
        this.setSize(WIDTH, HEIGHT);
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
            sizes[i].addActionListener(this);
            this.add(sizes[i]);
        }
    }

    private void createLabel(){
        label = new JLabel("Choose size");
        label.setBounds(x+10,y, componentWidth,componentHeight);
        this.add(label);
    }

    public int getWidth() {
        return WIDTH;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sizes[0]){
            boardSize = BoardSize.SMALL;
        }else if(e.getSource() == sizes[1]){
            boardSize = BoardSize.MEDIUM;
        }else if(e.getSource() == sizes[2]){
            boardSize = BoardSize.LARGE;
        }
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }
}
