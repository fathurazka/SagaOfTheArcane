package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin extends Entity{
	GamePanel gp;
	
	public OBJ_Coin(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = "Coin";
		value = 1;
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
