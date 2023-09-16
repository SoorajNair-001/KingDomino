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


public class LoadSavedGameView extends JFrame {
	private JFrame mainFrame;
	private JPanel LoadGamePnl;
    private JButton GobackBtn;
    private JButton LdSvdGameBtn;
    private JPanel LoadSavedGame;
    private JLabel LoadSvdGmeLbl;
    private JLabel SlctgameLbl;
    private JLabel jLabel2;
    private JComboBox<String> lodFileCmb;

    public LoadSavedGameView(JFrame mainFrame) throws IOException {
    	this.mainFrame = mainFrame;
    	setLocation(350,200);
    	setSize(640,450);
    	setUndecorated(true);
    	setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
    	initComponents();
    }

    private void initComponents() throws IOException {
    	
    	LoadGamePnl = new JPanel();
        LoadSvdGmeLbl = new JLabel();
        SlctgameLbl = new JLabel();
        lodFileCmb = new JComboBox<>();
        LdSvdGameBtn = new JButton();
        GobackBtn = new JButton();
        
        LoadSvdGmeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoadSvdGmeLbl.setText("Load Saved Game");
        LoadSvdGmeLbl.setForeground(Color.YELLOW);
        LoadSvdGmeLbl.setFont(new Font("Chalkboard", Font.PLAIN,50));

        
        SlctgameLbl.setText("Select saved game:");
        SlctgameLbl.setForeground(Color.WHITE);
        SlctgameLbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));

        try {
            Image img = ImageIO.read(getClass().getResource("Images/load_button.png"));
            LdSvdGameBtn.setIcon(new ImageIcon(img));
            LdSvdGameBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        LdSvdGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LdSvdGameBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(LoadGamePnl);
        LoadGamePnl.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        		.addGap(50,50,50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(LoadSvdGmeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LdSvdGameBtn)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(SlctgameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lodFileCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(GobackBtn, 300,300,300)
                                .addGap(193, 193, 193)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(LoadSvdGmeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lodFileCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SlctgameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(LdSvdGameBtn)
                                .addGap(18, 18, 18)
                                .addComponent(GobackBtn)
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout1);
        layout1.setHorizontalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout1.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LoadGamePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout1.setVerticalGroup(
                layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LoadGamePnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JLabel bgImage = new JLabel();
        Image img1 = ImageIO.read(getClass().getResource("Images/popUp.png"));
        bgImage.setIcon(new javax.swing.ImageIcon(img1));
        LoadGamePnl.add(bgImage);
        bgImage.setBounds(-25, -25, 700, 500);

        mainFrame.add(LoadGamePnl);
    }// </editor-fold>

    private void LdSvdGameBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
    }

    private void GobackBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
        this.setVisible(false);
        //MainMenu menu=new MainMenu();
        //menu.setVisible(true);
    }
}