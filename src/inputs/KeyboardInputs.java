package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            gamePanel.changeYDelta(-5);
            System.out.println("It's W");
                break;
            case KeyEvent.VK_A:
            gamePanel.changeXDelta(-5);
            System.out.println("It's A");
                break;
            case KeyEvent.VK_S:
            gamePanel.changeYDelta(+5);
            System.out.println("It's S");
                break;
            case KeyEvent.VK_D:
            gamePanel.changeXDelta(+5);
            System.out.println("It's D");
                break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }
    
    
}
