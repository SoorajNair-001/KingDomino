import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.awt.geom.*;
import java.io.*;


public class PlayerKingdom extends JPanel{
	private JPanel kingdomPnl;
	private Integer num_of_players;
	private int currentPlayerID;
	private Player[] players;
	private String[] kingdom_array;
	private JLabel playerCastle;
	private JLabel meeple;
	private static String tile1ToAdd;
	private static String tile2ToAdd;
	private int tileX=0;
	private int tileY=0;
	private JButton[] buttons;
	private static boolean meeplePlaced = false;
	private static boolean selectionStarted = false;
	public PlayerKingdom(Player[] players,JLabel meeple) throws IOException {
		this.players = players;
		this.meeple = meeple;
		setSize(635,450);
		setBackground(new Color(0,0,0));
		setBorder(BorderFactory.createLineBorder(Color.black));
    	setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
    	kingdom_array = new String[81];
    	buttons = new JButton[81];
    	for(int i=0;i<81;i++) {
    		buttons[i] = new JButton();
    	}
    	tile1ToAdd = "";
    	tile2ToAdd = "";
	}

	private void setPlayerCastle() throws IOException {
		kingdomPnl = new JPanel(new GridLayout(9,9));
		playerCastle = new JLabel();
		if(currentPlayerID == 1) {
			playerCastle = new JLabel();
			try {
	            Image img = ImageIO.read(getClass().getResource("Images/"+players[0].getColor()+"_castle.png"));
	            playerCastle.setIcon(new ImageIcon(img));
	            playerCastle.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			playerCastle.setHorizontalAlignment(JLabel.CENTER);
			setMeeple(players[0].getColor());
		}
		else if(currentPlayerID == 2) {
			playerCastle = new JLabel();
			try {
	            Image img = ImageIO.read(getClass().getResource("Images/"+players[1].getColor()+"_castle.png"));
	            playerCastle.setIcon(new ImageIcon(img));
	            playerCastle.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			playerCastle.setHorizontalAlignment(JLabel.CENTER);
			setMeeple(players[1].getColor());
		}
		else if(currentPlayerID == 3) {
			playerCastle = new JLabel();
			try {
	            Image img = ImageIO.read(getClass().getResource("Images/"+players[2].getColor()+"_castle.png"));
	            playerCastle.setIcon(new ImageIcon(img));
	            playerCastle.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			playerCastle.setHorizontalAlignment(JLabel.CENTER);
			setMeeple(players[2].getColor());
		}
		else if(currentPlayerID == 4) {
			playerCastle = new JLabel();
			try {
	            Image img = ImageIO.read(getClass().getResource("Images/"+players[3].getColor()+"_castle.png"));
	            playerCastle.setIcon(new ImageIcon(img));
	            playerCastle.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			playerCastle.setHorizontalAlignment(JLabel.CENTER);
			setMeeple(players[3].getColor());
		}
		this.setLayout(new BorderLayout());
		JButton up = new JButton();
		JButton down = new JButton();
		JButton left = new JButton();
		JButton right = new JButton();
		try {
            Image img = ImageIO.read(getClass().getResource("Images/up.png"));
            up.setIcon(new ImageIcon(img));
            up.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
			up.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  try {
					upButtonActionP(evt);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              }
          });
		try {
	            Image img = ImageIO.read(getClass().getResource("Images/down.png"));
	            down.setIcon(new ImageIcon(img));
	            down.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
				down.addActionListener(new java.awt.event.ActionListener() {
	              public void actionPerformed(java.awt.event.ActionEvent evt) {
	                  try {
						downButtonActionP(evt);
					} catch (HeadlessException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	              }
	          });
		try {
		         Image img = ImageIO.read(getClass().getResource("Images/left.png"));
		         left.setIcon(new ImageIcon(img));
		          left.setBorder(null);
		          } catch (Exception ex) {
		            System.out.println(ex);
		          }
				left.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		          try {
							leftButtonActionP(evt);
						} catch (HeadlessException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		              }
		          });
		try {
			     Image img = ImageIO.read(getClass().getResource("Images/right.png"));
			     right.setIcon(new ImageIcon(img));
			     right.setBorder(null);
			     } catch (Exception ex) {
			     System.out.println(ex);
			     }
			     right.addActionListener(new java.awt.event.ActionListener() {
			             public void actionPerformed(java.awt.event.ActionEvent evt) {
			                  try {
								rightButtonActionP(evt);
							} catch (HeadlessException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			              }
			          });
						
		this.add("North",up);
		this.add("South",down);
		this.add("East",right);
		this.add("West",left);
		this.add("Center",kingdomPnl);
	}
	public void setCurrentPlayerID(int plrID) throws IOException {
		currentPlayerID = plrID;
		setPlayerKingdom(currentPlayerID);
		this.removeAll();
		setPlayerCastle();
		displayKingdom();
	}
	
	public int getCurrentPlayerID() {
		return currentPlayerID;
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
	
	public void displayKingdom() {
		int i =0;
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				if(x==4 & y==4) {
					kingdomPnl.add(playerCastle);
					i++;
				}
				else if(x>=2 && x<=6 && y>=2 && y<=6){
					kingdomPnl.add(buttons[i]);
					buttons[i].setText(kingdom_array[i]);
					buttons[i].setName(String.valueOf(i));
					JButton btn = buttons[i];
					
					buttons[i].addActionListener(new java.awt.event.ActionListener() {
			             public void actionPerformed(java.awt.event.ActionEvent evt) {
			                  try {
								tileButtonActionPerformed(evt,btn);
							} catch (HeadlessException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			              }
			          });
					i++;
					}
				else {
					JButton empty = new JButton();
					kingdomPnl.add(empty);	
				}
		    }
		}
	}
	public void setPlayerKingdom(int playerNum) {
		if(playerNum!=0) {
		String fileName = "Kingdoms/kingdom"+playerNum+".txt";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			int i = 0;
			while ((line = br.readLine()) != null) {
				kingdom_array[i] = line;
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		else {
			for(int i =0;i<25;i++) {
				kingdom_array[i] = null;
			}
		}
	}
	
	public static void updateKingdom(int playerNum, String[] newKingdom){
		if(playerNum!=0) {
			String fileName = "Kingdoms/kingdom"+playerNum+".txt";
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			for (int i = 0; i < 25; i++) {
				writer.write(newKingdom[i]);
				writer.newLine();
			}
				writer.close();
			
			}
			 catch (IOException e) {
					e.printStackTrace();}
		}
	}
	
	public static void setTileToAdd(String newTile1,String newTile2) {
		tile1ToAdd = newTile1;
		tile2ToAdd = newTile2;
	}
	
	public static void setMeeplePlaced(boolean newMeepleP) {
		meeplePlaced = newMeepleP;
	}
	public static void setSelectionStarted(boolean newSelectS) {
		selectionStarted = newSelectS;
	}
	
	public void upButtonActionP(java.awt.event.ActionEvent evt)throws IOException {
		kingdomPnl.setLocation(kingdomPnl.getX(),kingdomPnl.getY()-20);
		GamePanel.playClickSound();
	}
	public void downButtonActionP(java.awt.event.ActionEvent evt)throws IOException {
		kingdomPnl.setLocation(kingdomPnl.getX(),kingdomPnl.getY()+20);
		GamePanel.playClickSound();
	}
	public void leftButtonActionP(java.awt.event.ActionEvent evt)throws IOException {
		kingdomPnl.setLocation(kingdomPnl.getX()-20,kingdomPnl.getY());
		GamePanel.playClickSound();
	}
	public void rightButtonActionP(java.awt.event.ActionEvent evt)throws IOException {
		kingdomPnl.setLocation(kingdomPnl.getX()+20,kingdomPnl.getY());
		GamePanel.playClickSound();
	}
	public void tileButtonActionPerformed(java.awt.event.ActionEvent evt,JButton tile)throws IOException {
		if(!meeplePlaced && selectionStarted) {
			GamePanel.playClickSound();
			tile.setText(tile1ToAdd);
			int position = Integer.valueOf(tile.getName());
			buttons[position+1].setText(tile2ToAdd);
			meeplePlaced = true;
			GameBoard.setMeeplePlaced(meeplePlaced);
			GameBoard.setSelectionStarted(false);
			
			String[] newKingdom = new String[25];
			for(int i=0;i<25;i++) {
				if(i==position) {
					newKingdom[i] = tile1ToAdd;
					newKingdom[i+1] = tile2ToAdd;
					i++;
				}
				else {
					newKingdom[i] = "";
				}
			}
			updateKingdom(currentPlayerID, newKingdom);
		}
	}
}
