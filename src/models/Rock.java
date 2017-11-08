package models;

import java.awt.image.BufferedImage;

import view.Constains;

public class Rock extends InfoCharacters {

	private BufferedImage bufferedImage;
	private BufferedImage actuarBufferedImage;
	public static final int SIZE = 256;
	public static final int ROWS_COLS = 8;
	private int xImage;
	private int yImage;
	private int count;
	private boolean status;
	
	public Rock(int x, int y, int width, int height, BufferedImage bufferedImage) {
		super(x, y, width, height);
		this.bufferedImage = bufferedImage;
		status = true;
		xImage = 0;
		yImage = 0;
		count = 1;
		actuarBufferedImage = bufferedImage.getSubimage(xImage, yImage, SIZE, SIZE);
	}
	
	public void changeImage() {
		if (getY() >= (720)) {
			stop();
			status = false;
		}else {
			if (count == ROWS_COLS && yImage == (ROWS_COLS - 1)*SIZE) {
				closeThread();
			}else if (count == ROWS_COLS && yImage < (ROWS_COLS - 1)*SIZE) {
				yImage += SIZE;
				xImage = 0;
				count = 1;
				actuarBufferedImage = bufferedImage.getSubimage(xImage, yImage, SIZE, SIZE);
			}else {
				count++;
				xImage += SIZE;
				actuarBufferedImage = bufferedImage.getSubimage(xImage, yImage, SIZE, SIZE);
			}
		}
	}
	
	public void closeThread() {
		status = false;
		stop();
	}
	
	public void move() {
		setY(getY() + 10);
	}
	
	public BufferedImage getActuarBufferedImage() {
		return actuarBufferedImage;
	}
	
	public boolean isStatus() {
		return status;
	}

	@Override
	public void executableTask() {
		// TODO Auto-generated method stub
		super.executableTask();
		try {
			Thread.sleep(Constains.THREAD_SLEEP);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		changeImage();
		move();
	}

}
