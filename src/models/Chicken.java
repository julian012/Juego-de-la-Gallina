package models;

public class Chicken extends InfoCharacters {

	private int posXImage;
	private int posYImage;
	private int widthImage;
	private int heightImage;
	private int xSprite;
	private int ySprite;
	public static final int SIZE = 48;
	public static final int COLS_SPRITE = 2;
	
	public Chicken(int posXImage,int posYImage,int widthImage,int heightImage,int x, int y, int width, int height) {
		super(x, y, width, height);
		setPosXImage(posXImage);
		setPosYImage(posYImage);
		setWidthImage(widthImage);
		setHeightImage(heightImage);
		
	}
	
	public Chicken(Chicken chicken) {
		super(chicken.getX(), chicken.getY(), chicken.getWidth(), chicken.getHeight());
		setPosXImage(chicken.getPosXImage());
		setPosYImage(chicken.getPosYImage());
		setWidthImage(chicken.getWidthImage());
		setHeightImage(chicken.getHeightImage());
		releaseKey();
	}
	
	
	public int getPosXImage() {
		return posXImage;
	}

	public void setPosXImage(int posXImage) {
		this.posXImage = posXImage;
	}

	public int getPosYImage() {
		return posYImage;
	}

	public void setPosYImage(int posYImage) {
		this.posYImage = posYImage;
	}

	public int getWidthImage() {
		return widthImage;
	}

	public void setWidthImage(int widthImage) {
		this.widthImage = widthImage;
	}

	public int getHeightImage() {
		return heightImage;
	}

	public void setHeightImage(int heightImage) {
		this.heightImage = heightImage;
	}

	public int getxSprite() {
		return xSprite;
	}

	public int getySprite() {
		return ySprite;
	}
	
	public void moveLeft() {
		setX( getX() - 10 );
		ySprite = posYImage + SIZE;
		if (xSprite == (posXImage)) {
			xSprite = posXImage + (SIZE * COLS_SPRITE);
		}else {
			xSprite -= SIZE;
		}
	}
	
	public void moveRight() {
		setX( getX() + 10 );
		ySprite = posYImage + SIZE + SIZE;
		if (xSprite == (posXImage + (SIZE * COLS_SPRITE))) {
			xSprite = posXImage;
		}else {
			xSprite += SIZE;
		}
	}
	
	public void releaseKey() {
		xSprite = posXImage + SIZE;
		ySprite = posYImage;
	}
	
	@Override
	public void executableTask() {
		// TODO Auto-generated method stub
		super.executableTask();
		try {
			Thread.sleep(1500);
			releaseKey();
			stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
