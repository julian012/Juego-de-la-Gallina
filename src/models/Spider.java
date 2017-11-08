package models;

import java.awt.image.BufferedImage;

import view.Constains;

public class Spider extends InfoCharacters {

	private BufferedImage[] imageList;
	private BufferedImage actualImage;
	public static final int MOVE_LEFT = 0;
	public static final int MOVE_RIGHT = 1;
	private boolean status;
	private int valueChange;
	
	public Spider(int x, int y, int width, int height, BufferedImage[] imageList) {
		super(x, y, width, height);
		this.imageList = imageList;
		status = true;
		actualImage = imageList[MOVE_RIGHT];
	}
	
	public boolean isStatus(){
		return status;
	}
	
	public void changeImageDirection(int value){
		if (value == MOVE_LEFT) {
			actualImage = imageList[MOVE_LEFT];
		}else{
			actualImage = imageList[MOVE_RIGHT];
		}
	}
	
	public void move(int value){
		if (value == MOVE_LEFT) {
			if (getX() <= 0) {
				setX( getX() + 10);
			}else{
				setX( getX() - 10);
			}
		}else{
			if (getX() >= Constains.SCREEM_WIDHT - getWidth()) {
				setX( getX() - 10);
			}else{
				setX( getX() + 10);
			}
		}
		setY( getY() - 10);
		if (getY() <= 310) {
			closeThread();
		}
	}
	
	public void closeThread() {
		status = false;
		stop();
	}
	
	public BufferedImage getActualImage(){
		return actualImage;
	}
	
	@Override
	public void executableTask() {
		super.executableTask();
		try {
			Thread.sleep(Constains.THREAD_SLEEP*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valueChange = (int)(Math.random() * 2);
		changeImageDirection(valueChange);
		move(valueChange);
		
	}
	
	

}
