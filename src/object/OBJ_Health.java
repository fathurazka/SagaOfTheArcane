package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Health extends Entity {
	public OBJ_Health(GamePanel gp){
		super(gp);
		
		name = "Health";
		image = setup("/object/sprite_7", gp.tileSize, gp.tileSize);
		image1 = setup("/object/sprite_6", gp.tileSize, gp.tileSize);
		image2 = setup("/object/sprite_5", gp.tileSize, gp.tileSize);
		image3 = setup("/object/sprite_4", gp.tileSize, gp.tileSize);
		image4 = setup("/object/sprite_3", gp.tileSize, gp.tileSize);
		image5 = setup("/object/sprite_2", gp.tileSize, gp.tileSize);
		image6 = setup("/object/sprite_1", gp.tileSize, gp.tileSize);
		image7 = setup("/object/sprite0", gp.tileSize, gp.tileSize);
	}
}
