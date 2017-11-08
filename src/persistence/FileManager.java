package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import models.Chicken;
import models.Egg;
import models.Nest;
import models.Rope;
import models.Trunk;
import utilities.Utilities;

public class FileManager {
	
	public static final String PATH_FILE_MISCELLANY = "files/dataMiscellany.xml";
	
	public ArrayList<Object> readXml(){
		SAXBuilder builder = new SAXBuilder();
		File archive = new File(PATH_FILE_MISCELLANY);
		ArrayList<Object> miscellanyList = new ArrayList<Object>();
		if (archive.exists()) {
			try
			{
				Document document = (Document) builder.build(archive);
				Element rootNode = document.getRootElement();
				//OBTENER LISTA DE POSISIONES DE TRONCOS
				Element trunkList = rootNode.getChild("trunkList");
				List<Element> listT = trunkList.getChildren("trunk");
				Iterator<Element> iteratorList = listT.iterator();
				while(iteratorList.hasNext()){
					Element infoNode = (Element)iteratorList.next();
					int x = Integer.parseInt(infoNode.getChildText("x"));
					int y = Integer.parseInt(infoNode.getChildText("y"));
					int width = Integer.parseInt(infoNode.getChildText("widht"));
					int height = Integer.parseInt(infoNode.getChildText("height"));
					Trunk trunk = new Trunk(x, y, width, height);
					miscellanyList.add(trunk);
				}
				//OBTENER LISTA DE POSISIONES DE NIDOS
				Element nestList = rootNode.getChild("nestList");
				List<Element> listN = nestList.getChildren("nest");
				Iterator<Element> iteratorListN = listN.iterator();
				while(iteratorListN.hasNext()){
					Element infoNode = (Element)iteratorListN.next();
					int x = Integer.parseInt(infoNode.getChildText("x"));
					int y = Integer.parseInt(infoNode.getChildText("y"));
					int width = Integer.parseInt(infoNode.getChildText("widht"));
					int height = Integer.parseInt(infoNode.getChildText("height"));
					Nest nest = new Nest(x, y, width, height);
					miscellanyList.add(nest);
				}
				//OBTENER LISTA DE POSICIONES DE HUEVOS
				Element eggList = rootNode.getChild("eggsList");
				List<Element> listE = eggList.getChildren("egg");
				Iterator<Element> iteratorListE = listE.iterator();
				while(iteratorListE.hasNext()){
					Element infoNode = (Element)iteratorListE.next();
					int posXImage = Integer.parseInt(infoNode.getChildText("posXImage"));
					int posYImage = Integer.parseInt(infoNode.getChildText("posYImage"));
					int widthImage = Integer.parseInt(infoNode.getChildText("widthImage"));
					int heightImage = Integer.parseInt(infoNode.getChildText("heightImage"));
					int x = Integer.parseInt(infoNode.getChildText("x"));
					int y = Integer.parseInt(infoNode.getChildText("y"));
					int width = Integer.parseInt(infoNode.getChildText("widht"));
					int height = Integer.parseInt(infoNode.getChildText("height"));
					Egg egg = new Egg(posXImage, posYImage, widthImage, heightImage, x, y, width, height);
					miscellanyList.add(egg);
				}
				//OBTENER LISTA DE CUERDAS
				Element ropeList = rootNode.getChild("ropeList");
				List<Element> listR = ropeList.getChildren("rope");
				Iterator<Element> iteratorListR = listR.iterator();
				while (iteratorListR.hasNext()) {
					Element infoNode= (Element) iteratorListR.next();
					int x = Integer.parseInt(infoNode.getChildText("x"));
					int y = Integer.parseInt(infoNode.getChildText("y"));
					int width = Integer.parseInt(infoNode.getChildText("widht"));
					int height = Integer.parseInt(infoNode.getChildText("height"));
					Rope rope = new Rope(x, y, width, height, Utilities.imageList());
					miscellanyList.add(rope);
				}
				//OBTENER LISTA DE GALLINAS
				Element chickenList = rootNode.getChild("chickenList");
				List<Element> listC = chickenList.getChildren("chicken");
				Iterator<Element> iteratorC = listC.iterator();
				while(iteratorC.hasNext()) {
					Element infoNode = (Element)iteratorC.next();
					int posXImage = Integer.parseInt(infoNode.getChildText("posXImage"));
					int posYImage = Integer.parseInt(infoNode.getChildText("posYImage"));
					int widthImage = Integer.parseInt(infoNode.getChildText("widthImage"));
					int heightImage = Integer.parseInt(infoNode.getChildText("heightImage"));
					int x = Integer.parseInt(infoNode.getChildText("x"));
					int y = Integer.parseInt(infoNode.getChildText("y"));
					int width = Integer.parseInt(infoNode.getChildText("widht"));
					int height = Integer.parseInt(infoNode.getChildText("height"));
					Chicken chicken = new Chicken(posXImage, posYImage, widthImage, heightImage, x, y, width, height);
					miscellanyList.add(chicken);
				}
			}catch ( IOException io ) {
				System.out.println( io.getMessage() );
			}catch ( JDOMException jdomex ) {
				System.out.println( jdomex.getMessage() );
			}
			return miscellanyList;
		}else{
			return null;
		}
	}
}
