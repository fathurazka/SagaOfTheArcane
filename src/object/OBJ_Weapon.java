package object;

import java.security.PublicKey;

import entity.Weapon;
import main.GamePanel;

public class OBJ_Weapon extends Weapon{
	GamePanel gp;
	
	public OBJ_Weapon(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Weapon";
		speed = 7;
		maxLife = 80;
		life = 2;
		attack = maxLife;
		useCost = 1;
		alive = false;
		getImage();
		
			
		}
		
	public void	getImage() {
//		up1 = setup("/projectile/pj_up", gp.tileSize, gp.tileSize);
//		up2 = setup("/projectile/pj_up1", gp.tileSize, gp.tileSize);
//		down1 = setup("/projectile/pj_down", gp.tileSize, gp.tileSize);
//		down2 = setup("/projectile/pj_down1", gp.tileSize, gp.tileSize);
//		left1 = setup("/projectile/pj_left", gp.tileSize, gp.tileSize);
//		left2 = setup("/projectile/pj_left1", gp.tileSize, gp.tileSize);
//		right1 = setup("/projectile/pj_right", gp.tileSize, gp.tileSize);
//		right2 = setup("/projectile/pj_tight1", gp.tileSize, gp.tileSize);
		
		right1 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right2 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right3 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right4 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right5 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right6 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right7 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		right8 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left1 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left2 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left3 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left4 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left5 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left6 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left7 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		left8 = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);

		//projectileImage = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);

		//left = setup("/projectile/projectileImg", gp.tileSize, gp.tileSize);
		
		
	
	}
	
	
	
	
	
}
