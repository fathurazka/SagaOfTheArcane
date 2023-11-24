package main;

import java.time.Year;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        
        int entityLeftX = entity.worldX + entity.solidArea.x;
        int entityRightX = entity.worldX + entity.solidArea.x + entity.solidArea.width; 
        int entityTopY = entity.worldY + entity.solidArea.y;
        int entityBottomY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBottomRow = entityBottomY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
            case "down":
                entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    
    //Check object collision
    public int checkObject(Entity entity, boolean player) {
    	int index = 999;
    	
    	for (int i = 0; i < gp.obj.length; i++) {    		
    		
    		//scan obj array
    		if(gp.obj[i] != null) {
    			
    			//GET ENTITY'S SOLID AREA POSITION
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			
    			//Get the object 'solid area position
    			gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
    			gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;
    			
    			
    			switch (entity.direction) {
				case "up": 
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (player == true) {
							index = i;
						}
						
					}
					break;

				case "down": 
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (player == true) {
							index = i;
						}
					}
					break;
				
				case "left": 
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (player == true) {
							index = i;
						}
					}
					break;
				
				case "right": 
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (player == true) {
							index = i;
						}
					}
					break;
				}
    			entity.solidArea.x = entity.solidAreaDefaultX;
    			entity.solidArea.y = entity.solidAreaDefaultY;
    			gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;    			
    			gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;    			
        		
    		}
    	}
    	return index;  	
    }
    
    //MONSTER COLLISION
    public int checkEntity(Entity entity, Entity[] target) {
    	int index = 999;
    	
    	for (int i = 0; i < target.length; i++) {    		
    		
    		if(target[i] != null) {
    			
    			//GET ENTITY'S SOLID AREA POSITION
    			entity.solidArea.x = entity.worldX + entity.solidArea.x;
    			entity.solidArea.y = entity.worldY + entity.solidArea.y;
    			
    			//Get the object 'solid area position
    			target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
    			target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;
    			
    			
    			switch (entity.direction) {
				case "up": entity.solidArea.y -= entity.speed;
					break;
				case "down": entity.solidArea.y += entity.speed;
					break;
				case "left": entity.solidArea.x -= entity.speed;
					break;
				case "right": entity.solidArea.x += entity.speed;
					break;
				}
    			
    			if (entity.solidArea.intersects(target[i].solidArea)) {
					if(target[i] != entity) {
	    				entity.collisionOn =  true;
						index = i;	
					}
    				
				}
    			
    			entity.solidArea.x = entity.solidAreaDefaultX;
    			entity.solidArea.y = entity.solidAreaDefaultY;
    			target[i].solidArea.x = target[i].solidAreaDefaultX;    			
    			target[i].solidArea.y = target[i].solidAreaDefaultY;    			
        		
    		}
    	}
    	return index;  	
    }
    
    public boolean checkPlayer (Entity entity) {
    	
    	boolean contactPlayer = false;
    	
    	//GET ENTITY'S SOLID AREA POSITION
		entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y = entity.worldY + entity.solidArea.y;
		
		//Get the object 'solid area position
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		
		switch (entity.direction) {
		case "up": 
			entity.solidArea.y -= entity.speed;
			break;

		case "down": 
			entity.solidArea.y += entity.speed;
			break;
		
		case "left": 
			entity.solidArea.x -= entity.speed;
			break;
		
		case "right": 
			entity.solidArea.x += entity.speed;
			break;
		}
		
		if (entity.solidArea.intersects(gp.player.solidArea)) {
			entity.collisionOn =  true;
			contactPlayer = true;
		}
		
		entity.solidArea.x = entity.solidAreaDefaultX;
		entity.solidArea.y = entity.solidAreaDefaultY;
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;    			
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;    			
		
		return contactPlayer;
    }
    
}