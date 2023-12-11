package entity;

import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Health;
import object.OBJ_Weapon;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.desktop.AboutHandler;
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
    private String initialDirection = "right";
    

    public Player(GamePanel gp, KeyHandler keyH) {
    	super(gp);
    	
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        		
        		
        setDefaultValues(); 
        getPlayerImage();
        getPlayerAttackImage();

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        solidArea.width = 32;
        solidArea.height = 32;
        
        attackArea.width = 36; //nanti diganti tergantung weapon
        attackArea.height = 36; 
        
    }

    public void setDefaultValues() {
        worldX = 1000;
        worldY = 1000;
        speed = 4;
        direction = initialDirection;
        
        //PLAYER STATUS
        maxLife = 7;
        life = maxLife;
        weapon = new OBJ_Weapon(gp);
        
    }
    
    public void setDefaultPosition() {
    	worldX = 1000;
        worldY = 1000;
        speed = 4;
        direction = initialDirection;
    }
    
    public void restoreLife() {
    	life = maxLife;
    	invincible = false;
    }
    
//    In case ada inventory, jika game over nanti panggil ini
//    public void setItems() {
//    	inventory.clear();
//    }
    

    public void getPlayerImage() {
        right = setup("/player/mainChar_right", gp.tileSize, gp.tileSize);
        left = setup("/player/mainChar_left", gp.tileSize, gp.tileSize);
        logo = setup("/player/logo", gp.tileSize, gp.tileSize);
    }
    
    public void getPlayerAttackImage() {
    	attackUp = setup("/player/testChar", gp.tileSize, gp.tileSize * 2);
    	attackDown = setup("/player/testChar", gp.tileSize, gp.tileSize * 2);
    	attackRight = setup("/player/testChar", gp.tileSize, gp.tileSize * 2);
    	attackLeft = setup("/player/testChar", gp.tileSize, gp.tileSize * 2);
    }
    
    public String getLastDirection() {
        return lastDirection;
    }
    
    public void update() {
	    if (attacking== true) {
	            attacking();
	    }
	    	
	    if (keyH.upPressed == true && worldY - speed >= gp.tileSize) {
	        direction = "up";
	        worldY -= speed;
	        lastDirection = "up";
	    }
	
	    if (keyH.downPressed == true && worldY + speed <= 2304) {
	        direction = "down";
	        worldY += speed;
	        lastDirection = "down";
	    }
	
	    if (keyH.leftPressed == true && worldX - speed >= gp.tileSize) {
	        direction = "left";
	        worldX -= speed;
	        lastDirection = "left";
	    }
	     
	    if (keyH.rightPressed == true && worldX + speed <= 2304) {
	        direction = "right";
	        worldX += speed;
	        lastDirection = "right";
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
        interactEnemy(enemyIndex);        

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (collisionOn) {
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
        if (gp.keyH.shotKeyPressed == true && weapon.alive == false && shotAvailableCounter == 30) {
            weapon.setInitialDirection(direction);
            weapon.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(weapon);
            shotAvailableCounter = 0;
        }
        
        if(invincible == true) {
        	invincibleCounter++;
        	if(invincibleCounter > 60) {
        		invincible = false;
        		invincibleCounter = 0;
        	}
        }
        if (shotAvailableCounter < 30) {
        	shotAvailableCounter++;
        }
        
        if(life <= 0) {
        	gp.gameState = gp.gameOverState;
        }
        
    }
    
    
    public void attacking() {
    	spriteCounter++;
    	if(spriteCounter <= 5) {
    		spriteNum = 1;
    	}
    	if(spriteCounter > 5 && spriteCounter <= 25){
    		spriteNum = 2;
    		
    		int currentWorldX = worldX;
    		int currentWorldY = worldY;
    		int solidAreaWidth = solidArea.width;
    		int solidAreaHeight = solidArea.height;
    		
    		//adjust player's worldX/Y for the attackArea
    		switch (direction) {
    		case "up": 
				worldY -= attackArea.height;
				break;
    		case "down": 
				worldY += attackArea.height;
				break;
    		case "left": 
				worldX -= attackArea.width;
				break;
    		case "right": 
				worldX += attackArea.width;
				break;
    		}
    		
    		//attackArea become solidArea
    		solidArea.width = attackArea.width;
    		solidArea.height = attackArea.height;
    		
    		//Check enemy collision with the updated worldX, worldY, and solidArea
    		int monsterIndex = gp.cChecker.checkEntity(this, gp.enemy);
    		damageEnemy(monsterIndex, attack);
    		
    		
    		//after checking collision, restore original data
    		worldX = currentWorldX;
    		worldY = currentWorldY;
    		solidArea.width = solidAreaWidth;
    		solidArea.height = solidAreaHeight;
    		
    		
    		
    	}
    	if(spriteCounter > 25) {
    		spriteNum = 1;
    		spriteCounter = 0;
    		attacking = false;
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
    		case "Heart":
    			life++;
    			gp.obj[i]= null;
    			System.out.println("Health: " + life);
    		}
    				
    		
    	}
    }
    
    
    public void interactEnemy(int i) {
    	if(gp.keyH.enterPressed == true) {
    		attacking = true;
    	}
    	gp.keyH.enterPressed = false;
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
    
    public void damageEnemy(int i, int attack) {
    	if (i != 999) {
    		if(gp.enemy[i].invincible == false) {
    			gp.enemy[i].life -= 1;
    			gp.enemy[i].invincible = true;
    			
    			if(gp.enemy[i].life <= 0) {
    				gp.enemy[i].dying = true ;
    			}
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
    
        
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
        switch (direction) {
            case "":
                if (attacking == false) {
                	image = prevImage != null ? prevImage : right;
                }
                if (attacking == true) {
                	tempScreenY = screenY - gp.tileSize;
                	image = attackUp;
                }
                break;
            case "up":
            	if (attacking == false) {
            		image = prevImage;
                    image = prevImage != null ? prevImage : right;
                }
                if (attacking == true) {
                	image = attackUp;
                }
                break;
            case "down":
            	if (attacking == false) {
            		image = prevImage;
                    image = prevImage != null ? prevImage : right;
                }
                if (attacking == true) {
                	image = attackDown;
                }
            	break;
            case "left":
            	if (attacking == false) {
            		image = left;
                    prevImage = left;
                }
            	if (attacking == true) {
            		tempScreenX = screenX - gp.tileSize;
            		image = attackLeft;
                }
            	break;
            case "right":
            	if (attacking == false) {
                	image = right;
                    prevImage = right;
                }
            	if (attacking == true) {
                	image = attackRight;
                }

                break;
        }
        
        if(invincible == true) {
        	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); //buat player transparant ketika terkena musuh (invincible == tru)
        }
        
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
        //DEBUG
        g2.setFont(new Font("Arial", Font.PLAIN, 26));
        g2.setColor(Color.white);
        g2.drawString("Invincible: " + invincibleCounter, 10, 400);
        
        
        
        
    }
}