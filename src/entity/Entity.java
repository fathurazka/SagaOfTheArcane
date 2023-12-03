package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.w3c.dom.css.RGBColor;

import enemy.Enemy;
import main.GamePanel;
import main.UtilityTool;

public class Entity {
    public GamePanel gp;
    
    public BufferedImage right;
    public BufferedImage left;
    public BufferedImage logo;
    public BufferedImage attack;
    public BufferedImage attackUp, attackDown, attackLeft, attackRight;
        
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public Rectangle attackArea = new Rectangle (0, 0, 0, 0);
    
    
    
    //STATE
    public int worldX, worldY;
    public static String direction = "right";
    public int spriteNum = 1;
    public boolean collisionOn = false;
    public boolean invincible = false;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    boolean hpBarOn = false;
    int hpBarCounter = 0;
    
    
    //COUNTER
    public int spriteCounter = 0;
    public int actionLockCounter = 0;    
    public int invincibleCounter = 0;
    int dyingCounter = 0;
    
    
    //VAR BUAT OBJECT
    public BufferedImage image, image1, image2, image3, image4, image5, image6, image7;
	public String name;
	public boolean collision = false;
	
    
    //CHARACTER STATUS
    public int maxLife;
    public int life;
    public int type; //0 = player, 1 = enemy
    public int speed;
    
    public Entity (GamePanel gp) {
    	this.gp = gp;
    }
    
    public void chasePlayer() {
    	
    }
    
    public void update() {
    	//setAction();
        chasePlayer();
    
    	
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
    	// if(collisionOn == false) {
        // 	 switch (direction) {
        //          case "up":
        //              worldY -= speed;
        //              break;
        //          case "down":
        //              worldY += speed;
        //              break;
        //          case "left":
        //              worldX -= speed;
        //              break;
        //          case "right": 
        //              worldX += speed;
        //              break;
        //      }
        // }
    	
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
    	
    	if(invincible == true) {
        	invincibleCounter++;
        	if(invincibleCounter > 40) {
        		invincible = false;
        		invincibleCounter = 0;
        	}
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
        
        //Monster HP Bar
        if (this.type == 1 && hpBarOn == true) { // Menambahkan kondisi: hanya gambar HP bar jika jenis entity adalah musuh (type == 1)
        	double oneScale = (double) gp.tileSize/maxLife;
        	double hpBarValue = oneScale * life;
        	
        	
        	g2.setColor(new Color(35, 35, 35));
            g2.fillRect(screenX - 1, screenY - 16, gp.tileSize +2 , 10);
        	
        	g2.setColor(new Color(255, 0, 30));
            g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 8);
            
            hpBarCounter++;
            
            if(hpBarCounter > 600) {
            	hpBarCounter = 0;
            	hpBarOn = false;
            }
            
        }
        
        
        
        
        if(invincible == true) {
        	hpBarOn = true;
        	hpBarCounter = 0;
        	
        	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); //buat enemy transparant ketika terkena damage (invincible == true)
        }
        
//        if(dying == true) {
//        	dyingAnimation(g2);
//        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
    
    
//    public void dyingAnimation(Graphics2D g2) {
//    	dyingCounter++;
//    	
//    	int i = 5;
//    	
//    	if(dyingCounter <= i) {
//    		changeAlpha(g2, 0f);
//    	}
//    	if(dyingCounter > i && dyingCounter <= i*2) {
//    		changeAlpha(g2, 1f);
//    	}
//    	if(dyingCounter > i*2 && dyingCounter <= i*3) {
//    		changeAlpha(g2, 0f);
//    	}
//    	if(dyingCounter > i*3 && dyingCounter <= i*4) {
//    		changeAlpha(g2, 1f);
//    	}
//    	if(dyingCounter > i*4 && dyingCounter <= i*5) {
//    		changeAlpha(g2, 0f);
//    	}
//    	if(dyingCounter > i*5 && dyingCounter <= i*6) {
//    		changeAlpha(g2, 1f);
//    	}
//    	if(dyingCounter > i*6 && dyingCounter <= i*7) {
//    		changeAlpha(g2, 0f);
//    	}
//    	if(dyingCounter > i*7 && dyingCounter <= i*8) {
//    		changeAlpha(g2, 1f);
//    	}
//    	if(dyingCounter > i*8) {
//    		dying = false;
//    		alive = false;
//    	}
//    }
    
    
    
    
    public void changeAlpha (Graphics2D g2, float alphaValue){
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    }
    
    
    
    public BufferedImage setup(String imagePath, int width, int height) {
    	UtilityTool uTool = new UtilityTool();
    	BufferedImage image = null;
    	
    	try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaledImage(image, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return image;
    }
    
}
