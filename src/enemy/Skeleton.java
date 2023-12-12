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
		maxLife = 8;
		life = maxLife;
		
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
		right = setup("/enemy/Skeleton-run-1-right", gp.tileSize, gp.tileSize);
		left = setup("/enemy/Skeleton-run-1-left", gp.tileSize, gp.tileSize);
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
		}
		if (gp.player.worldX < worldX) {
			worldX -= speed;
		}
		if (gp.player.worldY > worldY) {
			worldY += speed;
		}
		if (gp.player.worldY < worldY) {
			worldY -= speed;
		}
	}
	
	public void checkDrop() {
		//CAST A DIE
		int i = new Random().nextInt(100)+1;
		
		//SET THE MONSTER DROP
		if (i < 70) {
			dropItem(new OBJ_Gold(gp));
		}
		if (i >= 70 && i < 80) {
			dropItem(new OBJ_Movement(gp));
		}
		if (i >= 80 && i < 100) {
			dropItem(new OBJ_Heart(gp));
		}
	}
	
}
