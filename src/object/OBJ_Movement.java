package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Movement extends Entity{

	public OBJ_Movement(GamePanel gp){
		super(gp);
		
		name = "Movement";
		itemDescription = "[" + name + "]" + "\nIncrease Movement Speed.";
//		
		right1 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right2 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right3 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right4 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right5 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right6 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right7 = setup("/object/movement", gp.tileSize, gp.tileSize);
		right8 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left1 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left2 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left3 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left4 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left5 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left6 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left7 = setup("/object/movement", gp.tileSize, gp.tileSize);
		left8 = setup("/object/movement", gp.tileSize, gp.tileSize);
		
        left = setup("/object/movement", gp.tileSize, gp.tileSize);
				
	}
	
	public void use(Entity entity) {
		entity.speed += 1;
		gp.player.hasGold--;
	}
	
}
