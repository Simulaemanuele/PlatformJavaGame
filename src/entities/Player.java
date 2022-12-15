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
    // private int playerDirection = -1;

    //Instead of a variable use a bunch of booleans
    private boolean left, up, right, down;

    private boolean moving = false, attacking = false;

    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimation();
        
    }
    
    public void update() {
        updatePosition();
        //update animation method
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 256, 160, null);
    }

        //setMoving method it replace the methods change X and Y deltas and rect position
        // public void setDirection(int direction) {
        //     this.playerDirection = direction;
        //     moving = true;
        // }
    
        // public void setMoving(boolean moving) {
        //     this.moving = moving;
        // }
    
        //update animation method Declaration
        private void updateAnimationTick() {
    
            aniTick++;
            if(aniTick >= aniSpeed) {
                aniTick = 0;
                aniIndex++;
                if(aniIndex >= GetSpriteAmount(playerAction)){
                    aniIndex = 0;
                    attacking = false;
                }
            }
    
        }
    
        private void setAnimation() {
    
            int startAni = playerAction;
            if(moving) {
                playerAction = RUNNING;
            } else {
                playerAction = IDLE;
            }

            if(attacking) {
                playerAction = ATTACK_1;
            }

            if(startAni != playerAction){
                resetAniTick();
            }
    
        }
    
        private void resetAniTick() {
            aniTick = 0;
            aniIndex = 0;
        }

        private void updatePosition() {

            moving = false;
    
            if(left && !right) {
                x -= playerSpeed;
                moving = true;
            } else if (right && !left){
                x += playerSpeed;
                moving = true;
            }

            if(up && !down) {
                y -= playerSpeed;
                moving = true;
            } else if(down && !up) {
                y += playerSpeed;
                moving = true;
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

    public void resetDirBooleans(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    
}
