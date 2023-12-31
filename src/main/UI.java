package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import object.OBJ_Gold;
import object.OBJ_Health;

public class UI {
	
	GamePanel gp;
	Entity entity;
	Graphics2D g2;
	Font arial_40;
	BufferedImage goldImage;
	BufferedImage health7, health6, health5, health4, health3, health2, health1, health0;
	public int commandNum = 0;
	public int slotCol = 0;
	public int slotRow = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
//		(font, fontstyle, fontsize)
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		
		OBJ_Gold gold = new OBJ_Gold(gp);
		goldImage = gold.right1;
		
		OBJ_Health healthBar = new OBJ_Health(gp);
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
		
		if(gp.gameState == gp.playState) {
			g2.drawString("Level: " + gp.player.level, 25, 108); //Position (60,50)
		}
		
		//PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
			g2.drawImage(goldImage, 10, 40, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasGold, 60, 73); //Position (60,50)
			g2.drawString("Level: " + gp.player.level, 25, 108); 
		}
		
		//CHARACTER STATE
		else if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory();
		}
		
		
		//GAME OVER STATE
		else if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen();
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
	
	public void drawCharacterScreen() {
		//CREATE A FRAME
		final int frameX = gp.tileSize * 2;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize * 5;
		final int frameHeight = gp.tileSize * 5;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//TEXT
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(20F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 32;
		
		//NAMES
		g2.drawString("Level: ", textX, textY);
		textY += lineHeight;
		g2.drawString("Health: ", textX, textY);
		textY += lineHeight;
		g2.drawString("Gold: ", textX, textY);
		textY += lineHeight;
		g2.drawString("Movement: ", textX, textY);
		textY += lineHeight;
		g2.drawString("Weapon: ", textX, textY);
		
		//VALUES
		int tailX = (frameX + frameWidth)+30;
		//Reset textY
		textY = frameY + gp.tileSize;
		String value;
//		String value;
//		
//		
		value = String.valueOf(gp.player.level);
		textX = getXForAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXForAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.hasGold);
		textX = getXForAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.speed);
		textX = getXForAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.damage);
		textX = getXForAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
//		
	}
	
	public void drawInventory() {
		//FRAME
		int frameX = gp.tileSize * 9;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize*6;
		int frameHeight = gp.tileSize*3;
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//SLOT
		final int slotXStart = frameX + 20;
		final int slotYStart = frameY + 20;
		int slotX = slotXStart;
		int slotY = slotYStart;
		
		//DRAW TRADE SYSTEM
//	
		for(int i = 0; i < gp.player.TradeItems.size(); i++) {
			g2.drawImage(gp.player.TradeItems.get(i).right1, slotX, slotY, null);
			slotX += gp.tileSize;	
			
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXStart;		
				slotY += gp.tileSize;
			}
			
		}
//		}e
		
		
		//CURSOR
		int cursorX = slotXStart + (gp.tileSize * slotCol);
		int cursorY = slotYStart + (gp.tileSize * slotRow);
		int cursorWidth = gp.tileSize;
		int cursorHeight = gp.tileSize;
		
		//DRAW CURSOR
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(3));
		g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
		
		//DESCRIPTION FRAME
		int dframeX = frameX;
		int dframeY = frameY + frameHeight;
		int dframeWidth = frameWidth;
		int dframeHeight = gp.tileSize*3;
		
		drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);
		
		//DRAW DESCRIPTION TEXT
		int textX = dframeX + 20;
		int textY = dframeY + gp.tileSize;
		
		g2.setFont(g2.getFont().deriveFont(20));
		
		int itemIndex = getItemsIndexOnSlot();
		
		
		if(itemIndex < gp.player.TradeItems.size()) {
			for (String line: gp.player.TradeItems.get(itemIndex).itemDescription.split("\n")){
				g2.drawString(line, textX, textY);
				textY += 32;
			}
		}
		
	}
	
	
	public int getItemsIndexOnSlot() {
		int itemIndex = slotCol + (slotRow * 3);
		return itemIndex;
	}
	
	
	public void drawSubWindow(int x, int y, int width, int height){
		Color c = new Color(0, 0, 0, 210);
		g2.setColor(c);

//		g2.fillRoundRect(x, y, width, height, 35, 35);)
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
	}
	
	
	public int getXForCenteredText(String text) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - lenght/2;		
		return x;
	}
	
	public int getXForAlignToRightText(String text, int tailX) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - lenght - 60;
		return x;
	}
	
	
	
	
	public void drawGameOverScreen() {
		int x, y;
		String text;
		g2.setFont(arial_40);
		
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30f));
		
		//GAME OVER TEXT
		text = "Game Over";
		x = getXForCenteredText(text);
		y = gp.tileSize *4;		
		//shadow
		g2.setColor(Color.black);
		g2.drawString(text, x, y);
		//main
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		
		//RESTART BUTTON
		g2.setFont(g2.getFont().deriveFont(30f));
		text = "Restart";
		x = getXForCenteredText(text);
//		)
		y += gp.tileSize*4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		//QUIT BUTTON
		text = "Quit";
		x = getXForCenteredText(text);
		y+=55;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-40, y);
		}
	}
	
	
}