package object;

import entity.Weapon;
import main.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class OBJ_Arrow extends Weapon{
	GamePanel gp;
	String direction;

	
	public OBJ_Arrow(GamePanel gp) {
		super(gp);
		this.gp = gp;
		this.direction = direction;
		
		name = "Arrow";
		speed = 8;
		maxLife = 80;
		life = maxLife;
		enemyDamage = 2;
		useCost = 1;
		alive = false;
		//getImage();

		right1 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right3 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right4 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right5 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right6 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right7 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		right8 = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left3 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left4 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left5 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left6 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left7 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		left8 = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
		up1 = setup("/projectile/arrow-up", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/arrow-up", gp.tileSize, gp.tileSize);
		down1 = setup("/projectile/arrow-down", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/arrow-down", gp.tileSize, gp.tileSize);
		}

	// public void setDirection(String direction) {
	// 	this.direction = direction;

	// 	switch (direction) {
    //         case "right":
    //             image = right1;
    //             break;
    //         case "left":
    //             image = left1;
    //             break;
    //         case "up":
    //             image = up1;
    //             break;
    //         case "down":
    //             image = down1;
    //             break;
    //     }
	// }

	//@Override
	public void update() {
		super.update();
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		//System.out.println("projectileDirection: " + projectileDirection);
		switch (projectileDirection) {
			case "up":
				image = up1;
				break;
			case "down":
				image = down1;
				break;
			case "left":
				image = left1;	
				break;
			case "right":
				image = right1;
				break;
		}

		if (image != null) {
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			g2.drawImage(image, screenX, screenY, null);
		}
	}






		// BufferedImage arrowRight;
	// BufferedImage arrowLeft;
	// BufferedImage arrowUp;
	// BufferedImage arrowDown;
		
    // public void getImage() {
    //     switch (direction) {
    //         case "right":
    //             image = setup("/projectile/arrow-right", gp.tileSize, gp.tileSize);
    //             break;
    //         case "left":
    //             image = setup("/projectile/arrow-left", gp.tileSize, gp.tileSize);
    //             break;
    //         case "up":
    //             image = setup("/projectile/arrow-up", gp.tileSize, gp.tileSize);
    //             break;
    //         case "down":
    //             image = setup("/projectile/arrow-down", gp.tileSize, gp.tileSize);
    //             break;
    //     }
    // }
}