package object;

import entity.Weapon;
import main.GamePanel;
import java.awt.image.BufferedImage;

public class OBJ_Arrow extends Weapon{
	GamePanel gp;
	String direction;
	// BufferedImage arrowRight;
	// BufferedImage arrowLeft;
	// BufferedImage arrowUp;
	// BufferedImage arrowDown;
	
	public OBJ_Arrow(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Arrow";
		speed = 8;
		maxLife = 80;
		life = maxLife;
		attack = 2;
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

	public void setDirection(String direction) {
		this.direction = direction;

		switch (direction) {
            case "right":
                image = right1;
                break;
            case "left":
                image = left1;
                break;
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
        }
	}
		
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
