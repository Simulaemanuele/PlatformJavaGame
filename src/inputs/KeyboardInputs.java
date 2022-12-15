package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;

import main.GamePanel;

//Keyboard inputs with overrided methods
public class KeyboardInputs implements  KeyListener{

    //private instance of gamePanel in KeyboardInputs class
    private GamePanel gamePanel;


    //Constructor it takes gamePanel as parameter
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            gamePanel.getGame().getPlayer().setDirection(UP);
                break;
            case KeyEvent.VK_A:
            gamePanel.getGame().getPlayer().setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
            gamePanel.getGame().getPlayer().setDirection(DOWN);;
                break;
            case KeyEvent.VK_D:
            gamePanel.getGame().getPlayer().setDirection(RIGHT);
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setMoving(false);
                break;
        }
    }
    
    
}
