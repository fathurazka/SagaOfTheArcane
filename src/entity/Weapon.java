package entity;

import main.GamePanel;

public class Weapon extends Entity{
	Entity user;
	private String initialDirection;
	private String projectileDirection;
	
	public Weapon(GamePanel gp) {
		super(gp);
	}
	
	public void setInitialDirection(String initialDirection) {
        this.initialDirection = initialDirection;
    }
	
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		this.worldX = worldX;
		this.worldY = worldY;
//		this.direction = direction;
		this.alive = true;
		this.user = user;
		this.life = this.maxLife;
		
		// Jika karakter diam, gunakan arah terakhir
        if (direction.isEmpty() && user instanceof Player) {
            Player player = (Player) user;
            projectileDirection = player.getLastDirection();
        } else {
            projectileDirection = direction;
        }
	}
	
	public void update() {
		if(user == gp.player) {
			int enemyIndex = gp.cChecker.checkEntity(this, gp.enemy);
			if(enemyIndex != 999) {
				gp.player.damageEnemy(enemyIndex, attack);
				alive = false;
			}
			
		}
		if(user != gp.player) {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if (gp.player.invincible == false && contactPlayer == true) {
				damagePlayer(attack);
				alive = false;;
			}
			
		}
		
		switch (projectileDirection) {
        case "up":
            worldY -= speed;
            break;
        case "down":
            worldY += speed;
            break;
        case "left":
            worldX -= speed;
            break;
        case "right":
            worldX += speed;
            break;
    }
		
		life--;
		if(life <= 0) {
			alive = false;
		}
//		
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
//			
//			
//			
		}
		
		
		
		
	}
	
	
}
