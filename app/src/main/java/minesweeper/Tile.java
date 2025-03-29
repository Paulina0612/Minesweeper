package minesweeper;

import javax.swing.Icon;
import javax.swing.JButton;

import minesweeper.images.ImageHandler;

abstract class Tile extends JButton {
    protected int x, y;
    protected ImageHandler imageHandler = new ImageHandler();
    protected Icon icon;
}