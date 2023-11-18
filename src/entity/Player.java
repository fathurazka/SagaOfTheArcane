package entity;

import main.KeyHandler;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues(); 
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        //direction = "down";
    }

    public void getPlayerImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/player/mainChar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            y -= speed;
        }

        if (keyH.downPressed == true) {
            y += speed;
        }

        if (keyH.leftPressed == true) {
            x -= speed;
        }
         
        if (keyH.rightPressed == true) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {

        //.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = img;

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
