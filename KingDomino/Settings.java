import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class Settings extends JFrame {
	private JFrame mainFrame;
    private javax.swing.JButton ColorSchemeBtn;
    private javax.swing.JLabel ColorSchemeLbl;
    private JButton LabelSelectedBtn;
    private JButton SoundBtn;
    private javax.swing.JLabel GameLabelslbl;
    private javax.swing.JLabel Soundlbl;
    private javax.swing.JPanel StartGamePnl;
    private javax.swing.JLabel SettingsLbl;
    private javax.swing.JButton goToMainMenuBtn;
    private String accessedFrom;
    private Boolean sound;
    private Boolean game_labels;
    private String SoundOf;

    public Settings(String accessedFrom,JFrame mainFrame,Boolean sound,Boolean game_labels,String SoundOf) throws IOException  {
    	this.accessedFrom = accessedFrom;
    	this.mainFrame = mainFrame;
    	this.sound = sound; 
    	this.game_labels = game_labels;
    	this.SoundOf = SoundOf;
    	setLocation(350,200);
    	setSize(640,450);
    	setUndecorated(true);
    	setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        initComponents();
        
    }
    
    private void initComponents() throws IOException {

        StartGamePnl = new javax.swing.JPanel();
        Soundlbl = new javax.swing.JLabel();
        GameLabelslbl = new javax.swing.JLabel();
        SoundBtn = new JButton();
        LabelSelectedBtn = new JButton();
        goToMainMenuBtn = new javax.swing.JButton();
        SettingsLbl = new javax.swing.JLabel();
        ColorSchemeLbl = new javax.swing.JLabel();
        ColorSchemeBtn = new javax.swing.JButton();


        Soundlbl.setText("Sound ON/OFF:");
        Soundlbl.setForeground(Color.WHITE);
        Soundlbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));

        GameLabelslbl.setText("Display Labels ON/OFF:");
        GameLabelslbl.setForeground(Color.WHITE);
        GameLabelslbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        
        if(accessedFrom.equals("game")) {
        	GameLabelslbl.setVisible(false);
        }

        try {
            Image img = ImageIO.read(getClass().getResource("Images/back_button.png"));
            goToMainMenuBtn.setIcon(new ImageIcon(img));
            goToMainMenuBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        goToMainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMainMenuBtnActionPerformed(evt);
            }
        });
        
        if(sound == true) {
        	try {
                Image img = ImageIO.read(getClass().getResource("Images/unMute_button.png"));
                SoundBtn.setIcon(new ImageIcon(img));
                SoundBtn.setBorder(null);
              } catch (Exception ex) {
                System.out.println(ex);
              }
	    	
    	}
    	else if(sound == false) {
    		try {
                Image img = ImageIO.read(getClass().getResource("Images/mute_button.png"));
                SoundBtn.setIcon(new ImageIcon(img));
                SoundBtn.setBorder(null);
              } catch (Exception ex) {
                System.out.println(ex);
              }
	    	}
        SoundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	SoundBtnActionPerformed(evt);
            }
        });;
        
        if(game_labels == false) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/notSelected_button.png"));
	            LabelSelectedBtn.setIcon(new ImageIcon(img));
	            LabelSelectedBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	
    	}
    	else if(game_labels== true) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/selected_button.png"));
	            LabelSelectedBtn.setIcon(new ImageIcon(img));
	            LabelSelectedBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	
    	}

        LabelSelectedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	LabelsSelectedBtnActionPerformed(evt);
            }
        });
        
        if(accessedFrom.equals("game")) {
        	LabelSelectedBtn.setVisible(false);
        }
        
        SettingsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SettingsLbl.setText("Game Settings");
        SettingsLbl.setForeground(Color.YELLOW);
        SettingsLbl.setFont(new Font("Chalkboard", Font.PLAIN,50));


        javax.swing.GroupLayout StartGamePnlLayout = new javax.swing.GroupLayout(StartGamePnl);
        StartGamePnl.setLayout(StartGamePnlLayout);
        StartGamePnlLayout.setHorizontalGroup(
                StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(SettingsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(100,100,100)
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()       
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(GameLabelslbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                                        .addComponent(Soundlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SoundBtn, 150, 150, 150)
                                                .addComponent(LabelSelectedBtn, 150, 150, 150)
                                            )
                                        )
                                .addGap(209, 209, 209))
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(goToMainMenuBtn,300,300,300)));
        StartGamePnlLayout.setVerticalGroup(
                StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartGamePnlLayout.createSequentialGroup()
                                .addGap(0,0,0)
                                .addComponent(SettingsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(Soundlbl))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartGamePnlLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SoundBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)))
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                        		.addGap(20, 20, 20)
                                                .addComponent(GameLabelslbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGap(20, 20, 20)
                                                .addComponent(LabelSelectedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                )
                                .addGap(10,10,10)
                                .addGroup(StartGamePnlLayout.createParallelGroup()		
                                .addComponent(goToMainMenuBtn)
                                ))
                                
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(StartGamePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(StartGamePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        JLabel bgImage = new JLabel();
        
        Image img1 = ImageIO.read(getClass().getResource("Images/popUp.png"));
        bgImage.setIcon(new javax.swing.ImageIcon(img1));
        StartGamePnl.add(bgImage);
        bgImage.setBounds(-25, -25, 700, 500);

        mainFrame.add(StartGamePnl);
    }// </editor-fold>

    private void SoundBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	if(sound == true) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/mute_button.png"));
	            SoundBtn.setIcon(new ImageIcon(img));
	            SoundBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	sound = false;
	    	
	    	if (SoundOf.equals("main")){
	    		MainMenu.playBGmusic(sound);
	    	}
	    	else if (SoundOf.equals("game"))
	    	{
	    		GamePanel.playBGmusic(sound);
	    	}
	    	
	    	
    	}
    	else if(sound == false) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/unMute_button.png"));
	            SoundBtn.setIcon(new ImageIcon(img));
	            SoundBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	sound = true;
	    	if (SoundOf.equals("main")){
	    		MainMenu.playBGmusic(sound);
	    	}
	    	else if (SoundOf.equals("game"))
	    	{
	    		GamePanel.playBGmusic(sound);
	    	}
	    	
    	}
    }

    private void goToMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
    	if(GamePanel.clickSound != null) {
    		GamePanel.playClickSound();
    	}
        this.setVisible(false);
        //MainMenu mainview=new MainMenu();
        //mainview.setVisible(true);
    }

    private void LabelsSelectedBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	if(game_labels == false) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/selected_button.png"));
	            LabelSelectedBtn.setIcon(new ImageIcon(img));
	            LabelSelectedBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	game_labels = true;
	    	MainMenu.setLabels(game_labels);
	    	GamePanel.setLabels(game_labels);
	    	
    	}
    	else if(game_labels== true) {
    		MainMenu.playClickSound();
	    	try {
	            Image img = ImageIO.read(getClass().getResource("Images/notSelected_button.png"));
	            LabelSelectedBtn.setIcon(new ImageIcon(img));
	            LabelSelectedBtn.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
	    	game_labels = false;
	    	MainMenu.setLabels(game_labels);
	    	GamePanel.setLabels(game_labels);
    	}
    }
    
    public void resetTiles() {
    	GameBoard.getTile(5);
    }

    public Boolean getMuted()
    {
    	return sound;
    }
    
}
