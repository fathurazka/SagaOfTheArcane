package entity;

import main.KeyHandler;
import main.UtilityTool;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
//    String prevDirection = "";
    public int hasGold = 0;
    

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
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
        right = setup("mainChar_right");
        left = setup("mainChar_left");
    }
    
    public BufferedImage setup(String imageName) {
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
			image = uTool.scaledImage(image, gp.tileSize, gp.tileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return image;
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
        

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false) {
//        	if (direction.equals("") && (prevDirection.equals("left") || prevDirection.equals("right"))) {
//                direction = prevDirection; // Set direction to prevDirection
//            }
            // switch (direction) {
            //     case "up":
            //         worldY -= speed;
            //         break;
            //     case "down":
            //         worldY += speed;
            //         break;
            //     case "left":
            //         worldX -= speed;
            //         break;
            //     case "right": 
            //         worldX += speed;
            //         break;
            // }
        }
        
//        prevDirection = direction;
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

        g2.drawImage(image, screenX, screenY, null);
    }
}