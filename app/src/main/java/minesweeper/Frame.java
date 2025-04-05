package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {
    public static final int WIDTH=580;
    public static final int HEIGHT=510;
    public static final int MENU_WIDTH=140;
    public static final int MENU_HEIGHT=HEIGHT;
    public static final int PANEL_WIDTH=WIDTH-MENU_WIDTH;
    public static final int PANEL_HEIGHT=HEIGHT;
    private Menu sizesMenu = new Menu();
    private BoardPanel boardPanel = new BoardPanel();

    public Frame(){
        this.setSize(Frame.WIDTH, Frame.HEIGHT);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Minesweeper");
        this.setVisible(true);

        this.add(sizesMenu);
        this.add(boardPanel);

        this.sizesMenu.getSizes()[0].addActionListener(this);
        this.sizesMenu.getSizes()[1].addActionListener(this);
        this.sizesMenu.getSizes()[2].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.sizesMenu.getSizes()[0])
            boardPanel.GenerateBoard(BoardSize.SMALL);
        else if(e.getSource() == this.sizesMenu.getSizes()[1])
            boardPanel.GenerateBoard(BoardSize.MEDIUM);
        else if(e.getSource() == this.sizesMenu.getSizes()[2])
            boardPanel.GenerateBoard(BoardSize.LARGE);
    }
}
