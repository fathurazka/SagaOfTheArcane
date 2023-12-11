package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
	
	public OBJ_Heart(GamePanel gp){
		super(gp);
		
		name = "Heart";
//		
		right = setup("/object/heart", gp.tileSize, gp.tileSize);
        left = setup("/object/heart", gp.tileSize, gp.tileSize);
	}
}
