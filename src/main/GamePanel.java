package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import enemy.Archer;
import enemy.Skeleton;
import enemy.Wolf;
import entity.Entity;
import entity.Player;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable    {
    final int originalTileSize = 16;
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final int screenWidth = tileSize * maxScreenCol; //width = 768px
    public final int screenHeight = tileSize * maxScreenRow; //height = 576px
    
    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize* maxWorldCol;
    public final int worldHeight = tileSize* maxWorldRow;

    int FPS = 60;


    
    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public Player player = new Player(this, keyH);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    // ini gatau kenapa error kalo dihapus  )
    public AssetSetter aSetter = new AssetSetter(this, player);
    public UI ui = new UI(this);    
    
    //ENTITY AND OBJECT
    public Entity obj[] = new Entity[10]; 
    public Entity enemy[] = new Entity[200]; //200 itu number of monster yang bisa didisplay dalam 1 waktu
    
//    
    public ArrayList<Entity> projectileList = new ArrayList<>();
    
    ArrayList<Entity> entityList = new ArrayList<>();
    
    
    
    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int gameOverState = 3;
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame() {
    	aSetter.setObject();
    	aSetter.setEnemy();
    	gameState = titleState;
    }
    
    public void restart() {
    	player.level = 1;
    	player.hasGold = 0;
    	player.setDefaultPosition();
    	player.setDefaultValues();
    	player.restoreLife();
    	aSetter.setObject();
    	aSetter.setEnemy();
    	
    }
    
    
    
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        long drawCount = 0;


        while (gameThread != null) {
            
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;  
                drawCount++;
            }

            if(timer >= 1000000000) {
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    
    public void update() {
    	
    	if (gameState == playState) {
    		player.update();
    		boolean allEnemiesDead = true;

    		
    		//enemy
    		for (int i = 0; i < enemy.length; i++) {
    		    Entity entity = enemy[i];
    		    if (entity != null) {
    		        if (entity.alive == true && entity.dying == false) {
    		            entity.update();
    		            allEnemiesDead = false;
    		        }

    		        if (entity.dying == true) {
    		        	enemy[i].checkDrop();
    		        	enemy[i] = null;
    		        }
    		    }
    		}
    		if (allEnemiesDead) {
                // Increase player level and respawn enemies
                player.level++;
                aSetter.setEnemy(); // You may need to modify this method to suit your needs
            }

    		
    		//projectile
    		for (int i = 0; i < projectileList.size(); i++) {
    		    if (projectileList.get(i) != null) {
    		        if (projectileList.get(i).alive == true) {
    		        	projectileList.get(i).update();
    		        }

    		        if (projectileList.get(i).alive == false) {
    		        	projectileList.remove(i);
    		        }
    		    }
    		}
    		
    	}
    	
    	
    	if (gameState == pauseState) {
    		//nothing
    	}
    	
    }
    
    int type;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //DEBUG
        long drawStart = 0;
        if (keyH.checkDrawTime == true) {
        	drawStart = System.nanoTime();        	
        }
        
        //TITLE SCREEN
        if (gameState == titleState) {
        	ui.draw(g2);
        }
        else {
        	//TILE
            tileM.draw(g2);
           
            
            //ADD ENTITIES TO LIST
            entityList.add(player);
            
            for(int i = 0; i < obj.length; i++) {
            	if(obj[i] != null) {
            		entityList.add(obj[i]);
            	}
            }
            
            for(int i = 0; i < enemy.length; i++) {
            	if(enemy[i] != null) {
            		entityList.add(enemy[i]);            	}
            }
            
            for(int i = 0; i < projectileList.size(); i++) {
            	if(projectileList.get(i) != null) {
            		entityList.add(projectileList.get(i));            	}
            }
            
            
            //SORT
            Collections.sort(entityList, new Comparator<Entity>() {

				@Override
				public int compare(Entity e1, Entity e2) {
					int result = Integer.compare(e1.worldY, e2.worldY);					
					
					return result;
				}
			});
            
            //DRAW ENTITIES
            for (int i = 0; i < entityList.size(); i++) {
            	entityList.get(i).draw(g2);
            }
            
            //EMPTY ENTITY LIST
            entityList.clear();        
            
            //UI
            ui.draw(g2);
            ui.drawPlayerLife(g2);
        }
        
        
        
        //DEBUG
        if (keyH.checkDrawTime == true) {
        	long drawEnd = System.nanoTime();
            long passed = drawEnd-drawStart;        
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }
        
        g2.dispose();
    }
}