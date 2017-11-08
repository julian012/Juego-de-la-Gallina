package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import models.SaveMyEggsManager;
import persistence.FileManager;
import utilities.Utilities;
import view.Constains;
import view.JFGameWindow;

public class ControllerManager implements ActionListener, KeyListener{

	private SaveMyEggsManager gameManager;
	private FileManager fileManager;
	private JFGameWindow gameWindow;
	private SwingWorker<Void , Void> swingWorker;
	private Timer timer;
	private int time = 4000;
	
	public ControllerManager() {
		gameManager = new SaveMyEggsManager();
		fileManager = new FileManager();
		gameManager.loadInfoFromPersistence(fileManager.readXml());
		gameWindow = new JFGameWindow(this);
		startGame();
	}
	
	public void startGame(){
		gameWindow.initJPGame(gameManager.getTrunkList(), gameManager.getNestList(), gameManager.getEggList(), gameManager.getRopeList(), 
				gameManager.getActualChicken(), gameManager.getRockList(), gameManager.getSpiderList());
		timer = new Timer(time,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addSpider();
				time -= 200;
			}
		});
		timer.start();
		
		initSwingWorker();
		
		
	}
	
	
	
	public void initSwingWorker() {
		swingWorker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				while(true) {
					 try {
				            Thread.sleep(Constains.THREAD_SLEEP);
				            gameWindow.repaintJPGame();
				            gameManager.verifyColision();
				            gameWindow.setScore(gameManager.score);
				        } catch (InterruptedException ex) {
				        }
				}
			}
			
		};
		swingWorker.run();
	}
	
	public void addSpider() {
		gameManager.addSpider(Utilities.spiderList());
	}
	
	public void addRock() {
		try {
			BufferedImage image = ImageIO.read(new File(Constains.PATH_ROCK_SPRITE));
			gameManager.addRock(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void moveChicken(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			gameManager.moveLeft();
			break;
		case 39:
			gameManager.moveRight();
			break;
		case 32:
			addRock();
			break;
		default:
			break;
		}
	}
	
	public void releaseKey(KeyEvent e) {
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		if(e.getKeyCode() == 40)  gameManager.releaseKey();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		moveChicken(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		releaseKey(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
