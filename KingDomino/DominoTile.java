/*setup and initliaze the dominino tiles*/

import java.awt.Image;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DominoTile {
	private int tileNumber;
	private String terrain1;
	private String terrain2;
	private Image tileImage;
	private static boolean gameLabels;
	private String labels;
	
	public DominoTile(int tileNumber,boolean gameLabels) {
		this.tileNumber = tileNumber;
		this.gameLabels = gameLabels;
		if(gameLabels == true) {
			labels = "Tiles_Labeled";
		}
		else {
			labels = "Tiles_Unlabeled";
		}
		setTileImage();
		setTerrains();
	}
	
	private void setTileImage() {
		String tileName = String.valueOf(tileNumber);
		try {
	          Image img = ImageIO.read(getClass().getResource("Images/"+labels+"/"+tileName+".png"));
	          tileImage = img;
	        } catch (Exception ex) {
	          System.out.println(ex);
	        }
	}
	
	private void setTerrains() {
		if (IntStream.of(1, 2, 13, 14, 15, 16, 36, 38, 41, 43, 48).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Field 0";
		}
		if(IntStream.of(19, 20, 21, 22, 23).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Field 1";
		}
		if(IntStream.of(3, 4, 5, 6, 17, 18).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Forest 0";
		}
		if(IntStream.of(24, 25, 26, 27, 28, 29).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Forest 1";
		}
		if(IntStream.of(7, 8, 9, 37, 42).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Water 0";
		}
		if(IntStream.of(30, 31, 32, 33, 34, 35).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Water 1";
		}
		if(IntStream.of(12, 46, 47).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Swamp 0";
		}
		if(IntStream.of(10, 11, 39, 44).anyMatch(i -> tileNumber == i)) {
			terrain1 = "Garden 0";
		}
		if(tileNumber == 40) {
			terrain1 = "Mine 1";
		}if(tileNumber == 45) {
			terrain1 = "Mine 2";
		}
		if (IntStream.of(1, 2, 24, 25, 26, 27, 30, 31, 40, 45).anyMatch(i -> tileNumber == i)) {
			terrain2 = "Field 0";
		}

		if(IntStream.of(3, 4, 5, 6, 13, 19, 32, 33, 34, 35).anyMatch(i -> tileNumber == i)) {
			terrain2 = "Forest 0";
		}
		if(IntStream.of(7, 8, 9, 14, 17, 20, 28).anyMatch(i -> tileNumber == i)) {
			terrain2 = "Water 0";
		}
		if(IntStream.of(12, 16, 22).anyMatch(i -> tileNumber == i)) {
			terrain2 = "Swamp 0";
		}
		if(tileNumber == 38|| tileNumber == 39) {
			terrain2 = "Swamp 1";
		}
		if(tileNumber == 43|| tileNumber == 44) {
			terrain2 = "Swamp 2";
		}
		if(IntStream.of(10, 11, 15, 18, 21, 29).anyMatch(i -> tileNumber == i)) {
			terrain2 = "Garden 0";
		}
		if(tileNumber == 36|| tileNumber == 37) {
			terrain2 = "Garden 1";
		}
		if(tileNumber == 41|| tileNumber == 42) {
			terrain2 = "Garden 2";
		}
		if(tileNumber == 23) {
			terrain2 = "Mine 0";
		}if(tileNumber == 46|| tileNumber == 47) {
			terrain2 = "Mine 2";
		}if(tileNumber == 48) {
			terrain2 = "Mine 3";
		}
		
	}
	
	public int getTileNumber() {
		return tileNumber;
	}
	
	public String getTerrain1() {
		return terrain1;
	}
	public String getTerrain2() {
		return terrain2;
	}	
	
	public Image getTileImage() {
		return tileImage;
	}
}
