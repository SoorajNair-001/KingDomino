import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class MainWindow{
	private static JFrame mainFrame;
    public MainWindow() throws IOException{
        initComponents();

    }
    private void initComponents() throws IOException{
        mainFrame = new JFrame("King Domino - v.2.0.1(dev prototype)");
        Container contentPane = mainFrame.getContentPane();
        mainFrame.setSize(1200,900);
            
        mainFrame.setLocation(100,100);
        
        boolean sound = true;
        boolean labels = false;
        
    	MainMenu mainMenu = new MainMenu(mainFrame,sound,labels);
    	

		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void closeMainMenu()
    {
    	mainFrame.setVisible(false);
    }
    
    public static void openMainMenu(boolean sound,boolean labels)
    {
    	mainFrame.setVisible(true);
    	MainMenu.setSound(sound);
    	MainMenu.setLabels(labels);
    }
    
}
