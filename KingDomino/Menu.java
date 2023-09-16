import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static javax.swing.SwingConstants.CENTER;

public class Menu extends JFrame {
    private boolean saved;
    private JFrame gameFrame;
    private JButton goBackBtn;
    private JLabel MenuLbl;
    private JPanel MenuPnl;
    private JButton GotoMainMenu;
    private JButton QuitgameBtn;
    private JButton SaveGamebtn;
    private boolean sound;
    private boolean labels;
    private boolean gameSaved = false;

    public Menu(JFrame gameFrame,boolean sound,boolean labels) throws HeadlessException, IOException {
        this.gameFrame = gameFrame;
        this.sound = sound;
        this.labels = labels;
        initComponents();
        setLocation(350,200);
        setSize(640,450);
        setUndecorated(true);
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
    }

    private void initComponents() throws IOException {

        MenuPnl = new JPanel();
        MenuLbl = new JLabel();
        goBackBtn = new JButton();
        GotoMainMenu = new JButton();
        SaveGamebtn = new JButton();
        QuitgameBtn = new JButton();

        MenuLbl.setHorizontalAlignment(CENTER);
        MenuLbl.setText("Menu");
        MenuLbl.setForeground(Color.YELLOW);
        MenuLbl.setFont(new Font("Chalkboard", Font.PLAIN,50));

        try {
            Image img = ImageIO.read(getClass().getResource("Images/back_button.png"));
            goBackBtn.setIcon(new ImageIcon(img));
            goBackBtn.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosMenuBtnActionPerformed(evt);
            }
        });
        try {
            Image img = ImageIO.read(getClass().getResource("Images/MainMenu_button.png"));
            GotoMainMenu.setIcon(new ImageIcon(img));
            GotoMainMenu.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        GotoMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    GotoMainMenuBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            Image img = ImageIO.read(getClass().getResource("Images/saveGame_button.png"));
            SaveGamebtn.setIcon(new ImageIcon(img));
            SaveGamebtn.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        SaveGamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    SaveGamebtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            Image img = ImageIO.read(getClass().getResource("Images/Quit_button.png"));
            QuitgameBtn.setIcon(new ImageIcon(img));
            QuitgameBtn.setBorder(null);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        QuitgameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitgameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuWindowPnlLayout = new javax.swing.GroupLayout(MenuPnl);
        MenuPnl.setLayout(MenuWindowPnlLayout);
        MenuWindowPnlLayout.setHorizontalGroup(
                MenuWindowPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MenuWindowPnlLayout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(MenuWindowPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(GotoMainMenu, GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(MenuLbl, GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SaveGamebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                )
        );
        MenuWindowPnlLayout.setVerticalGroup(
                MenuWindowPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MenuWindowPnlLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(MenuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20,20,20)
                                .addComponent(GotoMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20,20,20)
                                .addComponent(SaveGamebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20,20,20)
                                .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MenuPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MenuPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JLabel bgImage = new JLabel();

        Image img1 = ImageIO.read(getClass().getResource("Images/popUp.png"));
        bgImage.setIcon(new javax.swing.ImageIcon(img1));
        MenuPnl.add(bgImage);
        bgImage.setBounds(-25, -25, 700, 500);

        gameFrame.add(MenuPnl);



    }// </editor-fold>

    private void GotoMainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this.getContentPane(), "Do you want to quit the game and go back to Main menu ?","Quit Game",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            int j = JOptionPane.showConfirmDialog(this.getContentPane(), "Do you want to discard current the game ?","save Game",JOptionPane.YES_NO_OPTION);
            if(j==JOptionPane.NO_OPTION){
                if(!gameSaved) {
                	SaveGame();
                	this.dispose();
                    new MainWindow().openMainMenu(sound,labels);
                    GamePanel.playBGmusic(false);
                    gameFrame.dispose();
                    gameSaved = false;
                }
            }
            if(j==JOptionPane.YES_OPTION){
                    this.dispose();
                    new MainWindow().openMainMenu(sound,labels);
                    GamePanel.playBGmusic(false);
                    gameFrame.dispose();
            }
        }
    }

    private void SaveGame() {
    	gameSaved = true;
    	System.out.println("#");
    }

    private void SaveGamebtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        JOptionPane savegamedialog = new JOptionPane();
        JLabel bgImage = new JLabel();

        Image img1 = ImageIO.read(getClass().getResource("Images/popUp.png"));
        bgImage.setIcon(new javax.swing.ImageIcon(img1));
        savegamedialog.add(bgImage);
        int i = savegamedialog.showConfirmDialog(this.getContentPane(), "Do you want to save the game ?","Save Game",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
        	SaveGame();
            JOptionPane.showMessageDialog(this.getContentPane(),"Game Saved");
        }
    }

    private void QuitgameBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this.getContentPane(), "Do you want to quit the game go back to Main menu ?","Quit Game",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }

    private void ClosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
    }


}
