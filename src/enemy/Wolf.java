package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Gold;
import object.OBJ_Health;
import object.OBJ_Heart;
import object.OBJ_Movement;

public class Wolf extends Entity implements Enemy{

	public Wolf(GamePanel gp) {
		super(gp);
		
		type = 1;
		name = "Wolf";
		speed = 3;
		maxLife = 2;
		life = maxLife;
		damageMelee = 2;
		
		
		//set sendiri solid area tergantung ukuran enemy
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 42;
		solidArea.height = 30;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		right1 = setup("/enemy/wolf-right-1", gp.tileSize, gp.tileSize);
		right2 = setup("/enemy/wolf-right-2", gp.tileSize, gp.tileSize);
		right3 = setup("/enemy/wolf-right-3", gp.tileSize, gp.tileSize);
		right4 = setup("/enemy/wolf-right-4", gp.tileSize, gp.tileSize);
		right5 = setup("/enemy/wolf-right-5", gp.tileSize, gp.tileSize);
		right6 = setup("/enemy/wolf-right-6", gp.tileSize, gp.tileSize);
		right7 = setup("/enemy/wolf-right-7", gp.tileSize, gp.tileSize);
		right8 = setup("/enemy/wolf-right-8", gp.tileSize, gp.tileSize);
		left1 = setup("/enemy/wolf-left-1", gp.tileSize, gp.tileSize);
		left2 = setup("/enemy/wolf-left-2", gp.tileSize, gp.tileSize);
		left3 = setup("/enemy/wolf-left-3", gp.tileSize, gp.tileSize);
		left4 = setup("/enemy/wolf-left-4", gp.tileSize, gp.tileSize);
		left5 = setup("/enemy/wolf-left-5", gp.tileSize, gp.tileSize);
		left6 = setup("/enemy/wolf-left-6", gp.tileSize, gp.tileSize);
		left7 = setup("/enemy/wolf-left-7", gp.tileSize, gp.tileSize);
		left8 = setup("/enemy/wolf-left-8", gp.tileSize, gp.tileSize);
	}

	
	
	//ATUR BEHAVIOUR (INI AI BUAT GERAKIN RANDOM OTOMATIS, KALO MAU NAMBAH PATHFINDER, INI DIMATIIN AJA)
	// public void setAction() {
	// 	actionLockCounter++;
		
	// 	if (actionLockCounter == 120) {
	// 		Random random = new Random();
	// 		int i = random.nextInt(100)+1;
			
	// 		if(i <= 25) {
	// 			direction = "up";
	// 		}
	// 		if(i > 25 && i <= 50) {
	// 			direction = "down";
	// 		}
	// 		if(i > 50 && i <= 75) {
	// 			direction = "left";
	// 		}
	// 		if(i > 75 && i <= 100) {
	// 			direction = "right";
	// 		}
			
	// 		actionLockCounter = 0;
	// 	}
	// }

	public void chasePlayer() {
		if (gp.player.worldX > worldX) {
			worldX += speed;
			this.direction = "right";
		}
		if (gp.player.worldX < worldX) {
			worldX -= speed;
			this.direction = "left";
		}
		if (gp.player.worldY > worldY) {
			worldY += speed;
		}
		if (gp.player.worldY < worldY) {
			worldY -= speed;
		}
	}
	
	public void checkDrop() {
		dropItem(new OBJ_Gold(gp));
	}
}
