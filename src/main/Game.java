package main;

//Game class it can take all the game components and render it
public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    //Thread of the game it runs by method
    private Thread gameThread;

    //Final setting fixed at 120 FPS
    private final int FPS_SET = 120;

    //Final setting fixed at 200 UPS (Update/tick per second)
    private final int UPS_SET = 200;

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

    public void update() {
        gamePanel.updateGame();
    }

    //Overrride run method form Runnable interface
    @Override
    public void run() {
        //1 sec is 1000000000.0 nanoSec
        double timePerFrame = 1000000000.0 / FPS_SET;

        //even for UPS
        double timePerUpdate = 1000000000.0 / UPS_SET;


        //previousTime inizial
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates= 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;
        
        //Game Loop in a while statement
        while(true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            

        //FPS counter in paintComponetn method
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS :" + frames + " | UPS: " + updates);
            frames = 0;
            updates = 0;
        }

        }
        
    }
}
