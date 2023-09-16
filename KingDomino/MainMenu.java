/***creates a Main Menu for the user to choose from***/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;
import java.net.URL;

import javax.imageio.*;
import javax.sound.sampled.*;


public class MainMenu extends JPanel {
	private JFrame mainFrame;
    private JLabel GameNameLbl;
    private JButton SettingsBtn;
    private JButton QuitGameBtn;
    private JButton LoadSvdGameBtn;
    private JPanel MainMenuPnl;
    private JButton NewGameBtn;
    private  static Boolean sound;
    private static NewGame newgameObj;
    private static Boolean game_labels;
    private static Integer num_of_players;
    private static Integer num_of_comp;
    private AudioInputStream audioInputStream;
    private URL bgMusic;
    private static URL clickSound;
    private static Clip clip;

    public MainMenu(JFrame mainFrame,boolean sound,boolean game_labels) throws IOException {
    	this.sound = sound;
    	this.game_labels = game_labels;
    	this.mainFrame = mainFrame;
    	bgMusic = getClass().getResource("Sounds/bg_music.wav");
    	clickSound = getClass().getResource("Sounds/click_sound.wav");
    	try {
    	audioInputStream = AudioSystem.getAudioInputStream(bgMusic);
	       clip = AudioSystem.getClip();
	       clip.open(audioInputStream);
	       FloatControl gainControl = 
	    		    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	       gainControl.setValue(-15.0f);
    	}
	       catch(Exception ex)
		      {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace( );
		      }
    	
    	playBGmusic(sound);
        initComponents();
    }

    private void initComponents() throws IOException {
    	
        MainMenuPnl = new JPanel();
        GameNameLbl = new JLabel();
        SettingsBtn = new JButton();
        NewGameBtn = new JButton();
        LoadSvdGameBtn = new JButton();
        QuitGameBtn = new JButton();
        

        mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        try {
          Image img = ImageIO.read(getClass().getResource("Images/settings_button.png"));
          SettingsBtn.setIcon(new ImageIcon(img));
          SettingsBtn.setBorder(null);
        } catch (Exception ex) {
          System.out.println(ex);
        }
        SettingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					SettingsBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        Image img2 = ImageIO.read(getClass().getResource("Images/Kingdomino-Logo.png"));
        GameNameLbl.setIcon(new ImageIcon(img2));
        GameNameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        try {
          Image img = ImageIO.read(getClass().getResource("Images/newGame_button.png"));
          NewGameBtn.setIcon(new ImageIcon(img));
          NewGameBtn.setBorder(null);
        } catch (Exception ex) {
          System.out.println(ex);
        }
        NewGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					NewGameBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        try {
            Image img = ImageIO.read(getClass().getResource("Images/loadGame_button.png"));
            LoadSvdGameBtn.setIcon(new ImageIcon(img));
            LoadSvdGameBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        LoadSvdGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					LoadSvdGameBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        try {
            Image img = ImageIO.read(getClass().getResource("Images/quitGame_button.png"));
            QuitGameBtn.setIcon(new ImageIcon(img));
            QuitGameBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        QuitGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitGameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuPnlLayout = new GroupLayout(MainMenuPnl);
        MainMenuPnl.setLayout(MainMenuPnlLayout);
        MainMenuPnlLayout.setHorizontalGroup(
                MainMenuPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuPnlLayout.createSequentialGroup()
                        		.addGap(50, 50, 50)
                                .addGroup(MainMenuPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                		.addComponent(GameNameLbl, 1000, 1000, 1000)
                                		.addComponent(NewGameBtn, 300, 300, 300)
                                		.addComponent(LoadSvdGameBtn, 300, 300, 300)
                                		
                           				
                           				
                                		.addGroup(MainMenuPnlLayout.createSequentialGroup()
                                				.addComponent(SettingsBtn,100,100,100)
                                				.addGap(300, 300, 300)
                                				.addComponent(QuitGameBtn, 300, 300, 300)
                                				.addGap(400, 400, 400))
                                		))
        );
        MainMenuPnlLayout.setVerticalGroup(
                MainMenuPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuPnlLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(GameNameLbl, 200, 200, 200)
                                .addGap(100, 100, 100)
                                .addComponent(NewGameBtn,100,100,100)
                                .addGap(50, 50, 50)
                                .addComponent(LoadSvdGameBtn, 100,100,100)
                                .addGap(50, 50, 50)
                                .addGroup(MainMenuPnlLayout.createParallelGroup()
                                	.addComponent(QuitGameBtn, 100,100,100)
                                	.addComponent(SettingsBtn,100,100,100)))
                               
        );
        JLabel bgImage = new JLabel();
        
        Image img1 = ImageIO.read(getClass().getResource("Images/kingDomino.jpeg"));
        bgImage.setIcon(new ImageIcon(img1));
        MainMenuPnl.add(bgImage);
        bgImage.setBounds(0, 0, 1200, 900);

        mainFrame.add(MainMenuPnl);
    }// </editor-fold>

    private void SettingsBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	playClickSound();
        Settings settings=new Settings("MainMenu",mainFrame,sound,game_labels,"main");
        sound = settings.getMuted();
        playBGmusic(sound);
        settings.setVisible(true);

    }
    
    private void NewGameBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	playClickSound();
        NewGame newgame=new NewGame(mainFrame);
        newgameObj = newgame;
        newgame.setVisible(true);

    }
    
    public static NewGame newGamePnlObject()
    {
    	return newgameObj;
    }

    private void LoadSvdGameBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	//MainMenuPnl.setVisible(false);
    	playClickSound();
        LoadSavedGameView load=new LoadSavedGameView(mainFrame);
        load.setVisible(true);
    }

    private void QuitGameBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	playClickSound();
        System.exit(0);
    }
    
    public static void setPlayerNumber(Integer newNum)
    {
    	num_of_players = newNum;
    }
    
    public static Integer getPlayerNumber()
    {
    	return num_of_players;
    }
    public static void setCompPlayerNumber(Integer newNum)
    {
    	num_of_comp = newNum;
    }
    
    public static Integer getCompPlayerNumber()
    {
    	return num_of_comp;
    }
    
    public static void playClickSound()
    {
    	if(sound == true) {
	      try 
	      {
	       AudioInputStream audioInput = AudioSystem.getAudioInputStream(clickSound);
	       Clip clip = AudioSystem.getClip();
	       clip.open(audioInput);
	       clip.start();
	      }
	      catch(Exception ex)
	      {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace( );
	      }}
    } 
    
    public static void playBGmusic(Boolean newSound)
    {	sound = newSound;
    	
    
	   if(newSound == true) 
	       {
	    	   clip.start();
		       clip.loop(Clip.LOOP_CONTINUOUSLY);
	         }
       else if(newSound == false)
	    	{
	    	   clip.stop();
	    	}    
    }
    
    public static void setLabels(boolean Labels) {
    	game_labels = Labels;
    }
    public static void setSound(boolean _sound) {
    	sound = _sound;
    }
    
    public static void openGame(Player[] players) throws IOException
    {
    	GameWindow game = new GameWindow(sound,game_labels, num_of_players,num_of_comp,players);
    }

}

