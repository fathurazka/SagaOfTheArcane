package main;

import enemy.Archer;
import enemy.Skeleton;
import enemy.Wolf;
import object.OBJ_Gold;
import object.OBJ_Movement;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Gold(gp);
		gp.obj[0].worldX = 28 * gp.tileSize;
		gp.obj[0].worldY = 21 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Gold(gp);
		gp.obj[1].worldX = 24 * gp.tileSize;
		gp.obj[1].worldY = 21 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Gold(gp);
		gp.obj[2].worldX = 29 * gp.tileSize;
		gp.obj[2].worldY = 23 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Gold(gp);
		gp.obj[3].worldX = 30 * gp.tileSize;
		gp.obj[3].worldY = 24 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Movement(gp);
		gp.obj[4].worldX = 40 * gp.tileSize;
		gp.obj[4].worldY = 23 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Movement(gp);
		gp.obj[5].worldX = 28 * gp.tileSize;
		gp.obj[5].worldY = 23 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Movement(gp);
		gp.obj[6].worldX = 27 * gp.tileSize;
		gp.obj[6].worldY = 35 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Movement(gp);
		gp.obj[7].worldX = 29 * gp.tileSize;
		gp.obj[7].worldY = 29 * gp.tileSize;
	}
	
	public void setEnemy() {
		gp.enemy[0] = new Skeleton(gp);
		gp.enemy[0].worldX = 10 * gp.tileSize;
		gp.enemy[0].worldY = 22 * gp.tileSize;
		gp.enemy[0].type = 1;
		
		gp.enemy[1] = new Skeleton(gp);
		gp.enemy[1].worldX = 11 * gp.tileSize;
		gp.enemy[1].worldY = 23 * gp.tileSize;
		gp.enemy[1].type = 1;
		
		gp.enemy[2] = new Skeleton(gp);
		gp.enemy[2].worldX = 14 * gp.tileSize;
		gp.enemy[2].worldY = 27 * gp.tileSize;
		gp.enemy[2].type = 1;
		
		gp.enemy[3] = new Wolf(gp);
		gp.enemy[3].worldX = 13 * gp.tileSize;
		gp.enemy[3].worldY = 22 * gp.tileSize;
		gp.enemy[3].type = 1;
		
		gp.enemy[4] = new Wolf(gp);
		gp.enemy[4].worldX = 12 * gp.tileSize;
		gp.enemy[4].worldY = 23 * gp.tileSize;
		gp.enemy[4].type = 1;
		
		gp.enemy[5] = new Wolf (gp);
		gp.enemy[5].worldX = 16 * gp.tileSize;
		gp.enemy[5].worldY = 27 * gp.tileSize;
		gp.enemy[5].type = 1;

		gp.enemy[6] = new Archer(gp);
		gp.enemy[6].worldX = 15 * gp.tileSize;
		gp.enemy[6].worldY = 22 * gp.tileSize;
		gp.enemy[6].type = 1;
		
	}
}
