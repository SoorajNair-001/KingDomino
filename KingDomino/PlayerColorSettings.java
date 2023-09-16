import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class PlayerColorSettings extends JFrame {
    private JFrame mainFrame;
    private JPanel PlayerSettingsPnl;
    private JButton GobackBtn;
    private JButton StartBtn;
    private JLabel PlayerSettingsLbl;
    private JLabel chseDisplayOptnLbl;
    private JLabel ErrorLbl;
    private javax.swing.JComboBox<String> Player1color;
    private javax.swing.JComboBox<String> Player2color;
    private javax.swing.JComboBox<String> Player3color;
    private javax.swing.JComboBox<String> Player4color;
    private JLabel [] PlayersList;
    private JLabel Player2Lbl;
    private JLabel Player1Lbl;
    private JLabel Player3Lbl;
    private JLabel Player4Lbl;
    private String p1Color;
    private String p2Color;
    private String p3Color;
    private String p4Color;
    private Integer num_of_players;


    public PlayerColorSettings(JFrame mainFrame) throws IOException {
    	this.mainFrame = mainFrame;
    	setLocation(350,200);
    	setSize(635,450);
    	setUndecorated(true);
    	setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
    	initComponents();
    }

    private void initComponents() throws IOException {
        PlayerSettingsPnl = new javax.swing.JPanel();
        Player4Lbl = new javax.swing.JLabel();
        Player1Lbl = new javax.swing.JLabel();
        Player2Lbl = new javax.swing.JLabel();
        Player3Lbl = new javax.swing.JLabel();
        ErrorLbl = new javax.swing.JLabel();
        Player2color = new javax.swing.JComboBox<>();
        Player1color = new javax.swing.JComboBox<>();
        Player4color = new javax.swing.JComboBox<>();
        Player3color = new javax.swing.JComboBox<>();
        GobackBtn = new javax.swing.JButton();
        StartBtn = new javax.swing.JButton();
        PlayerSettingsLbl = new javax.swing.JLabel();


        Player1Lbl.setText("  Player 1");
        Player1Lbl.setForeground(Color.WHITE);
        Player1Lbl.setFont(new Font("Chalkboard", Font.PLAIN,30));
        
        Player2Lbl.setText("  Player 2");
        Player2Lbl.setFont(new Font("Chalkboard", Font.PLAIN,30));
        Player2Lbl.setForeground(Color.WHITE);

        Player3Lbl.setText("  Player 3");
        Player3Lbl.setFont(new Font("Chalkboard", Font.PLAIN,30));
        Player3Lbl.setForeground(Color.WHITE);

        Player4Lbl.setText("  Player 4");
        Player4Lbl.setFont(new Font("Chalkboard", Font.PLAIN,30));
        Player4Lbl.setForeground(Color.WHITE);
        
        ErrorLbl.setText("  ! SELECT DIFFERENT COLOR FOR EACH PLAYER !");
        ErrorLbl.setForeground(Color.WHITE);
        ErrorLbl.setFont(new Font("Chalkboard", Font.PLAIN,20));
        
        
        Player1color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pink", "Yellow", "Green", "Blue" }));
        Player1color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfPlyrCmbActionPerformed(evt);
            }
        });
        Player2color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yellow", "Green", "Blue", "Pink" }));
        Player2color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfPlyrCmbActionPerformed(evt);
            }
        });
        Player3color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Green", "Blue", "Pink", "Yellow" }));
        Player3color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfPlyrCmbActionPerformed(evt);
            }
        });
        Player4color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Pink", "Yellow", "Green" }));
        Player4color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfPlyrCmbActionPerformed(evt);
            }
        });
        
        if (MainMenu.getCompPlayerNumber() == 1)
        {
        	if(MainMenu.getPlayerNumber() == 2)
        	{
        		Player2Lbl.setText("Computer");
        	}
        	if(MainMenu.getPlayerNumber() == 3)
        	{
        		Player3Lbl.setText("Computer");
        	}
        	if(MainMenu.getPlayerNumber() == 4)
        	{
        		Player4Lbl.setText("Computer");
        	}
        }
        else if (MainMenu.getCompPlayerNumber() == 2)
        {
        	if(MainMenu.getPlayerNumber() == 3)
        	{
        		Player2Lbl.setText("Computer 1");
        		Player3Lbl.setText("Computer 2");
        	}
        	if(MainMenu.getPlayerNumber() == 4)
        	{
        		Player3Lbl.setText("Computer 1");
        		Player4Lbl.setText("Computer 2");
        	}
        }
        else if (MainMenu.getCompPlayerNumber() == 3)
        {
 
        	if(MainMenu.getPlayerNumber() == 4)
        	{
        		Player2Lbl.setText("Computer 1");
        		Player3Lbl.setText("Computer 2");
        		Player4Lbl.setText("Computer 3");
        	}
        }

        
        PlayerSettingsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerSettingsLbl.setText("Player color Scheme");
        PlayerSettingsLbl.setForeground(Color.YELLOW);
        PlayerSettingsLbl.setFont(new Font("Chalkboard", Font.PLAIN,40));

        try {
            Image img = ImageIO.read(getClass().getResource("Images/start_button.png"));
            StartBtn.setIcon(new ImageIcon(img));
            StartBtn.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        StartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					StartBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        try {
            Image img = ImageIO.read(getClass().getResource("Images/back_button.png"));
            GobackBtn.setIcon(new ImageIcon(img));
            GobackBtn.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        GobackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	GobackBtnActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout PlayerSettingsPnlLayout = new javax.swing.GroupLayout(PlayerSettingsPnl);
        PlayerSettingsPnl.setLayout(PlayerSettingsPnlLayout);
        PlayerSettingsPnlLayout.setHorizontalGroup(
                PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerSettingsPnlLayout.createParallelGroup()
                        		.addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                        		.addGap(50, 50, 50 )
                                .addComponent(PlayerSettingsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                		.addGap(350, 350, 350)
                                        .addComponent(Player1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Player1color,150,150,150))
                                .addGap(10, 10, 10)
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(Player2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Player2color,150,150,150)))
                                .addGap(61, 61, 61)
                                .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                		.addGap(350, 350, 350)
                                        .addComponent(Player3Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Player3color,150,150,150))
                                .addGap(10,10,10)
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(Player4Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Player4color,150,150,150)))
                                .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                		.addGap(60,60,60)
                                		.addComponent(ErrorLbl,500,500,500))
                                .addGap(106, 106, 106))
                        .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(GobackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(StartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                                .addGap(193, 193, 193)
                                                ))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PlayerSettingsPnlLayout.setVerticalGroup(
                PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                        		.addGap(25, 25, 25)
                                .addComponent(PlayerSettingsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                //.addGap(25, 25, 25)
                                .addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
                                		.addGroup(PlayerSettingsPnlLayout.createParallelGroup()
                                				.addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
			                                        .addComponent(Player1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
			                                        .addComponent(Player1color))
                                				.addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
			                                        .addComponent(Player2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
			                                        .addComponent(Player2color)))
                                		.addGap(25, 25, 25)
                                		.addGroup(PlayerSettingsPnlLayout.createParallelGroup()
                                				.addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
			                                        .addComponent(Player3Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
			                                        .addComponent(Player3color))
                                				.addGroup(PlayerSettingsPnlLayout.createSequentialGroup()
			                                        .addComponent(Player4Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
			                                        .addComponent(Player4color)))
                                		.addGap(20,20,20)
                                		.addGroup(PlayerSettingsPnlLayout.createParallelGroup()
                                				.addComponent(ErrorLbl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addGap(25, 25, 25)
                                .addGroup(PlayerSettingsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GobackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(StartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62))
        );
        ErrorLbl.setVisible(false);
        num_of_players = MainMenu.getPlayerNumber();
        if(num_of_players == 2)
        {
        	Player3Lbl.setVisible(false);
        	Player3color.setVisible(false);
        	Player4Lbl.setVisible(false);
        	Player4color.setVisible(false);
        }
        else if(num_of_players == 3)
        {
        	Player4Lbl.setVisible(false);
        	Player4color.setVisible(false);
        }
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlayerSettingsPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PlayerSettingsPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JLabel bgImage = new JLabel();

        Image img1 = ImageIO.read(getClass().getResource("Images/popUp.png"));
        bgImage.setIcon(new javax.swing.ImageIcon(img1));
        PlayerSettingsPnl.add(bgImage);
        bgImage.setBounds(-25, -25, 700, 500);

        mainFrame.add(PlayerSettingsPnl);
    }// </editor-fold>
    
    public Player[] createPlayers() {
    	int num_plrs = MainMenu.getPlayerNumber();
    	if(num_of_players == 2) {
    		Player[] players = new Player[2];
    		players[0] = new Player(p1Color,1,0);
    		players[1] = new Player(p2Color,2,0);
    		return players;
    	}
    	else if(num_of_players == 3) {
    		Player[] players = new Player[3];
    		players[0] = new Player(p1Color,1,0);
    		players[1] = new Player(p2Color,2,0);
    		players[2] = new Player(p3Color,3,0);
    		return players;
    	}
    	else if(num_of_players == 4) {
    		Player[] players = new Player[4];
    		players[0] = new Player(p1Color,1,0);
    		players[1] = new Player(p2Color,2,0);
    		players[2] = new Player(p3Color,3,0);
    		players[3] = new Player(p4Color,4,0);
    		return players;
    	}
		return null;
    }

    private void NumberOfPlyrCmbActionPerformed(ActionEvent evt) {
    }

    private void StartBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
    	p1Color = String.valueOf(Player1color.getSelectedItem());
    	p2Color = String.valueOf(Player2color.getSelectedItem());
    	p3Color = String.valueOf(Player3color.getSelectedItem());
    	p4Color = String.valueOf(Player4color.getSelectedItem());

    	if(num_of_players == 2) {
        	if(!(p1Color.equals(p2Color)))
        			{ 
        				
        				ErrorLbl.setVisible(false);
        				StartGame();
        			}
        	else {
        		ErrorLbl.setVisible(true);
        	}}
    	
    	else if(num_of_players == 3) {
	    	if( !(p1Color.equals(p2Color)) &&
	    		!(p1Color.equals(p3Color)) &&
	    		!(p2Color.equals(p3Color)))
	    			{ 
	    				
	    				ErrorLbl.setVisible(false);
	    				StartGame();
	    			}
	    	else {
	    		ErrorLbl.setVisible(true);
    	}}
    	
    	else if(num_of_players == 4) {
	    	if( !(p1Color.equals(p2Color)) &&
	    		!(p1Color.equals(p3Color)) &&
	    		!(p1Color.equals(p4Color)) &&
	    		!(p2Color.equals(p3Color)) &&
	   			!(p2Color.equals(p4Color)) &&
	   			!(p3Color.equals(p4Color)))
	    			{ 
	    				
	    				ErrorLbl.setVisible(false);
	    				StartGame();
	    			}
	    	else {
	    		ErrorLbl.setVisible(true);
    	}}
    	
    	NewGame newGame = MainMenu.newGamePnlObject();
    	newGame.setVisible(false);
    }	
    
    private void StartGame() throws IOException
    {
    	Player[] players = createPlayers();
    	MainWindow.closeMainMenu();
    	this.setVisible(false);
	    MainMenu.openGame(players);
    }

    private void GobackBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
        this.setVisible(false);
    }

    public void setColor(){

    }
    public void playSound(String soundName)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
}