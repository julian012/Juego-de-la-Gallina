package models;

public class Egg extends InfoCharacters {
	
	private int posXImage;
	private int posYImage;
	private int widthImage;
	private int heightImage;
	
	public Egg(int posXImage,int posYImage,int widthImage,int heightImage,int x, int y, int width, int height) {
		super(x, y, width, height);
		setPosXImage(posXImage);
		setPosYImage(posYImage);
		setWidthImage(widthImage);
		setHeightImage(heightImage);
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
	
	
}
