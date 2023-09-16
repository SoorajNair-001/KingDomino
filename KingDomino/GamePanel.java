/*creates the GamePanel class which is the main panel for the game with the
 * user choosen settings for the game board*/
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


public class GamePanel extends JPanel {
	private JFrame gameFrame;
	private JPanel kingdomPnl;
	private JPanel kingdom;
	private JPanel gameinfo;
	private JPanel gamePlayPnl;
	private JLabel kingdomLbl;
	private JLabel gamePlayLbl;
	private JButton MenuBtn;
	private JButton SettingsBtn;
    private  static Boolean sound;
    private static Boolean game_labels;
    private static Integer num_of_players;
    private static Integer num_of_comp;
    private JLabel meeple;
    private Player[] players;
    private PlayerKingdom plrKingdom;
    private GameBoard board;
    private AudioInputStream audioInputStream;
    public static URL clickSound;
    private URL gameMusic;
    private static Clip clip;

    public GamePanel(JFrame gameFrame,Boolean sound,Boolean game_labels, Integer num_of_players,Integer num_of_comp,Player[] players) throws IOException {
    	this.sound = sound;
    	this.game_labels = game_labels;
    	this.num_of_players = num_of_players;
    	this.num_of_comp = num_of_comp;
    	this.players = players;
    	this.gameFrame = gameFrame;
    	clickSound = getClass().getResource("Sounds/click_sound.wav");
    	gameMusic = getClass().getResource("Sounds/gamePlay_music.wav");
    	try {
    	audioInputStream = AudioSystem.getAudioInputStream(gameMusic);
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
    	MainMenu.playBGmusic(false);
    	this.playBGmusic(sound);
        initComponents();
        gameFrame.setBackground(Color.BLACK);
       clearKingdom();
    }

    private void initComponents() throws IOException {
    	kingdomPnl = new JPanel();
    	kingdom = new JPanel();
    	gamePlayPnl = new JPanel();
    	gameinfo = new JPanel();
    	kingdomLbl = new JLabel();
    	gamePlayLbl = new JLabel();
    	MenuBtn = new JButton();
    	SettingsBtn = new JButton();
    	JLabel gameLogo = new JLabel();
    	
    	
    	JPanel gamePnl = new JPanel(new BorderLayout());
    	JPanel pnl = new JPanel(new GridLayout(1,2));
    	JPanel logoPnl = new JPanel(new FlowLayout());
    	JPanel controls = new JPanel(new BorderLayout());
    	JPanel kingdomLblPnl = new JPanel(new FlowLayout());
    	JPanel gameLblPnl = new JPanel(new FlowLayout());
    	kingdomPnl.setLayout(new BorderLayout());
    	kingdomLbl.setText("Player Kingdom");
    	kingdomLbl.setForeground(Color.BLACK);
    	kingdomLbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));
    	JButton right = new JButton();
    	JButton left = new JButton();
    	meeple = new JLabel();
    	kingdomLblPnl.add(left);
    	kingdomLblPnl.add(meeple);
    	kingdomLblPnl.add(kingdomLbl);
    	kingdomLblPnl.add(right);
    	try {
            Image img = ImageIO.read(getClass().getResource("Images/right_a.png"));
            right.setIcon(new ImageIcon(img));
            right.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
    	right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
					rightButtonActionPerformed(evt);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         });
    	try {
            Image img = ImageIO.read(getClass().getResource("Images/left_a.png"));
            left.setIcon(new ImageIcon(img));
            left.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
    	left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
					leftButtonActionPerformed(evt);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         });
    	
    	
    	gamePlayPnl.setLayout(new BorderLayout());
    	gamePlayLbl.setText("GAME");
    	gamePlayLbl.setForeground(Color.BLACK);
    	gamePlayLbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));
    	gameLblPnl.add(gamePlayLbl);
    	
        
    	plrKingdom = new PlayerKingdom(players,meeple);
        board = new GameBoard(players,game_labels,num_of_players,num_of_comp,plrKingdom);
    	
        
    	
    	kingdomPnl.add("North",kingdomLblPnl);
    	kingdomPnl.add("Center",plrKingdom);
    	kingdomPnl.setBackground(new Color(0,0,0,0));
    	gamePlayPnl.add("North",gameLblPnl);
    	gamePlayPnl.add("Center",board);
    	gamePlayPnl.setBackground(new Color(0,0,0,0));
    	
    	
    	try {
            Image img = ImageIO.read(getClass().getResource("Images/menu_button.png"));
            MenuBtn.setIcon(new ImageIcon(img));
            MenuBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
          MenuBtn.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  try {
					MenuBtnActionPerformed(evt);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }
          });
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
       					e.printStackTrace();
    				}
                }
            });
    	
    	pnl.add(gamePlayPnl);
    	pnl.add(kingdomPnl);
    	pnl.setBackground(new Color(0,0,0,0));
    	
    	try {
            Image img = ImageIO.read(getClass().getResource("Images/Kingdomino-Logo_small.png"));
            gameLogo.setIcon(new ImageIcon(img));
            gameLogo.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
    	logoPnl.add(gameLogo);
    	logoPnl.setBackground(new Color(0,0,0,0));
    	controls.add("East",MenuBtn);
    	controls.add("West",SettingsBtn);
    	controls.add("Center",logoPnl);
    	controls.setBackground(new Color(0,0,0,0));
    	gamePnl.add("North",controls);
    	gamePnl.add("Center",pnl);
    	gamePnl.setBackground(new Color(0,0,0,0));
        
        JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new OverlayLayout(backgroundPanel));

		backgroundPanel.add(gamePnl);
		

    	gameFrame.add(backgroundPanel);
    }
    
    public void setMeeple(String color) {
    	try {
            Image img = ImageIO.read(getClass().getResource("Images/"+color+".png"));
            meeple.setIcon(new ImageIcon(img));
            meeple.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
    }
    
    public GameBoard getBoard() {
    	return board;
    }
    private void MenuBtnActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException {
        // TODO add your handling code here:
    	playClickSound();
    	Menu menuwindow = new Menu(gameFrame,sound,game_labels);
		menuwindow.setVisible(true);
        
       // newgame.setVisible(true);

    }
    
    private void SettingsBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	playClickSound();
        Settings settings=new Settings("game",gameFrame,sound,game_labels,"game");
        sound = settings.getMuted();
        playBGmusic(sound);
        settings.setVisible(true);

    }
    
    public void rightButtonActionPerformed(java.awt.event.ActionEvent evt)throws IOException {
    	int id = plrKingdom.getCurrentPlayerID();
    	id++;
    	if(id>4) {
    		id= 1;
    	}
    	plrKingdom.setCurrentPlayerID(id);
    	playClickSound();
    }
    public void leftButtonActionPerformed(java.awt.event.ActionEvent evt)throws IOException {
    	int id = plrKingdom.getCurrentPlayerID();
    	id--;
    	if(id<1) {
    		id= 4;
    	}
    	plrKingdom.setCurrentPlayerID(id);
    	playClickSound();
    }
    public static void setLabels(boolean Labels) {
    	game_labels = Labels;
    }
    public static void setSound(boolean _sound) {
    	sound = _sound;
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
    
    private void clearKingdom() {
    	String[] newKingdom = new String[25];
		for(int i=0;i<25;i++) {
				newKingdom[i] = "";
		}
		PlayerKingdom.updateKingdom(1, newKingdom);
		PlayerKingdom.updateKingdom(2, newKingdom);
		PlayerKingdom.updateKingdom(3, newKingdom);
		PlayerKingdom.updateKingdom(4, newKingdom);
    }
}


