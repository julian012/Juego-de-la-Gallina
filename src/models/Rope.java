package models;

import java.awt.image.BufferedImage;

import view.Constains;

public class Rope extends InfoCharacters {
	
	private BufferedImage[] imageList;
	private BufferedImage actualImage;
	private boolean changeActualImage;
	private int value;
	
	public Rope(int x, int y, int width, int height, BufferedImage[] imageList) {
		super(x, y, width, height);
		changeActualImage = true;
		this.imageList = imageList;
		value = (int)(Math.random()* imageList.length);
		setActualImage(value);
		start();
	}
	
	public void setActualImage(int value) {
		actualImage = imageList[value];
	}
	
	public BufferedImage getActualImage() {
		return actualImage;
	}
	
	public void changeImage() {
		while (true) {
			if (changeActualImage) {
				for (int i = value; i < imageList.length; i++) {
					setActualImage(i);
					sleepChangeActualImage();
				}
				value = imageList.length - 1;
				changeActualImage = false;
			}else {
				for (int i = value; i > imageList.length; i--) {
					setActualImage(i);
					sleepChangeActualImage();
				}
				value = 0;
				changeActualImage = true;
			}
			
		}
	}
	
	public void sleepChangeActualImage() {
		try {
			Thread.sleep(Constains.THREAD_SLEEP);
		} catch (InterruptedException e) {}
	}
	
	@Override
	public void executableTask() {
		super.executableTask();
		changeImage();
	}

	
}
