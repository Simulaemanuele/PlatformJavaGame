package main;

//Game class it can take all the game components and renderit
public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game(){
        //GamePanel instance
        gamePanel = new GamePanel();

        //GameWindow instance that take gamePanel as parameter
        gameWindow = new GameWindow(gamePanel);

        //Method it can take the input focus
        gamePanel.requestFocus();
        
    }
}
