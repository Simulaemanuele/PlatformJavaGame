package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.Graphics;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;


//GamePanel
public class GamePanel extends JPanel {

    //Mouse inputs private
    private MouseInputs mouseInputs;


    //private Deltas it determines movement by pressing buttons
    private float xDelta = 100;
    private float yDelta = 100;

    //variable can store an img
    private BufferedImage img;

    //array bidimensional can store all the animations
    private BufferedImage[][] animations;

    //animation Tick, Index and Speed setted to 15
    private int aniTick, aniIndex, aniSpeed = 15;

    //variable can store IDLE constant
    private int playerAction = IDLE;

    //variable can store direction of the player
    private int playerDirection = -1;

    private boolean moving = false;

   
    //Game Panel Constructor
    public GamePanel(){
        
        //Mouse motion listener instance
        mouseInputs = new MouseInputs(this);

        //import image method
        importImg();

        //loadAnimation method
        loadAnimation();
        
        //setPanelSize method
        setPanelSize();
        //added key listener method
        addKeyListener(new KeyboardInputs(this));
        //add mouse listener method
        addMouseListener(new MouseInputs(this));
        //add mouse motion listener method
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimation() {
        animations = new BufferedImage[9][6];

        for(int j = 0; j < animations.length; j++){
            for(int i = 0; i < animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
        
    }

    //method which will import an image asset
    private void importImg() {
        File is = new File("src\\res\\player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
    }

    //setPanelSize declaration
    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }


    //changeDelta methods
    // public void changeXDelta(int value){
    //     this.xDelta += value;
        
    // }

    // public void changeYDelta(int value){
    //     this.yDelta += value;
        
    // }

    //This method set the position like deltas but it can use it by mouse inputs class
    // public void setRectPos(int x, int y){
    //     this.xDelta = x;
    //     this.yDelta = y;
        
    // }

    
    //setMoving method it replace the methods change X and Y deltas and rect position
    public void setDirection(int direction) {
        this.playerDirection = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    //update animation method Declaration
    private void updateAnimationTick() {

        aniTick++;
        if(aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
            }
        }

    }

    private void setAnimation() {

        if(moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

    }

    private void updatePosition() {

        if(moving) {
            switch(playerDirection) {
                case LEFT:
                xDelta -=5;
                    break;
                case UP:
                yDelta -= 5;
                    break;
                case RIGHT:
                xDelta += 5;
                    break;
                case DOWN:
                yDelta += 5;
                    break;
            }
        }
    }

    //public update method
    public void updateGame() {
        //update animation method
        updateAnimationTick();

        setAnimation();
        updatePosition();
    }

    //public method for paint component which can draw taking Graphics by parameter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160, null);
        
        
    }

    

    

    

    

    
}
