package main;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//GamePanel
public class GamePanel extends JPanel {

    //Mouse inputs private
    private MouseInputs mouseInputs;


    //private Deltas it determines movement by pressing buttons
    private float xDelta = 100;
    private float yDelta = 100;

    //private directions axis 
    private float xDir = 0.03f;
    private float yDir = 0.03f;

    //private frames variale
    private int frames = 0;

    //private lastCheck variable
    private long lastCheck = 0;

    //private Color variable
    private Color color = new Color(150,20,90);

    //private Random object
    private Random random;
    
    //Game Panel Constructor
    public GamePanel(){
        //Initialize random object
        random = new Random();
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
        
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        
    }

    //This method set the position like deltas but it can use it by mouse inputs class
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        
    }

    //public method for paint component which can draw taking Graphics by parameter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);
        

        frames ++;

        //FPS counter in paintComponetn method
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS :" + frames);
            frames = 0;
        }

        repaint();
    }

    //updater method
    private void updateRectangle() {
        xDelta += xDir;

        //if xDelta is below 0 change direction
        if(xDelta > 400 || xDelta < 0){
            xDir*=1;
            color = getRndColor();
        }
        yDelta+=yDir;

        //even for yDelta
        if(yDelta > 400 || yDelta < 0){
            yDir*=1;
            color = getRndColor();
        }

    }

    private Color getRndColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r, g, b);
    }
}
