package entity;

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
    public static String direction;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    //CHARACTER STATUS
    public int maxLife;
    public int life;
    
    public Entity (GamePanel gp) {
    	this.gp = gp;
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
