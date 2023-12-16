package object;

import entity.Weapon;
import main.GamePanel;

public class OBJ_Arrow extends Weapon{
	GamePanel gp;
	
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
		getImage();
		
			
		}
		
	public void	getImage() {
		right1 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right3 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right4 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right5 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right6 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right7 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		right8 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left3 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left4 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left5 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left6 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left7 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left8 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		up1 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		up2 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		down1 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		down2 = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		
		
	}

}
