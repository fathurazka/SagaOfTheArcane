package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Gold extends Entity {
	
	public OBJ_Gold(GamePanel gp){
		super(gp);
		
		name = "Gold";
//		
		right = setup("/object/gold");
        left = setup("/object/gold");
	}
}
