package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image, image1, image2, image3, image4, image5, image6, image7;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	//Solid area untuk object
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
			
	public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
	
	
}
