package main;

//Game class it can take all the game components and render it
public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    //Thread of the game it runs by method
    private Thread gameThread;

    //Final setting fixed at 120 FPS
    private final int FPS_SET = 120;

    public Game(){
        //GamePanel instance
        gamePanel = new GamePanel();

        //GameWindow instance that take gamePanel as parameter
        gameWindow = new GameWindow(gamePanel);

        //Method it can take the input focus
        gamePanel.requestFocus();

        //Starting Game Loop
        startGameLoop();
        
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Overrride run method form Runnable interface
    @Override
    public void run() {
        //1 sec is 1000000000.0 nanoSec
        double timePerFrame = 1000000000.0 / FPS_SET;

        //now instance inizializing
        long now = System.nanoTime();

        //lastFrame inizializing
        long lastFrame = System.nanoTime();

        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        
        //Game Loop in a while statement
        while(true) {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frames ++;
            }

            

        //FPS counter in paintComponetn method
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS :" + frames);
            frames = 0;
        }

        }
        
    }
}
