package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Player;

public class KeyHandler implements KeyListener {
    Player player;

	GamePanel gp;
	
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
    
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
    	
    	//TITLE STATE
    	if (gp.gameState == gp.titleState) {
    		 if (code == KeyEvent.VK_W) {
    	            gp.ui.commandNum -= 1;
    	            if (gp.ui.commandNum < 0) {
    	            	gp.ui.commandNum = 1;
    	            }
    	        }

    	        if (code == KeyEvent.VK_S) {
    	        	gp.ui.commandNum += 1;
    	        	if (gp.ui.commandNum > 1) {
    	            	gp.ui.commandNum = 0;
    	            }
    	        }
    	        
    	        if (code == KeyEvent.VK_ENTER) {
    	            if (gp.ui.commandNum == 0) {
    	            	gp.gameState = gp.playState;
    	            }
    	            if (gp.ui.commandNum == 1) {
    	            	//LOAD GAME
    	            }
    	            if (gp.ui.commandNum == 2) {
    	            	System.exit(0);
    	            }
    	        }
    	        
    	}
    	
    	
    	//GAME STATE
    	else if (gp.gameState == gp.playState) {
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
            if (code == KeyEvent.VK_L) {
                enterPressed = true;
            }
            if (code == KeyEvent.VK_K) {
                shotKeyPressed = true;
            }
            
            
            //P to pause
            if (code == KeyEvent.VK_ESCAPE) {
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
    	
    	//GAME OVER STATE
    	else if (gp.gameState == gp.gameOverState) {
    		gameOverState(code);
    	}
       
        
    }
    
    
    public void gameOverState(int code) {
    	if (code == KeyEvent.VK_W) {
    		gp.ui.commandNum--;
    		if(gp.ui.commandNum < 0) {
    			gp.ui.commandNum = 1;
    		}
    	}
    	if (code == KeyEvent.VK_S) {
    		gp.ui.commandNum++;
    		if(gp.ui.commandNum > 1) {
    			gp.ui.commandNum = 0;
    		}
    	}
    	
    	if (code == KeyEvent.VK_ENTER) {
    		if(gp.ui.commandNum == 0) {
    			gp.gameState = gp.playState;
    			gp.restart();
    		}
    		if(gp.ui.commandNum == 1) {
    			gp.gameState = gp.titleState;
    		}
    		
    		
    	}
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            //player.direction = "";
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
            //player.direction = "";
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            //player.direction = "";
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            //player.direction = "";
        }
        if (code == KeyEvent.VK_K) {
            shotKeyPressed = false;
        }

    }
    
}