package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Movement extends Entity{

	public OBJ_Movement(GamePanel gp){
		super(gp);
		
		name = "Movement";
//		
		right = setup("/object/movement");
        left = setup("/object/movement");
				
	}
}
