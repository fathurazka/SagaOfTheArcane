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
		name = "Archer";
		speed = 2;
		maxLife = 3;
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
		right1 = setup("/enemy/archer-right-1", gp.tileSize, gp.tileSize);
		right2 = setup("/enemy/archer-right-2", gp.tileSize, gp.tileSize);
		right3 = setup("/enemy/archer-right-3", gp.tileSize, gp.tileSize);
		right4 = setup("/enemy/archer-right-4", gp.tileSize, gp.tileSize);
		right5 = setup("/enemy/archer-right-5", gp.tileSize, gp.tileSize);
		right6 = setup("/enemy/archer-right-6", gp.tileSize, gp.tileSize);
		right7 = setup("/enemy/archer-right-7", gp.tileSize, gp.tileSize);
		right8 = setup("/enemy/archer-right-8", gp.tileSize, gp.tileSize);
		left1 = setup("/enemy/archer-left-1", gp.tileSize, gp.tileSize);
		left2 = setup("/enemy/archer-left-2", gp.tileSize, gp.tileSize);
		left3 = setup("/enemy/archer-left-3", gp.tileSize, gp.tileSize);
		left4 = setup("/enemy/archer-left-4", gp.tileSize, gp.tileSize);
		left5 = setup("/enemy/archer-left-5", gp.tileSize, gp.tileSize);
		left6 = setup("/enemy/archer-left-6", gp.tileSize, gp.tileSize);
		left7 = setup("/enemy/archer-left-7", gp.tileSize, gp.tileSize);
		left8 = setup("/enemy/archer-left-8", gp.tileSize, gp.tileSize);
	}
	
	
//	ATUR BEHAVIOUR (INI AI BUAT GERAKIN RANDOM OTOMATIS, KALO MAU NAMBAH PATHFINDER, INI DIMATIIN AJA)
//	 public void setAction() {
//	 	actionLockCounter++;
//		
//	 	if (actionLockCounter == 120) {
//	 		Random random = new Random();
//	 		int i = random.nextInt(100)+1;
//			
//	 		if(i <= 25) {
//	 			direction = "up";
//	 		}
//	 		if(i > 25 && i <= 50) {
//	 			direction = "down";
//	 		}
//	 		if(i > 50 && i <= 75) {
//	 			direction = "left";
//	 		}
//	 		if(i > 75 && i <= 100) {
//	 			direction = "right";
//	 		}
//			
//	 		actionLockCounter = 0;
//	 	}
//	 	int i = new Random().nextInt(100)+1;
//		if(i > 99 && weapon.alive == false && shotAvailableCounter == 30) {
//			weapon.set(worldX, worldY, this.direction, true, this);
//			gp.projectileList.add(weapon);	
//			shotAvailableCounter = 0;
//		}
//	}
//	 public void updateSprite() {
//	 	switch(direction) {
//	 		case "right":
//	 			image = right;
//	 			break;
//	 		case "left":
//	 			image = left;
//	 			break;
//	 	}
//	 }
	 
	public void chasePlayer() {

		// updateSprite();

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
		
		 shootArrow();
	}
//		
	
	public void shootArrow() {
	    int i = new Random().nextInt(100) + 1;
	    if (i > 99 && weapon.alive == false) {
	        //Calculate the relative position of the player
	        int playerX = gp.player.worldX;
	        int playerY = gp.player.worldY;
	        int relativeX = playerX - worldX;
	        int relativeY = playerY - worldY;

	        //Determine the direction based on the relative position
	        if (Math.abs(relativeX) > Math.abs(relativeY)) {
	            //Shoot horizontally
	            weapon.set(worldX, worldY, (relativeX > 0) ? "right" : "left", true, this);
	        } else {
	            //Shoot vertically
	            weapon.set(worldX, worldY, (relativeY > 0) ? "down" : "up", true, this);
	        }

	        gp.projectileList.add(weapon);
	        shotAvailableCounter = 0;
	    }
	}
	
	public void checkDrop() {
		dropItem(new OBJ_Gold(gp));
	}
}
