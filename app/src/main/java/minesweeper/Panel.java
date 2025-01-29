package minesweeper;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import minesweeper.images.*;

public class Panel extends JPanel {

    public Panel(){
        this.setLayout(null);
        ImageHandler ih = new ImageHandler();
        ImageIcon icon = new ImageIcon(ih.getNumberedIcon(ImageType.TILE_8));
        
        JButton button = new JButton(icon);
        button.setBounds(10,10,ih.getTileSide(), ih.getTileSide());
        this.add(button); 
    }
}
