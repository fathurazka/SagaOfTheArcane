package entity;

import main.KeyHandler;

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
    String prevDirection = "";

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
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues() {
        worldX = 1000;
        worldY = 1000;
        speed = 4;
        direction = "";
    }

    public void getPlayerImage() {

        try {
            right = ImageIO.read(getClass().getResourceAsStream("/player/mainChar_right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/mainChar_left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
//            worldY -= speed;
        }

        if (keyH.downPressed == true) {
            direction = "down";
//            worldY += speed;
        }

        if (keyH.leftPressed == true) {
            direction = "left";
//            worldX -= speed;
        }
         
        if (keyH.rightPressed == true) {
            direction = "right";
//            worldX += speed;
        }

        //CHECK TILE COLLSION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false) {
//        	if (direction.equals("") && (prevDirection.equals("left") || prevDirection.equals("right"))) {
//                direction = prevDirection; // Set direction to prevDirection
//            }
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
        
        prevDirection = direction;
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

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}