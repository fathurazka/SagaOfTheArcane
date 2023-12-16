package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Gold;
import object.OBJ_Heart;
import object.OBJ_Movement;

public class Skeleton extends Entity implements Enemy{

	public Skeleton(GamePanel gp) {
		super(gp);
		
		type = 1;
		name = "Skeleton";
		speed = 1;
		maxLife = 3;
		life = maxLife;
		
		//set sendiri solid area tergantung ukuran enemy
		solidArea.x = 3;
		solidArea.y = 18;
		solidArea.width = 90;
		solidArea.height = 60;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
		right1 = setup("/enemy/Skeleton-run-1-right", gp.tileSize, gp.tileSize);
		right2 = setup("/enemy/Skeleton-run-2-right", gp.tileSize, gp.tileSize);
		right3 = setup("/enemy/Skeleton-run-3-right", gp.tileSize, gp.tileSize);
		right4 = setup("/enemy/Skeleton-run-4-right", gp.tileSize, gp.tileSize);
		right5 = setup("/enemy/Skeleton-run-5-right", gp.tileSize, gp.tileSize);
		right6 = setup("/enemy/Skeleton-run-6-right", gp.tileSize, gp.tileSize);
		right7 = setup("/enemy/Skeleton-run-7-right", gp.tileSize, gp.tileSize);
		right8 = setup("/enemy/Skeleton-run-8-right", gp.tileSize, gp.tileSize);
		left1 = setup("/enemy/Skeleton-run-1-left", gp.tileSize, gp.tileSize);
		left2 = setup("/enemy/Skeleton-run-2-left", gp.tileSize, gp.tileSize);
		left3 = setup("/enemy/Skeleton-run-3-left", gp.tileSize, gp.tileSize);
		left4 = setup("/enemy/Skeleton-run-4-left", gp.tileSize, gp.tileSize);
		left5 = setup("/enemy/Skeleton-run-5-left", gp.tileSize, gp.tileSize);
		left6 = setup("/enemy/Skeleton-run-6-left", gp.tileSize, gp.tileSize);
		left7 = setup("/enemy/Skeleton-run-7-left", gp.tileSize, gp.tileSize);
		left8 = setup("/enemy/Skeleton-run-8-left", gp.tileSize, gp.tileSize);
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
