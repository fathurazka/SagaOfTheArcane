package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;

    public BufferedImage right;
    public BufferedImage left;
    public static String direction;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    
    //CHARACTER STATUS
    public int maxLife;
    public int life;
    
}
