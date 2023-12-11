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
		right = setup("/object/gold", gp.tileSize, gp.tileSize);
        left = setup("/object/gold", gp.tileSize, gp.tileSize);
	}
}
