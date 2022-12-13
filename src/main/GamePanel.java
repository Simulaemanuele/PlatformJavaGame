package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;
import java.awt.image.BufferedImage;


//GamePanel
public class GamePanel extends JPanel {

    //Mouse inputs private
    private MouseInputs mouseInputs;


    //private Deltas it determines movement by pressing buttons
    private float xDelta = 100;
    private float yDelta = 100;

    //variable can store an img
    private BufferedImage img, subImg;

   
    //Game Panel Constructor
    public GamePanel(){
        
        //Mouse motion listener instance
        mouseInputs = new MouseInputs(this);

        //import image method
        importImg();
        
        //setPanelSize method
        setPanelSize();
        //added key listener method
        addKeyListener(new KeyboardInputs(this));
        //add mouse listener method
        addMouseListener(new MouseInputs(this));
        //add mouse motion listener method
        addMouseMotionListener(mouseInputs);
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

        subImg = img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subImg, (int)xDelta, (int)yDelta, 128, 80, null);
        
        
    }

    

    
}
