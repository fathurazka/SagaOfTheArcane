package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity {
	
	public OBJ_Heart(GamePanel gp){
		super(gp);
		
		name = "Heart";
		itemDescription = "[" + name + "]" + "\nIncrease Health.";
				
				 
//		
		right1 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right2 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right3 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right4 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right5 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right6 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right7 = setup("/object/heart", gp.tileSize, gp.tileSize);
		right8 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left1 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left2 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left3 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left4 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left5 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left6 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left7 = setup("/object/heart", gp.tileSize, gp.tileSize);
		left8 = setup("/object/heart", gp.tileSize, gp.tileSize);

        //left = setup("/object/heart", gp.tileSize, gp.tileSize);
	}
	
	public void use(Entity entity) {
		entity.life += 1;
		gp.player.hasGold--;
		
		if(gp.player.life > gp.player.maxLife) {
			gp.player.life = gp.player.maxLife;
			gp.player.hasGold++;
		}
	}
	
	
}
