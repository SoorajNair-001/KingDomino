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


public class NewGame extends JFrame {
	private JFrame mainFrame;
    private javax.swing.JButton ColorSchemeBtn;
    private javax.swing.JLabel ColorSchemeLbl;
    private javax.swing.JComboBox<String> ComputerPlyrCmb;
    private javax.swing.JComboBox<String> DifficultyLvlCmb;
    private javax.swing.JLabel DifficultyLvlLbl;
    private javax.swing.JComboBox<String> NumberOfPlyrCmb;
    private javax.swing.JLabel SelectAIplyrLbl;
    private javax.swing.JLabel SelectPlayerlbl;
    private javax.swing.JButton nextBtn;
    private javax.swing.JPanel StartGamePnl;
    private javax.swing.JLabel StartNewGameLbl;
    private javax.swing.JButton goToMainMenuBtn;

    public NewGame(JFrame mainFrame) throws IOException  {
    	this.mainFrame = mainFrame;
    	setLocation(350,200);
    	setSize(640,450);
    	setUndecorated(true);
    	setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        initComponents();
        
    }
    
    private void initComponents() throws IOException {

        StartGamePnl = new javax.swing.JPanel();
        SelectPlayerlbl = new javax.swing.JLabel();
        SelectAIplyrLbl = new javax.swing.JLabel();
        NumberOfPlyrCmb = new javax.swing.JComboBox<>();
        ComputerPlyrCmb = new javax.swing.JComboBox<>();
        goToMainMenuBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        StartNewGameLbl = new javax.swing.JLabel();
        DifficultyLvlLbl = new javax.swing.JLabel();
        DifficultyLvlCmb = new javax.swing.JComboBox<>();
        ColorSchemeLbl = new javax.swing.JLabel();
        ColorSchemeBtn = new javax.swing.JButton();

        SelectPlayerlbl.setText("Select number of players:");
        SelectPlayerlbl.setForeground(Color.WHITE);
        SelectPlayerlbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));

        SelectAIplyrLbl.setText("Number of computer players:");
        SelectAIplyrLbl.setForeground(Color.WHITE);
        SelectAIplyrLbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));

        NumberOfPlyrCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "3", "2" }));
        NumberOfPlyrCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfPlyrCmbActionPerformed(evt);
            }
        });

        ComputerPlyrCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0","1"}));
        ComputerPlyrCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfCmpCmbActionPerformed(evt);
            }
        });
        
        
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

        try {
            Image img = ImageIO.read(getClass().getResource("Images/next_button.png"));
            nextBtn.setIcon(new ImageIcon(img));
            nextBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					NextBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        StartNewGameLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StartNewGameLbl.setText("Start New Game");
        StartNewGameLbl.setForeground(Color.YELLOW);
        StartNewGameLbl.setFont(new Font("Chalkboard", Font.PLAIN,50));

        DifficultyLvlLbl.setText("Difficulty level:");
        DifficultyLvlLbl.setForeground(Color.WHITE);
        DifficultyLvlLbl.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        DifficultyLvlCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "easy", "hard" }));
        DifficultyLvlCmb.setEnabled(false);
        DifficultyLvlLbl.setEnabled(false);


        javax.swing.GroupLayout StartGamePnlLayout = new javax.swing.GroupLayout(StartGamePnl);
        StartGamePnl.setLayout(StartGamePnlLayout);
        StartGamePnlLayout.setHorizontalGroup(
                StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(StartNewGameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(35,35,35)
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addComponent(DifficultyLvlLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(SelectAIplyrLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                                        .addComponent(SelectPlayerlbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(NumberOfPlyrCmb, 150, 150, 150)
                                                .addComponent(ComputerPlyrCmb, 150, 150, 150)
                                                .addComponent(DifficultyLvlCmb,150, 150, 150)))
                                .addGap(209, 209, 209))
                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(goToMainMenuBtn,300,300,300)
                                .addComponent(nextBtn,300,300,300))
                                
        );
        StartGamePnlLayout.setVerticalGroup(
                StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartGamePnlLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(StartNewGameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(SelectPlayerlbl))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StartGamePnlLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NumberOfPlyrCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(StartGamePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(SelectAIplyrLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(DifficultyLvlLbl)
                                                .addGap(10, 10, 10))
                                        .addGroup(StartGamePnlLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(ComputerPlyrCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(20,20,20)
                                                .addComponent(DifficultyLvlCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20,20,20)
                                                .addGap(25, 25, 25)))
         
                                .addGroup(StartGamePnlLayout.createParallelGroup()
                                .addComponent(goToMainMenuBtn)
                                .addComponent(nextBtn)))
                                
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

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
    	MainMenu.setPlayerNumber(Integer.valueOf((String) NumberOfPlyrCmb.getSelectedItem()));
    	MainMenu.setCompPlayerNumber(Integer.valueOf((String) ComputerPlyrCmb.getSelectedItem()));
    	PlayerColorSettings plyrsettings=new PlayerColorSettings(mainFrame);
        plyrsettings.setVisible(true);
    }

    private void goToMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	MainMenu.playClickSound();
        this.setVisible(false);
        //MainMenu mainview=new MainMenu();
        //mainview.setVisible(true);
    }
    
    private void NumberOfCmpCmbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int Index = ComputerPlyrCmb.getSelectedIndex();
        MainMenu.setCompPlayerNumber(Index);;
        if (Index==0){
            DifficultyLvlCmb.setEnabled(false);
        }else{
            DifficultyLvlCmb.setEnabled(true);
            DifficultyLvlLbl.setEnabled(true);
        }
    }
    

    private void NumberOfPlyrCmbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	Integer num = Integer.valueOf((String) NumberOfPlyrCmb.getSelectedItem());
    	if(num == 2)
        {
        	ComputerPlyrCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0","1"}));
        }
    	else if(num == 3)
        {
        	ComputerPlyrCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0","1", "2"}));
        }
        else if(num == 4)
        {
        	ComputerPlyrCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0","1", "2", "3"}));
        }
        ComputerPlyrCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfCmpCmbActionPerformed(evt);
            }
        });
    }
    
    
}
