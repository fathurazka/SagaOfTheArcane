package entity;

import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Health;
import object.OBJ_Heart;
import object.OBJ_Movement;
import object.OBJ_Weapon;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.desktop.AboutHandler;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import enemy.Enemy;
import main.GamePanel;

public class Player extends Entity {
    
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
//    String prevDirection = "";
    public int hasGold;
    BufferedImage prevImage = null;
    private String initialDirection = "right";
    public int level;
    public Entity currentWeapon;   
    
    //TRADE SYSTEM
    public ArrayList<Entity> TradeItems = new ArrayList<>();
    public final int TradeItemsSize = 5;
    
    
    

    public Player(GamePanel gp, KeyHandler keyH) {
    	super(gp);
    	
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeight/2;
        		
        		
        setDefaultValues(); 
        getPlayerImage();
        getPlayerAttackImage();
        setTradeItems();

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
        level = 1;
        hasGold = 0;
        damage = 1;
//      n
        
        this.direction = this.initialDirection;
        
        //PLAYER STATUS
        maxLife = 7;
        life = maxLife;
        weapon = new OBJ_Weapon(gp);
        
    }
    
//    public int getAttack() {
//    	return attack = 
//    }
    
    public void setTradeItems() {
    	TradeItems.add(new OBJ_Movement(gp));
    	TradeItems.add(new OBJ_Heart(gp));
    	TradeItems.add(new OBJ_Weapon(gp));
    	
    }
    
    
    
    public void setDefaultPosition() {
    	worldX = 1000;
        worldY = 1000;
        speed = 4;
        this.direction = this.initialDirection;
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
        right1 = setup("/player/MC-run-1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/MC-run-2", gp.tileSize, gp.tileSize);
        right3 = setup("/player/MC-run-3", gp.tileSize, gp.tileSize);
        right4 = setup("/player/MC-run-4", gp.tileSize, gp.tileSize);
        right5 = setup("/player/MC-run-5", gp.tileSize, gp.tileSize);
        right6 = setup("/player/MC-run-6", gp.tileSize, gp.tileSize);
        right7 = setup("/player/MC-run-7", gp.tileSize, gp.tileSize);
        right8 = setup("/player/MC-run-8", gp.tileSize, gp.tileSize);
        left1 = setup("/player/MC-run-1-left", gp.tileSize, gp.tileSize);
        left2 = setup("/player/MC-run-2-left", gp.tileSize, gp.tileSize);
        left3 = setup("/player/MC-run-3-left", gp.tileSize, gp.tileSize);
        left4 = setup("/player/MC-run-4-left", gp.tileSize, gp.tileSize);
        left5 = setup("/player/MC-run-5-left", gp.tileSize, gp.tileSize);
        left6 = setup("/player/MC-run-6-left", gp.tileSize, gp.tileSize);
        left7 = setup("/player/MC-run-7-left", gp.tileSize, gp.tileSize);
        left8 = setup("/player/MC-run-8-left", gp.tileSize, gp.tileSize);
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
        return this.lastDirection;
    }
    
    public void update() {
	    if (attacking== true) {
	            attacking();
	    }
	    	
	    if (keyH.upPressed == true && worldY - speed >= gp.tileSize) {
	        this.direction = "up";
	        worldY -= speed;
	        this.lastDirection = "up";
	    }
	
	    if (keyH.downPressed == true && worldY + speed <= 2304) {
	        this.direction = "down";
	        worldY += speed;
	        this.lastDirection = "down";
	    }
	
	    if (keyH.leftPressed == true && worldX - speed >= gp.tileSize) {
	        this.direction = "left";
	        worldX -= speed;
	        this.lastDirection = "left";
	    }
	     
	    if (keyH.rightPressed == true && worldX + speed <= 2304) {
	        this.direction = "right";
	        worldX += speed;
	        this.lastDirection = "right";
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
            switch (this.direction) {
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
            weapon.setInitialDirection(this.direction);
            weapon.set(worldX, worldY, this.direction, true, this);
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

        spriteCounter++;
            if(spriteCounter > 8) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum ==2) {
                    spriteNum = 3;
                }
                else if(spriteNum == 3) {
                    spriteNum = 4;
                }
                else if(spriteNum == 4) {
                    spriteNum = 5;
                }
                else if(spriteNum == 5) {
                    spriteNum = 6;
                }
                else if(spriteNum == 6) {
                    spriteNum = 7;
                }
                else if(spriteNum == 7) {
                    spriteNum = 8;
                }
                else if(spriteNum == 8) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
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
    		switch (this.direction) {
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
    			gp.enemy[i].life -= damage;
    			gp.enemy[i].invincible = true;
    			
    			if(gp.enemy[i].life <= 0) {
    				gp.enemy[i].dying = true ;
    			}
    		}
    		
    	}
    }
    
    //SELECT AND USE TRADE ITEMS
    public void selectItems() {
    	
    	int itemIndex = gp.ui.getItemsIndexOnSlot();
//    	
    	if(itemIndex < TradeItems.size()){
    		Entity selectedItem = TradeItems.get(itemIndex);
    		
    		if (gp.player.hasGold > 0) {    			
    			selectedItem.use(this);
    		}
    		
    		
    		
    	}
//    	.
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
        
        switch (this.direction) {
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
            		switch (spriteNum) {
                        case 1:image = left1; break;
                        case 2:image = left2; break;
                        case 3:image = left3; break;
                        case 4:image = left4; break;
                        case 5:image = left5; break;
                        case 6:image = left6; break;
                        case 7:image = left7; break;
                        case 8:image = left8; break;
                        default: image = left1; break; // default to the first frame
                    }
                    prevImage = left1;
                }
            	if (attacking == true) {
            		tempScreenX = screenX - gp.tileSize;
            		image = attackLeft;
                }
            	break;
            case "right":
            	if (attacking == false) {
                    switch (spriteNum) {
                        case 1: image = right1; break;
                        case 2: image = right2; break;
                        case 3: image = right3; break;
                        case 4: image = right4; break;
                        case 5: image = right5; break;
                        case 6: image = right6; break;
                        case 7: image = right7; break;
                        case 8: image = right8; break;
                        default: image = right1; break; // default to the first frame
                    }

                    prevImage = right1;
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