import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class GameWindow{
	private JFrame gameFrame;
	private  Boolean sound;
    private Boolean game_labels;
    private Integer num_of_players;
    private Integer num_of_comp;
    private Player[] players;
    private GamePanel game;
    public GameWindow(Boolean sound,Boolean game_labels, Integer num_of_players,Integer num_of_comp	,Player[] players) throws IOException{
    	this.sound = sound;
    	this.game_labels = game_labels;
    	this.num_of_players = num_of_players;
    	this.num_of_comp = num_of_comp;
    	this.players = players;
    	initComponents();

    }
    private void initComponents() throws IOException{
        gameFrame = new JFrame("King Domino - v.2.0.1(dev prototype)");
        Container contentPane = gameFrame.getContentPane();
        gameFrame.setSize(1200,900);
            
        gameFrame.setLocation(100,100);
        
        
    	game = new GamePanel(gameFrame,sound,game_labels, num_of_players,num_of_comp,players);
    	

		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(a());
    }
    private int a() {
    	return javax.swing.WindowConstants.EXIT_ON_CLOSE;
    }
}

