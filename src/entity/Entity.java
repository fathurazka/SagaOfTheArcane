package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
    GamePanel gp;
	
	public int worldX, worldY;
    public int speed;
    
    public BufferedImage right;
    public BufferedImage left;
    public BufferedImage logo;
    public static String direction = "right";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int actionLockCounter = 0;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public int type; //0 = player, 1 = enemy
    
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    //VAR BUAT OBJECT
    public BufferedImage image, image1, image2, image3, image4, image5, image6, image7;
	public String name;
	public boolean collision = false;
	
    
    //CHARACTER STATUS
    public int maxLife;
    public int life;
    
    public Entity (GamePanel gp) {
    	this.gp = gp;
    }
    
    public void setAction() {
    	
    }
    
    public void update() {
    	setAction();
    	
    	collisionOn = false;
    	gp.cChecker.checkTile(this);
    	gp.cChecker.checkObject(this, false);
    	gp.cChecker.checkEntity(this, gp.enemy);
    	boolean contactPlayer = gp.cChecker.checkPlayer(this);
    	
    	if(this.type == 1 && contactPlayer == true) {
    		if(gp.player.invincible == false) {
    			gp.player.life -= 1;
    			gp.player.invincible = true;
    		}
    	}
    	
    	
//    	System.out.println("Collision with player: " + collisionOn);
    	
    	//IF COLLISION IS FALSE, PLAYER CAN MOVE
    	if(collisionOn == false) {
        	 switch (direction) {
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
        }
    	
    	spriteCounter++;
    	if (spriteCounter > 12) {
    		if(spriteCounter == 1) {
    			spriteNum = 2;
    		}
    		else if(spriteNum == 2) {
    			spriteNum = 1;
    		}
    		spriteCounter = 0;
    	}
    }
    
    
    public void draw(Graphics2D g2) {
    	BufferedImage image = null;
    	
    	int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
        
        switch (direction) {
        case "":
            image = right;
            break;
        case "up":
            image = left;
            break;
        case "down":
            image = right;
            break;
        case "left":
            image = left;	
            break;
        case "right":
            image = right;
            break;
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
    
    
    public BufferedImage setup(String imagePath) {
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return image;
    }
    
}
