package minesweeper.tiles;

import javax.swing.Icon;
import javax.swing.JButton;

import minesweeper.images.ImageHandler;

class Tile extends JButton {
    protected ImageHandler imageHandler = new ImageHandler();
    protected Icon icon;
}