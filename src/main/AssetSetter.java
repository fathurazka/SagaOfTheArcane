package main;

import enemy.Archer;
import enemy.Skeleton;
import enemy.Wolf;
import entity.Player;
import object.OBJ_Gold;
import object.OBJ_Movement;

public class AssetSetter {
	GamePanel gp;	Player player;
	
	public AssetSetter(GamePanel gp, Player player) {
		this.gp = gp;
		this.player = player;
	}
	
	public void setObject() {
		// gp.obj[0] = new OBJ_Gold(gp);
		// gp.obj[0].worldX = 28 * gp.tileSize;
		// gp.obj[0].worldY = 21 * gp.tileSize;
		
		// gp.obj[1] = new OBJ_Gold(gp);
		// gp.obj[1].worldX = 24 * gp.tileSize;
		// gp.obj[1].worldY = 21 * gp.tileSize;
		
		// gp.obj[2] = new OBJ_Gold(gp);
		// gp.obj[2].worldX = 29 * gp.tileSize;
		// gp.obj[2].worldY = 23 * gp.tileSize;
		
		// gp.obj[3] = new OBJ_Gold(gp);
		// gp.obj[3].worldX = 30 * gp.tileSize;
		// gp.obj[3].worldY = 24 * gp.tileSize;
		
		// gp.obj[4] = new OBJ_Movement(gp);
		// gp.obj[4].worldX = 40 * gp.tileSize;
		// gp.obj[4].worldY = 23 * gp.tileSize;
		
		// gp.obj[5] = new OBJ_Movement(gp);
		// gp.obj[5].worldX = 28 * gp.tileSize;
		// gp.obj[5].worldY = 23 * gp.tileSize;
		
		// gp.obj[6] = new OBJ_Movement(gp);
		// gp.obj[6].worldX = 27 * gp.tileSize;
		// gp.obj[6].worldY = 35 * gp.tileSize;
		
		// gp.obj[7] = new OBJ_Movement(gp);
		// gp.obj[7].worldX = 29 * gp.tileSize;
		// gp.obj[7].worldY = 29 * gp.tileSize;
	}
	
