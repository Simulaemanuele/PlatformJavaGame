package main;

import javax.swing.JFrame;

//Game window handled by JFRame

public class GameWindow {

    //private declaration of jFrame
    private JFrame jFrame;

    //GameWindow constructor take gamePanel as parameter
    public GameWindow(GamePanel gamePanel){
        //instance of JFrame
        jFrame = new JFrame();

        //window size
        jFrame.setSize(400,400);

        //Setting the closing by the exit
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adding gamePanel 
        jFrame.add(gamePanel);

        //Set the window spawn at the center of the screen
        jFrame.setLocationRelativeTo(null);

        //Set the window on visible 
        jFrame.setVisible(true);
    }
}
