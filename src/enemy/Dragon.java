package enemy;

import java.util.Random;

import entity.Entity;
import object.OBJ_Fire;
import object.OBJ_Gold;
import main.GamePanel;

public class Dragon extends Entity implements Enemy {
    public Dragon(GamePanel gp) {
        super(gp);
        shooting = false;
        SHOOTING_RANGE = 150;

        type = 2;
        name = "Dragon";
        speed = 2;
        maxLife = 10;
        life = maxLife;

        weapon = new OBJ_Fire(gp);

        //Set solid area dimensions based on dragon size
        solidArea.x = 10;
        solidArea.y = 30;
        solidArea.width = 120;
        solidArea.height = 90;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
    	right1 = setup("/enemy/dragon-right-1", gp.tileSize*2, gp.tileSize*2);
		right2 = setup("/enemy/dragon-right-2", gp.tileSize*2, gp.tileSize*2);
		right3 = setup("/enemy/dragon-right-3", gp.tileSize*2, gp.tileSize*2);
		right4 = setup("/enemy/dragon-right-4", gp.tileSize*2, gp.tileSize*2);
		right5 = setup("/enemy/dragon-right-5", gp.tileSize*2, gp.tileSize*2);
		right6 = setup("/enemy/dragon-right-6", gp.tileSize*2, gp.tileSize*2);
		right7 = setup("/enemy/dragon-right-7", gp.tileSize*2, gp.tileSize*2);
		right8 = setup("/enemy/dragon-right-8", gp.tileSize*2, gp.tileSize*2);
		left1 = setup("/enemy/dragon-left-1", gp.tileSize*2, gp.tileSize*2);
		left2 = setup("/enemy/dragon-left-2", gp.tileSize*2, gp.tileSize*2);
		left3 = setup("/enemy/dragon-left-3", gp.tileSize*2, gp.tileSize*2);
		left4 = setup("/enemy/dragon-left-4", gp.tileSize*2, gp.tileSize*2);
		left5 = setup("/enemy/dragon-left-5", gp.tileSize*2, gp.tileSize*2);
		left6 = setup("/enemy/dragon-left-6", gp.tileSize*2, gp.tileSize*2);
		left7 = setup("/enemy/dragon-left-7", gp.tileSize*2, gp.tileSize*2);
		left8 = setup("/enemy/dragon-left-8", gp.tileSize*2, gp.tileSize*2);
    }

    public void chasePlayer() {
        int playerX = gp.player.worldX;
        int playerY = gp.player.worldY;

        int distance = Math.abs(worldX - playerX) + Math.abs(worldY - playerY);

        //kondisi untuk mengecek apakah sedang menembak dan jarak dengan pemain
        if (!shooting && distance > SHOOTING_RANGE) {
            if (playerX > worldX) {
                worldX += speed;
                this.direction = "right";
            } else if (playerX < worldX) {
                worldX -= speed;
                this.direction = "left";
            }

            if (playerY > worldY) {
                worldY += speed;
            } else if (playerY < worldY) {
                worldY -= speed;
            }
        }

        shootFire();
    }


    public void shootFire() {
        int playerX = gp.player.worldX;
        int playerY = gp.player.worldY;

        int distance = Math.abs(worldX - playerX) + Math.abs(worldY - playerY);

        int i = new Random().nextInt(100) + 1;
        //menandakan bahwa dragon sedang menembak dalam jarak tertentu
        if (!shooting && i > 95 && distance <= SHOOTING_RANGE && weapon.alive == false) {
            shooting = true;

            int relativeX = playerX - worldX;
            int relativeY = playerY - worldY;

            String chosenDirection;

            // Determine the shooting direction based on relative positions
            if (Math.abs(relativeX) > Math.abs(relativeY)) {
                chosenDirection = (relativeX > 0) ? "right" : "left";
            } else {
                chosenDirection = (relativeY > 0) ? "down" : "up";
            }

            weapon.set(worldX, worldY, chosenDirection, true, this);
            gp.projectileList.add(weapon);

            stopShooting();
        }
    }

    private void stopShooting() {
        shooting = false;
    }

    public void checkDrop() {
        dropItem(new OBJ_Gold(gp));
    }
}
