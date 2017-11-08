package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utilities {
	
	public static final String PATH_FOLDER_ROPE = "files/cuerdas/";
	
	public static final String PATH_SNAKE_LEFT = "files/Spider/Spider5-min.png";
	public static final String PATH_SNAKE_RIGHT = "files/Spider/Spider2-min.png";
	
	public static BufferedImage[] imageList() {
		File file = new File(PATH_FOLDER_ROPE);
		File[] fileList = file.listFiles();
		BufferedImage[] imageList = new BufferedImage[fileList.length];
		for (int i = 0; i < fileList.length; i++) {
			try {
				BufferedImage image = ImageIO.read(fileList[i]);
				imageList[i] = image;
			} catch (IOException e) {}
		}
		return imageList;
	}
	
	public static BufferedImage[] spiderList() {
		File left = new File(PATH_SNAKE_LEFT);
		File right = new File(PATH_SNAKE_RIGHT);
		BufferedImage[] spiderList = new BufferedImage[2];
		try {
			spiderList[0] = ImageIO.read(left);
			spiderList[1] = ImageIO.read(right);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spiderList;
	}
}
