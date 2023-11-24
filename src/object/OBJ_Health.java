package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Health extends Entity {
	public OBJ_Health(GamePanel gp){
		super(gp);
		
		name = "Health";
		image = setup("/object/sprite_7");
		image1 = setup("/object/sprite_6");
		image2 = setup("/object/sprite_5");
		image3 = setup("/object/sprite_4");
		image4 = setup("/object/sprite_3");
		image5 = setup("/object/sprite_2");
		image6 = setup("/object/sprite_1");
		image7 = setup("/object/sprite0");
	}
}
