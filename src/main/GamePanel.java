package main;

import javax.swing.JPanel;

import entities.Player;
import inputs.KeyboardInputs;
import inputs.MouseInputs;


import java.awt.Graphics;
import java.awt.Dimension;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;


//GamePanel
public class GamePanel extends JPanel {

    //Mouse inputs private
    private MouseInputs mouseInputs;

    //Private game instance
    private Game game;
   
    //Game Panel Constructor
    public GamePanel(Game game){
        
        //Mouse motion listener instance
        mouseInputs = new MouseInputs(this);

        //setting game instance in the constructor 
        this.game = game;
        
        //setPanelSize method
        setPanelSize();
        //added key listener method
        addKeyListener(new KeyboardInputs(this));
        //add mouse listener method
        addMouseListener(new MouseInputs(this));
        //add mouse motion listener method
        addMouseMotionListener(mouseInputs);
    }



    //setPanelSize declaration
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("size " + GAME_WIDTH + " : " + GAME_HEIGHT );
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

    


    //public update method
    public void updateGame() {
        
    }

    //public method for paint component which can draw taking Graphics by parameter
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        
    }

    public Game getGame(){
        return game;
    }

    

    

    

    
}
