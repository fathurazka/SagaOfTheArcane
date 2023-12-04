package main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private GamePanel gp;

    public MouseHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Get mouse click position
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Calculate the direction vector from player to mouse click
        int playerX = gp.player.worldX + gp.tileSize / 2;
        int playerY = gp.player.worldY + gp.tileSize / 2;

        int deltaX = mouseX - playerX;
        int deltaY = mouseY - playerY;

        // Calculate angle in radians
        double angle = Math.atan2(deltaY, deltaX);

        // Convert angle to degrees
        double degrees = Math.toDegrees(angle);

        // Set the projectile direction for the player
        gp.player.setProjectileDirection(degrees);
        gp.player.shootProjectile();
    }
}
