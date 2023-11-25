package entity;

import main.KeyHandler;
import main.UtilityTool;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity {
    
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
//    String prevDirection = "";
    public int hasGold = 0;
    BufferedImage prevImage = null;
    

    public Player(GamePanel gp, KeyHandler keyH) {
    	super(gp);
    	
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        		
        		
        setDefaultValues(); 
        getPlayerImage();

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues() {
        worldX = 1000;
        worldY = 1000;
        speed = 4;
        direction = "";
        
        //PLAYER STATUS
        maxLife = 7;
        life = maxLife;
    }

    public void getPlayerImage() {
        right = setup("/player/mainChar_right");
        left = setup("/player/mainChar_left");
        logo = setup("/player/logo");
    }
    
    
    

    public void update() {
        if (keyH.upPressed == true && worldY - speed >= gp.tileSize) {
        direction = "up";
        worldY -= speed;
    }

    if (keyH.downPressed == true && worldY + speed <= 2304) {
        direction = "down";
        worldY += speed;
    }

    if (keyH.leftPressed == true && worldX - speed >= gp.tileSize) {
        direction = "left";
        worldX -= speed;
    }
     
    if (keyH.rightPressed == true && worldX + speed <= 2304) {
        direction = "right";
        worldX += speed;
    }

        //CHECK TILE COLLSION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        
        //CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        
        //CHECK ENEMY COLLISION
        int enemyIndex = gp.cChecker.checkEntity(this, gp.enemy);  
        contactEnemy(enemyIndex);
        
        

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (collisionOn) {
            // Reset the player's position to the previous position
            switch (direction) {
                case "up":
                    worldY += speed;
                    break;
                case "down":
                    worldY -= speed;
                    break;
                case "left":
                    worldX += speed;
                    break;
                case "right":
                    worldX -= speed;
                    break;
            }
        }
        
//        prevDirection = direction;
        
        if(invincible == true) {
        	invincibleCounter++;
        	if(invincibleCounter > 60) {
        		invincible = false;
        		invincibleCounter = 0;
        	}
        }
    }

    //PICK UP OBJECT
    public void pickUpObject(int i) {
    	if (i != 999) {
    		String objectName = gp.obj[i].name;
    		//count object and make it null
    		switch (objectName) {
			case "Gold": 
				hasGold++;
				gp.obj[i] = null;
				System.out.println("Jumlah Gold: " + hasGold);
				break;
			case "Movement": 
				speed++;
				gp.obj[i] = null;
				System.out.println("Movement Speed: " + speed);
				break;
    		}
    		
    	}
    	
    	
    }
    
    //ngasih damage ke player
    public void contactEnemy(int i) {
    	if (i != 999) {
    		if(invincible == false) {
    			life -= 1;
    			invincible = true;
    		}
    		
    		
    		
    	}
    }
    
    
    
    
    public void draw(Graphics2D g2) {

        //.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        
        
//        switch (direction) {
//		case "": {
//			switch (prevDirection) {
//			case "left": {
//				image = left;
//			}
//			default:
//				throw new IllegalArgumentException("Unexpected value: " + key);
//			}
//			yield type;
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + prevDirection);
//		}
//       
    



        

        
        switch (direction) {
            case "":
                image = prevImage != null ? prevImage : right;
                break;
            case "up":
                image = prevImage;
                image = prevImage != null ? prevImage : right;
                break;
            case "down":
                image = prevImage;
                image = prevImage != null ? prevImage : right;
                break;
            case "left":
                image = left;
                prevImage = left;
                break;
            case "right":
                image = right;
                prevImage = right;
                break;
        }
        
        if(invincible == true) {
        	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); //buat player transparant ketika terkena musuh (invincible == tru)
        
        }
        
        g2.drawImage(image, screenX, screenY, null);
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
        //DEBUG
        g2.setFont(new Font("Arial", Font.PLAIN, 26));
        g2.setColor(Color.white);
        g2.drawString("Invincible: " + invincibleCounter, 10, 400);
        
        
        
        
    }
}