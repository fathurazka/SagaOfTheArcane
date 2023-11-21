package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Weapon {

    private GamePanel gp;
    private Player player;
    private BufferedImage bulletImage;
    private int damage;
    private int speed;
    private boolean active;
    private int x, y;
    private int bulletSize;

    public Weapon(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
        this.active = false;
        this.damage = 10; // Set the damage value according to your requirements
        this.speed = 8; // Set the speed value according to your requirements
        this.bulletSize = 5; // Set the bullet size according to your requirements

        try {
            bulletImage = ImageIO.read(getClass().getResourceAsStream("/weapons/bullet.png")); // Adjust the path accordingly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shoot() {
        if (!active) {
            active = true;
            x = player.getX() + (player.getWidth() / 2) - (bulletSize / 2);
            y = player.getY() + (player.getHeight() / 2) - (bulletSize / 2);
        }
    }

    public void update() {
        if (active) {
            switch (player.getDirection()) {
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

            if (x < 0 || x > gp.screenWidth || y < 0 || y > gp.screenHeight) {
                active = false;
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (active) {
            g2.drawImage(bulletImage, x, y, bulletSize, bulletSize, null);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, bulletSize, bulletSize);
    }

    public int getDamage() {
        return damage;
    }
}
