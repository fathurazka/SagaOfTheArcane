package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Gold;
import object.OBJ_Health;
import object.SuperObject;

public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	Font arial_40;
	BufferedImage goldImage;
	BufferedImage health7, health6, health5, health4, health3, health2, health1, health0;
	public int commandNum = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
//		(font, fontstyle, fontsize)
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		
		OBJ_Gold gold = new OBJ_Gold();
		goldImage = gold.image;
		
		OBJ_Health healthBar = new OBJ_Health();
		
		
		health0 = healthBar.image;
		health1 = healthBar.image1;
		health2 = healthBar.image2;
		health3 = healthBar.image3;
		health4 = healthBar.image4;
		health5 = healthBar.image5;
		health6 = healthBar.image6;
		health7 = healthBar.image7;
	}
		
	
	public void drawPlayerLife(Graphics2D g2) {
		
		int x = gp.tileSize/2;
		int y = gp.tileSize/2;
		int i = 0;
		
		while (i <= gp.player.life) {
	        // Assuming health0, health1, ..., health7 are images for each health level
	        BufferedImage healthImage = getHealthImageByIndex(i);
	        
	        // Draw the health image
	        g2.drawImage(healthImage, 20, -10, gp.tileSize*2, gp.tileSize*2, null);

	        i++;
	    }
		
//		g2.drawImage(health7, x, y, gp.tileSize, gp.tileSize, null);

		
	
	}
	
	private BufferedImage getHealthImageByIndex(int index) {
	    switch (index) {
	        case 0:
	            return health0;
	        case 1:
	            return health1;
	        case 2:
	            return health2;
	        case 3:
	            return health3;
	        case 4:
	            return health4;
	        case 5:
	            return health5;
	        case 6:
	            return health6;
	        case 7:
	            return health7;
	        default:
	            return null;
	    }
	}
		
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		
		//TITLE STATE
		if (gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			g2.drawImage(goldImage, 10, 40, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasGold, 60, 73); //Position (60,50)
		}
		
		//PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
			g2.drawImage(goldImage, 10, 40, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasGold, 60, 73); //Position (60,50)
		}
		
		
	}
	
	public void drawTitleScreen() {
		
		//TITLE NAME
		g2.setFont(arial_40);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
		String text = "Saga of The Arcane";
		int x = getXForCenteredText(text);
		int y = gp.tileSize*6;
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//IMAGE
		x = gp.screenWidth/2 - (gp.tileSize*2)/2;
		y -= gp.tileSize*3;
		g2.drawImage(gp.player.logo, x, y, gp.tileSize*2, gp.tileSize*2, null);
		
		//MENU
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,24F));
		
		text = "NEW GAME";
		x = getXForCenteredText(text);
		y += gp.tileSize*4 + 25;
		g2.drawString(text, x, y);
		
		if (commandNum == 0) {
			g2.drawString(">", x - gp.tileSize + 20, y);
		}
		
		text = "QUIT";
		x = getXForCenteredText(text);
		y += gp.tileSize;
		g2.drawString(text, x, y);
		
		if (commandNum == 1) {
			g2.drawString(">", x - gp.tileSize + 20, y);
		}
	}
	
	public void drawPauseScreen() {
		String text = "PAUSED";
		int x = getXForCenteredText(text);
		int y = gp.screenHeight/2;
		g2.drawString(text, x, y);			
	}
	
	public int getXForCenteredText(String text) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - lenght/2;		
		return x;
	}
	
	
	
}
