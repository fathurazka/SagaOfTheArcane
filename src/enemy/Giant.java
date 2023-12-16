package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Gold;
import object.OBJ_Heart;
import object.OBJ_Movement;

public class Giant extends Entity implements Enemy{

	public Giant(GamePanel gp) {
		super(gp);
		
		type = 1;
		name = "Giant";
		speed = 1;
		maxLife = 3;
		life = maxLife;
		
		//set sendiri solid area tergantung ukuran enemy
		solidArea.x = 9;
		solidArea.y = 54;
		solidArea.width = 126;
		solidArea.height = 90;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		right1 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right2 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right3 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right4 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right5 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right6 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right7 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		right8 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left1 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left2 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left3 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left4 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left5 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left6 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left7 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
		left8 = setup("/enemy/giant", gp.tileSize*3, gp.tileSize*3);
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
