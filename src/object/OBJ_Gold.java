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
		right1 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right2 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right3 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right4 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right5 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right6 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right7 = setup("/object/gold", gp.tileSize, gp.tileSize);
		right8 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left1 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left2 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left3 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left4 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left5 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left6 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left7 = setup("/object/gold", gp.tileSize, gp.tileSize);
		left8 = setup("/object/gold", gp.tileSize, gp.tileSize);

        //left = setup("/object/gold", gp.tileSize, gp.tileSize);
	}
}
