package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage img;
    public static String direction;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}

