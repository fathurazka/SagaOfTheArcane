package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Weapon;
import main.GamePanel;

public class OBJ_Fire extends Weapon {
    GamePanel gp;

    public OBJ_Fire(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Fire";
        speed = 3;
        maxLife = 60;
        life = maxLife;
        enemyDamage = 3;
        useCost = 1;
        alive = false;
        getImage();
    }

    public void getImage() {
    	right1 = setup("/projectile/pj_right1", gp.tileSize*3, gp.tileSize*3);
		right2 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right3 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right3 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right5 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right6 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right7 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		right8 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left1 = setup("/projectile/pj_left1", gp.tileSize*3, gp.tileSize*3);
		left2 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left3 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left3 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left5 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left6 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left7 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		left8 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		up1 = setup("/projectile/pj_up1", gp.tileSize*3, gp.tileSize*3);
		up2 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);
		down1 = setup("/projectile/pj_down1", gp.tileSize*3, gp.tileSize*3);
		down2 = setup("/projectile/fireball", gp.tileSize*3, gp.tileSize*3);

    }

	public void update() {
		super.update();
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

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

		if(image != null) {
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			g2.drawImage(image, screenX, screenY, null);
		}
	}
}