	public void setEnemy() {
		if (player.level == 1) {
			gp.enemy[0] = new Skeleton(gp);
			gp.enemy[0].worldX = 16 * gp.tileSize;
			gp.enemy[0].worldY = 22 * gp.tileSize;
			gp.enemy[0].type = 1;
			
			gp.enemy[1] = new Skeleton(gp);
			gp.enemy[1].worldX = 18 * gp.tileSize;
			gp.enemy[1].worldY = 23 * gp.tileSize;
			gp.enemy[1].type = 1;
			
			gp.enemy[2] = new Skeleton(gp);
			gp.enemy[2].worldX = 13 * gp.tileSize;
			gp.enemy[2].worldY = 27 * gp.tileSize;
			gp.enemy[2].type = 1;
			
			gp.enemy[3] = new Wolf(gp);
			gp.enemy[3].worldX = 35 * gp.tileSize;
			gp.enemy[3].worldY = 22 * gp.tileSize;
			gp.enemy[3].type = 1;
		}
		if (player.level == 2) {
			gp.enemy[7] = new Skeleton(gp);
			gp.enemy[7].worldX = 16 * gp.tileSize;
			gp.enemy[7].worldY = 22 * gp.tileSize;
			gp.enemy[7].type = 1;
			
			gp.enemy[8] = new Skeleton(gp);
			gp.enemy[8].worldX = 18 * gp.tileSize;
			gp.enemy[8].worldY = 23 * gp.tileSize;
			gp.enemy[8].type = 1;
			
			gp.enemy[9] = new Skeleton(gp);
			gp.enemy[9].worldX = 13 * gp.tileSize;
			gp.enemy[9].worldY = 27 * gp.tileSize;
			gp.enemy[9].type = 1;
			
			gp.enemy[10] = new Wolf(gp);
			gp.enemy[10].worldX = 19 * gp.tileSize;
			gp.enemy[10].worldY = 22 * gp.tileSize;
			gp.enemy[10].type = 1;
			
			gp.enemy[11] = new Wolf(gp);
			gp.enemy[11].worldX = 22 * gp.tileSize;
			gp.enemy[11].worldY = 23 * gp.tileSize;
			gp.enemy[11].type = 1;
			
			gp.enemy[12] = new Wolf (gp);
			gp.enemy[12].worldX = 27 * gp.tileSize;
			gp.enemy[12].worldY = 27 * gp.tileSize;
			gp.enemy[12].type = 1;
			
			gp.enemy[14] = new Skeleton(gp);
			gp.enemy[14].worldX = 16 * gp.tileSize;
			gp.enemy[14].worldY = 31 * gp.tileSize;
			gp.enemy[14].type = 1;
			
			gp.enemy[15] = new Skeleton(gp);
			gp.enemy[15].worldX = 1 * gp.tileSize;
			gp.enemy[15].worldY = 23 * gp.tileSize;
			gp.enemy[15].type = 1;
			
			gp.enemy[16] = new Skeleton(gp);
			gp.enemy[16].worldX = 24 * gp.tileSize;
			gp.enemy[16].worldY = 27 * gp.tileSize;
			gp.enemy[16].type = 1;
			
			gp.enemy[17] = new Wolf(gp);
			gp.enemy[17].worldX = 19 * gp.tileSize;
			gp.enemy[17].worldY = 29 * gp.tileSize;
			gp.enemy[17].type = 1;
			
		}
		if (player.level == 3) {
			gp.enemy[7] = new Skeleton(gp);
			gp.enemy[7].worldX = 16 * gp.tileSize;
			gp.enemy[7].worldY = 22 * gp.tileSize;
			gp.enemy[7].type = 1;
			
			gp.enemy[8] = new Skeleton(gp);
			gp.enemy[8].worldX = 18 * gp.tileSize;
			gp.enemy[8].worldY = 23 * gp.tileSize;
			gp.enemy[8].type = 1;
			
			gp.enemy[9] = new Skeleton(gp);
			gp.enemy[9].worldX = 13 * gp.tileSize;
			gp.enemy[9].worldY = 27 * gp.tileSize;
			gp.enemy[9].type = 1;
			
			gp.enemy[10] = new Wolf(gp);
			gp.enemy[10].worldX = 19 * gp.tileSize;
			gp.enemy[10].worldY = 22 * gp.tileSize;
			gp.enemy[10].type = 1;
			
			gp.enemy[11] = new Wolf(gp);
			gp.enemy[11].worldX = 22 * gp.tileSize;
			gp.enemy[11].worldY = 23 * gp.tileSize;
			gp.enemy[11].type = 1;
			
			gp.enemy[12] = new Wolf (gp);
			gp.enemy[12].worldX = 27 * gp.tileSize;
			gp.enemy[12].worldY = 27 * gp.tileSize;
			gp.enemy[12].type = 1;
	
			gp.enemy[13] = new Archer(gp);
			gp.enemy[13].worldX = 10 * gp.tileSize;
			gp.enemy[13].worldY = 22 * gp.tileSize;
			gp.enemy[13].type = 1;
			
			gp.enemy[14] = new Skeleton(gp);
			gp.enemy[14].worldX = 16 * gp.tileSize;
			gp.enemy[14].worldY = 31 * gp.tileSize;
			gp.enemy[14].type = 1;
			
			gp.enemy[15] = new Skeleton(gp);
			gp.enemy[15].worldX = 1 * gp.tileSize;
			gp.enemy[15].worldY = 23 * gp.tileSize;
			gp.enemy[15].type = 1;
			
			gp.enemy[16] = new Skeleton(gp);
			gp.enemy[16].worldX = 24 * gp.tileSize;
			gp.enemy[16].worldY = 27 * gp.tileSize;
			gp.enemy[16].type = 1;
			
			gp.enemy[17] = new Wolf(gp);
			gp.enemy[17].worldX = 19 * gp.tileSize;
			gp.enemy[17].worldY = 29 * gp.tileSize;
			gp.enemy[17].type = 1;
			
			gp.enemy[18] = new Wolf(gp);
			gp.enemy[18].worldX = 28 * gp.tileSize;
			gp.enemy[18].worldY = 28 * gp.tileSize;
			gp.enemy[18].type = 1;
			
			gp.enemy[19] = new Wolf (gp);
			gp.enemy[19].worldX = 11 * gp.tileSize;
			gp.enemy[19].worldY = 27 * gp.tileSize;
			gp.enemy[19].type = 1;
	
			gp.enemy[20] = new Archer(gp);
			gp.enemy[20].worldX = 4 * gp.tileSize;
			gp.enemy[20].worldY = 20 * gp.tileSize;
			gp.enemy[20].type = 1;
		}
	}
}
