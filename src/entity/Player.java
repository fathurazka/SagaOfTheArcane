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

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues(); 
        getPlayerImage();

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "";
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
            direction = "up";
            //y -= speed;
        }

        if (keyH.downPressed == true) {
            direction = "down";
            //y += speed;
        }

        if (keyH.leftPressed == true) {
            direction = "left";
            //x -= speed;
        }
         
        if (keyH.rightPressed == true) {
            direction = "right";
            //x += speed;
        }

        //CHECK TILE COLLSION
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if(collisionOn == false) {

            switch (direction) {
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right": 
                    x += speed;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        //.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "":
                image = img;
                break;
            case "up":
                image = img;
                break;
            case "down":
                image = img;
                break;
            case "left":
                image = img;
                break;
            case "right":
                image = img;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
