package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ControllerManager;
import models.Chicken;
import models.Egg;
import models.Nest;
import models.Rock;
import models.Rope;
import models.Spider;
import models.Trunk;

public class JPGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon imageBackground;
	private ImageIcon imageTrunk;
	private ImageIcon imageNest;
	//	private ControllerManager controllerManager;
	private LinkedList<Trunk> trunkList;
	private LinkedList<Nest> nestList;
	private LinkedList<Egg> eggList;
	//	private ArrayList<Rope> ropeList;
	private int level;
	private Chicken chicken;
	private BufferedImage imageChicken;
	private LinkedList<Rock> rockList;
	private LinkedList<Spider> spiderList;
	private BufferedImage imageSpiderweb;
	public int score;

	public JPGame(LinkedList<Trunk> trunkList, LinkedList<Nest> nestList, ControllerManager controllerManager, LinkedList<Egg> eggList,ArrayList<Rope> ropeList, Chicken chicken, LinkedList<Rock> rockList, LinkedList<Spider> spiderList) {
		level = 90;
		//		this.controllerManager = controllerManager;
		this.spiderList = spiderList;
		this.rockList = rockList;
		this.chicken = chicken;
		this.trunkList = trunkList;
		this.nestList = nestList;
		this.eggList = eggList;
		//		this.ropeList = ropeList;
		loadImageChicken();
		imageBackground = new ImageIcon(Constains.PATH_FONT_BACKGROUND_IMAGE);
		imageTrunk = new ImageIcon(Constains.PATH_TRUNK_IMAGE);
		imageNest = new ImageIcon(Constains.PATH_NEST_IMAGE);
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public void loadImageChicken() {
		try {
			imageChicken = ImageIO.read(new File("files/Sprite Gallina.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void drawBackGround(Graphics g){
		g.drawImage(imageBackground.getImage(), 1 , 1, this.getWidth(), this.getHeight(),null);
	}

	public void drawEggs(Graphics g){
		try {
			BufferedImage imageEggs = ImageIO.read(new File(Constains.PATH_EGGS_IMAGE));
			g.drawImage(imageEggs, 120 , 294 - level, imageEggs.getWidth(), imageEggs.getHeight(),this);
			
		} catch (IOException e) {}
	}
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		drawBackGround(g);
		drawEggs(g);

		for (Trunk trunk : trunkList) {
			g2d.drawImage(imageTrunk.getImage(), trunk.getX() , trunk.getY() - level , trunk.getWidth(), trunk.getHeight(),this);
		}

		g.drawImage(imageChicken.getSubimage(chicken.getxSprite(), chicken.getySprite(), 48, 48),chicken.getX(), chicken.getY() - level, 118, 118,this);

		for (Rock rock : rockList) {
			if (rock.isStatus()) {
				g2d.drawImage(rock.getActuarBufferedImage(), rock.getX() , rock.getY() - level , rock.getWidth(), rock.getHeight(),this);
			}
		}
		
//		try {
//			imageSpiderweb = ImageIO.read(new File(Constains.PATH_SPIDER_WEB));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		
		for (Spider spider : spiderList) {
			if (spider.isStatus()) {
				g.drawImage(spider.getActualImage(), spider.getX() , spider.getY() - level , spider.getWidth(), spider.getHeight(),this);
			}
		}
//		int posX = 0;
//		int posY = 309;
//		
//		while(posY < Constains.SCREEM_HEIGHT) {
//			if (posX < Constains.SCREEM_WIDHT) {
//				g.drawImage(imageSpiderweb.getSubimage(90, 1466, 446, 478),posX, posY, 100, 100,this);
//				posX += 75;
//			}else{
//				posX = 0;
//				posY += 75;
//			}
//		}
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.BOLD, 32));
		g2d.drawString("Puntaje: ", 1, 50);
		g2d.drawString(String.valueOf(score), 200, 50);
		
	}

}
