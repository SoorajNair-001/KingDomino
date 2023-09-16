import java.awt.*;

import javax.imageio.ImageIO;

public class Player {
    private String color;
    private int playerID;
    private int score;
    private Image plrMeeple;

    public Player(String color, int playerID, int score) {
        this.color = color;
        this.playerID = playerID;
        this.score = score;
        setplayerMeepleImage();
    }

    public void setplayerMeepleImage() {
    	String plrColor = color;
		try {
	          Image img = ImageIO.read(getClass().getResource("Images/"+plrColor+"_meeple.png"));
	          plrMeeple = img;
	        } catch (Exception ex) {
	          System.out.println(ex);
	        }
    }
    
    public Image getPlrMeeple() {
    	return plrMeeple;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
