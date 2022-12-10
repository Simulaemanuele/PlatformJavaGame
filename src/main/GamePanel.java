package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//GamePanel
public class GamePanel extends JPanel {

    //Mouse inputs private
    private MouseInputs mouseInputs;


    //private Deltas it determines movement by pressing buttons
    private int xDelta = 100;
    private int yDelta = 100;
    
    //Game Panel Constructor
    public GamePanel(){
        //Mouse motion listener instance
        mouseInputs = new MouseInputs(this);
        //added key listener method
        addKeyListener(new KeyboardInputs(this));
        //add mouse listener method
        addMouseListener(new MouseInputs(this));
        //add mouse motion listener method
        addMouseMotionListener(mouseInputs);
    }

    //changeDelta methods

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }

    //This method set the position like deltas but it can use it by mouse inputs class
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    //public method for paint component which can draw taking Graphics by parameter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
