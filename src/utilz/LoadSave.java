package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadSave {

    public static final String PLAYER_ATLAS = "src\\res\\player_sprites.png";
    
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
}
