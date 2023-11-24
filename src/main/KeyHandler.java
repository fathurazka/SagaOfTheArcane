package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Player;

public class KeyHandler implements KeyListener {

	GamePanel gp;
	
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    //DEBUG
    boolean checkDrawTime = false;
    
    
    public KeyHandler(GamePanel gp) {
    	this.gp = gp;
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        
        //P to pause
        if (code == KeyEvent.VK_P) {
            if(gp.gameState == gp.playState) {
            	gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState) {
            	gp.gameState = gp.playState;
            }
        }
        
        //DEBUG
        if (code == KeyEvent.VK_T) {
            if (checkDrawTime == false) {
            	checkDrawTime = true;
            }
            else if (checkDrawTime == true) {
				checkDrawTime = false;
			}
        }
       
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            Player.direction = "";
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
            Player.direction = "";
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            Player.direction = "";
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            Player.direction = "";
        }

    }
    
}