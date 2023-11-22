package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Gold;

public class UI {
	
	GamePanel gp;
	Font arial_40;
	BufferedImage goldImage;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
//		(font, fontstyle, fontsize)
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		
		OBJ_Gold gold = new OBJ_Gold();
		goldImage = gold.image;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawImage(goldImage, gp.tileSize/3, gp.tileSize/3, gp.tileSize, gp.tileSize, null);
		g2.drawString("x " + gp.player.hasGold, 60, 50); //Position (60,50)
		
	}
	
	
	
}
