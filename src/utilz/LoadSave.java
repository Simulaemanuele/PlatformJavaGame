package utilz;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {

    public static final String PLAYER_ATLAS = "src\\res\\player_sprites.png";
    public static final String LEVEL_ATLAS = "src\\res\\outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "src\\res\\level_one_data.png";
    
    public static BufferedImage GetSpriteAtlas(String fileName) {

        BufferedImage img = null;
        File is = new File(fileName);

        try {
             img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } 

        return img;

    }

    public static int[][] GetLevelData() {
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);

        
        for(int j = 0; j < img.getHeight(); j++) {
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if(value >= 48) {
                    value = 0;
                }
                lvlData[j][i] = value;
            }
        }
        return lvlData;
    }
}
