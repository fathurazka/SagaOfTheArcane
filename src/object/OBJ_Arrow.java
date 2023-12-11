package object;

import entity.Weapon;
import main.GamePanel;

public class OBJ_Arrow extends Weapon{
	GamePanel gp;
	
	public OBJ_Arrow(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = "Arrow";
		speed = 5;
		maxLife = 80;
		life = maxLife;
		attack = 2;
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
		
		right = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		left = setup("/projectile/arrow", gp.tileSize, gp.tileSize);
		
		
	
	}

}
