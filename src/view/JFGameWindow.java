package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ControllerManager;
import models.Chicken;
import models.Egg;
import models.Nest;
import models.Rock;
import models.Rope;
import models.Spider;
import models.Trunk;

public class JFGameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPGame game;
	private ControllerManager controllerManager;
	
	public JFGameWindow(ControllerManager controllerManager) {
		this.controllerManager = controllerManager;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(Constains.SCREEM_WIDHT, Constains.SCREEM_HEIGHT));
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		addKeyListener(controllerManager);
		setFocusable(true);
		setTitle(Constains.TEXT_TITLE);
		setIconImage(new ImageIcon(Constains.PATH_ICON).getImage());
	}
	
	public void initJPGame(LinkedList<Trunk> trunkList, LinkedList<Nest> nestList,LinkedList<Egg> eggList, ArrayList<Rope> ropeList, Chicken chicken, LinkedList<Rock> rockList, LinkedList<Spider> spiderList) {
		game = new JPGame(trunkList, nestList, controllerManager,eggList, ropeList, chicken, rockList, spiderList);
		add(game, BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	public void repaintJPGame() {
		game.repaint();
		
	}
	
	public void setScore(int score) {
		game.setScore(score);
	}
	
	
	
}
