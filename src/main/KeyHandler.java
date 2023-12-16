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
    	
    	
    	//PLAY STATE
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
            if (code == KeyEvent.VK_I) {
            	gp.gameState = gp.characterState;
            }
            
            
            //P to pause
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
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
    	//PAUSE STATE
    	else if (gp.gameState == gp.pauseState){
    		if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
    	}
    	
    	//GAME OVER STATE
    	else if (gp.gameState == gp.gameOverState) {
    		gameOverState(code);
    	}
    	
    	//CHARACTER STATE
    	else if (gp.gameState == gp.characterState) {
    		if(code == KeyEvent.VK_I) {
    			gp.gameState = gp.playState;
    		}
    		if(code == KeyEvent.VK_W) {
    			if(gp.ui.slotRow != 0) {
    				gp.ui.slotRow--;    				
    			}
    		}
    		if(code == KeyEvent.VK_A) {
    			if(gp.ui.slotCol != 0) {    				
    				gp.ui.slotCol--;
    			}
    		}
    		if(code == KeyEvent.VK_S) {
    			if(gp.ui.slotRow != 3) {
    				gp.ui.slotRow++;    				
    			}
    		}
    		if(code == KeyEvent.VK_D) {
    			if(gp.ui.slotCol != 4) {
    				gp.ui.slotCol++;    				
    			}
    		}
    		
    		if (code == KeyEvent.VK_ENTER) {
    			gp.player.selectItems();
    		}
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