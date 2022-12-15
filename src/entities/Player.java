package entities;

import javax.imageio.ImageIO;



import java.awt.Graphics;

import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class Player extends Entity {

    //array bidimensional can store all the animations
    private BufferedImage[][] animations;

    //animation Tick, Index and Speed setted to 15
    private int aniTick, aniIndex, aniSpeed = 15;

    //variable can store IDLE constant
    private int playerAction = IDLE;

    //variable can store direction of the player
    private int playerDirection = -1;

    private boolean moving = false;

    public Player(float x, float y) {
        super(x, y);
        loadAnimation();
        
    }
    
    public void update() {

        //update animation method
        updateAnimationTick();

        setAnimation();
        updatePosition();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 256, 160, null);
    }

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
                    x -=5;
                        break;
                    case UP:
                    y -= 5;
                        break;
                    case RIGHT:
                    x += 5;
                        break;
                    case DOWN:
                    y += 5;
                        break;
                }
            }
        }

    private void loadAnimation() {

        File is = new File("src\\res\\player_sprites.png");

        try {
            BufferedImage img = ImageIO.read(is);

            animations = new BufferedImage[9][6];

        for(int j = 0; j < animations.length; j++){
            for(int i = 0; i < animations[j].length; i++){
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } 

        
        
    }
}
