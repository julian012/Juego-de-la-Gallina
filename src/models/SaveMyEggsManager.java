package models;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import view.Constains;

public class SaveMyEggsManager {
	
	private static final String CHICKEN = "Chicken";
	private static final String ROPE = "Rope";
	private static final String EGG = "Egg";
	private static final String TRUNK = "Trunk";
	private LinkedList<Trunk> trunkList;
	private LinkedList<Nest> nestList;
	private LinkedList<Egg> eggList;
	private ArrayList<Rope> ropeList;
	private ArrayList<Chicken> chickenList;
	private Chicken actualChicken;
	private LinkedList<Rock> rockList;
	private LinkedList<Spider> spiderList;
	public int score;
	
	public SaveMyEggsManager() {
		trunkList = new LinkedList<>();
		nestList = new LinkedList<>();
		eggList = new LinkedList<>();
		ropeList = new ArrayList<>();
		chickenList = new ArrayList<>();
		rockList = new LinkedList<>();
		spiderList = new LinkedList<>();
		score = 0;
	}
	
	public void loadInfoFromPersistence(ArrayList<Object> list) {
		for (Object object : list) {
			if (object.getClass().getSimpleName().equals(TRUNK)) {
				Trunk trunk = (Trunk) object;
				trunkList.add(trunk);
			}else if (object.getClass().getSimpleName().equals(EGG)) {
				Egg egg = (Egg) object;
				eggList.add(egg);
			}else if (object.getClass().getSimpleName().equals(ROPE)) {
				Rope rope = (Rope) object;
				ropeList.add(rope);
			}else if (object.getClass().getSimpleName().equals(CHICKEN)) {
				Chicken chicken = (Chicken) object;
				chickenList.add(chicken);
			}else {
				Nest nest = (Nest) object;
				nestList.add(nest);
			}
		}
		actualChicken = new Chicken(chickenList.get(5));
		//actualChicken.start();
	}

	public LinkedList<Trunk> getTrunkList() {
		return trunkList;
	}

	public LinkedList<Nest> getNestList() {
		return nestList;
	}

	public LinkedList<Egg> getEggList() {
		return eggList;
	}

	public ArrayList<Rope> getRopeList() {
		return ropeList;
	}

	public Chicken getActualChicken() {
		return actualChicken;
	}

	public ArrayList<Chicken> getChickenList() {
		return chickenList;
	}
	
	public void moveLeft() {
		actualChicken.moveLeft();
	}
	
	public void moveRight() {
		actualChicken.moveRight();
	}
	
	public void releaseKey() {
		actualChicken.releaseKey();
	}

	public LinkedList<Rock> getRockList() {
		return rockList;
	}
	
	public LinkedList<Spider> getSpiderList(){
		return spiderList;
	}
	
	public void addRock(BufferedImage image) {
		Rock rock = new Rock(actualChicken.getX() + (int)(actualChicken.getWidth()/2), actualChicken.getY() + (int)(actualChicken.getHeight()/2), 70, 70, image);
		rock.start();
		rockList.add(rock);
	}
	
	public void addSpider(BufferedImage[] spiderImg) {
		Spider spider = new Spider((int)(Math.random()* Constains.SCREEM_WIDHT), Constains.SCREEM_HEIGHT, 60, 60, spiderImg);
		spider.start();
		this.spiderList.add(spider);
	}
	
	public void verifyColision() {
		for (Rock rock : rockList) {
			if (rock.isStatus()) {
				for (Spider spider: spiderList) {
					if (spider.isStatus()) {
						if (checkCollision(rock, spider)) {
							spider.closeThread();
							rock.closeThread();
							score += 10;
						}
					}
				}
			}
		}
	}
	
	public boolean checkCollision(Rock rock, Spider spider){
		return ((rock.getX() > spider.getX() && rock.getX() < (spider.getX() + spider.getWidth()))
				 || (rock.getX() + rock.getWidth() > spider.getX() && rock.getX() + rock.getWidth() < (spider.getX() + spider.getWidth())))
				&& ((rock.getY() > spider.getY() && rock.getY() < (spider.getY() + spider.getHeight()))
						|| (rock.getY() + rock.getHeight() > spider.getY() && rock.getY() + rock.getHeight() < (spider.getY() + spider.getHeight())));
	}
	
	
}
