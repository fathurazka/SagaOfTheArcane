package enemy;

import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_Gold;
import object.OBJ_Heart;
import object.OBJ_Movement;

public class Archer extends Entity implements Enemy {
	public Enemy enemy;

	public Archer(GamePanel gp) {
		super(gp);
		
		type = 1;
		name = "Wolf";
		speed = 2;
		maxLife = 4;
		life = maxLife;
		
		weapon = new OBJ_Arrow(gp);
		
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
		right = setup("/enemy/archerEnemy", gp.tileSize, gp.tileSize);
		left = setup("/enemy/archerEnemy-left", gp.tileSize, gp.tileSize);
	}
	
	
	//ATUR BEHAVIOUR (INI AI BUAT GERAKIN RANDOM OTOMATIS, KALO MAU NAMBAH PATHFINDER, INI DIMATIIN AJA)
//	 public void setAction() {
//	 	actionLockCounter++;
		
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
		
//	}
	public void updateSprite() {
		switch(direction) {
			case "right":
				image = right;
				break;
			case "left":
				image = left;
				break;
		}
	}
	
	public void chasePlayer() {

		updateSprite();

		if (gp.player.worldX > worldX) {
			worldX += speed;
			direction = "right";
		}
		if (gp.player.worldX < worldX) {
			worldX -= speed;
			direction = "left";
		}
		if (gp.player.worldY > worldY) {
			worldY += speed;
		}
		if (gp.player.worldY < worldY) {
			worldY -= speed;
		}
		int i = new Random().nextInt(100)+1;
		if(i > 99 && weapon.alive == false && shotAvailableCounter == 30) {
			weapon.set(worldX, worldY, direction, true, this);
			gp.projectileList.add(weapon);	
			shotAvailableCounter = 0;
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
