import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class GameBoard extends JPanel {
	public static JLabel infoLabel;
	private JPanel tilesPnl;
	private static PlayerKingdom kingdomPnl;
	private DominoTile[] Dominos1;
	private DominoTile[] Dominos2;
	private Player[] players;
	public static JButton tile1,tile2,tile3,tile4,tile5,tile6,tile7,tile8;
    private Integer num_of_players;
    private Integer num_of_comp;
	private static int currentPlayerID;
	private int turnsCompleted = 0;
	private boolean tile1Selected;
	private boolean tile2Selected;
	private boolean tile3Selected;
	private boolean tile4Selected;
	private boolean tile5Selected;
	private boolean tile6Selected;
	private boolean tile7Selected;
	private boolean tile8Selected;
	private int tile1SelectedBy;
	private int tile2SelectedBy;
	private int tile3SelectedBy;
	private int tile4SelectedBy;
	private int tile5SelectedBy;
	private int tile6SelectedBy;
	private int tile7SelectedBy;
	private int tile8SelectedBy;
	private String labels;
	private ArrayList<Integer> newplayerOrder;
	private static boolean game_labels;
	private JLabel mplLabel1;
	private JLabel mplLabel2;
	private JLabel mplLabel3;
	private JLabel mplLabel4;
	private JLabel mplLabel5;
	private JLabel mplLabel6;
	private JLabel mplLabel7;
	private JLabel mplLabel8;
	private static int round_num = 1;
	private static boolean meeplePlaced = false;
	private static boolean selectionStarted = false;
	
	public GameBoard(Player[] players,boolean game_labels,Integer num_of_players,Integer num_of_comp,PlayerKingdom kingdomPnl) throws IOException {
		this.players = players;
		this.num_of_players = num_of_players;
    	this.num_of_comp = num_of_comp;
    	this.kingdomPnl = kingdomPnl;
    	this.game_labels = game_labels;
    	currentPlayerID = 0;
    	newplayerOrder = new ArrayList<Integer>();
		setSize(635,450);
		setBackground(new Color(0,0,0,125));
		setBorder(BorderFactory.createLineBorder(Color.black));
    	setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		if(game_labels == true) {
			labels = "Tiles_Labeled";
		}
		else {
			labels = "Tiles_Unlabeled";
		}
		initComponents();
	}

	private void initComponents() throws IOException {
		infoLabel = new JLabel();
		tilesPnl = new JPanel();
		
		tile1 = new JButton();
		tile2 = new JButton();
		tile3 = new JButton();
		tile4 = new JButton();
		tile5 = new JButton();
		tile6 = new JButton();
		tile7 = new JButton();
		tile8 = new JButton();
		
		this.setLayout(new BorderLayout());
		infoLabel.setText("");
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setFont(new Font("Chalkboard", Font.PLAIN, 30));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GameRound round = new GameRound(1,game_labels,Dominos2,num_of_players,num_of_comp);
    	Dominos1 = round.getNewDominos1();
    	Dominos2 = round.getNewDominos2();
        if(round.getRoundNumber() == 1) {
	        setTileImage(tile1,Dominos1[0]);
	        setTileImage(tile2,Dominos1[1]);
	        setTileImage(tile3,Dominos1[2]);
	        setTileImage(tile4,Dominos1[3]);
	        setBlankTileImage(tile5);
	        setBlankTileImage(tile6);
	        setBlankTileImage(tile7);
	        setBlankTileImage(tile8);
	        }
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        infoLabel.setBorder(border);
        infoLabel.setBackground(new Color(49,52,53));
        infoLabel.setPreferredSize(new Dimension(250, 100));
        infoLabel.setOpaque(true);
        
        tile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile1BtnActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        tile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile2BtnActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        tile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile3BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile4BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tile5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile5BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tile6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile6BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tile7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile7BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        tile8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					Tile8BtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        
        JButton done_btn = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("Images/done.png"));
            done_btn.setIcon(new ImageIcon(img));
            done_btn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        done_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 try {
					doneButtonActionPerformed(evt);
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             }
         });
        
        tilesPnl.setLayout(new GridLayout(4,2,10,10));
        tilesPnl.setBackground(new Color(0,0,0,0));;
        tilesPnl.add(tile1);
        tilesPnl.add(tile5);
        tilesPnl.add(tile2);
        tilesPnl.add(tile6);
        tilesPnl.add(tile3);
        tilesPnl.add(tile7);
        tilesPnl.add(tile4);
        tilesPnl.add(tile8);
        
		this.add("North",infoLabel);
		this.add("Center",tilesPnl);
		this.add("East",done_btn);
	}
	

	public static JButton getTile(int tileNum) {
		if(tileNum == 1) {
			return tile1;}
		else if(tileNum == 2) {
			return tile2;
		}
		else if(tileNum == 3) {
			return tile3;
		}
		else if(tileNum == 4) {
			return tile4;
		}
		else if(tileNum == 5) {
			return tile5;
		}
		else if(tileNum == 6) {
			return tile6;
		}
		else if(tileNum == 7) {
			return tile7;
		}
		else if(tileNum == 8) {
			return tile8;
		}
		return null;
	}
	private void setTileImage(JButton btn,DominoTile domino) {
		try {
	          Image img = domino.getTileImage();
	          btn.setIcon(new ImageIcon(img));
	          btn.setBorder(null);
	        } catch (Exception ex) {
	          System.out.println(ex);
	        }
	}
	private void setBlankTileImage(JButton btn) {
		try {
	          Image img = ImageIO.read(getClass().getResource("Images/"+labels+"/blank_tile.png"));
	          btn.setIcon(new ImageIcon(img));
	          btn.setBorder(null);
	        } catch (Exception ex) {
	          System.out.println(ex);
	        }
	}
	
	public static void setCurrentPlayerID(int plrID) throws IOException{
		currentPlayerID = plrID;
		kingdomPnl.setCurrentPlayerID(currentPlayerID);
	}
	
	public void setNextButtons() throws IOException {
		setTileImage(tile5,Dominos2[0]);
        setTileImage(tile6,Dominos2[1]);
        setTileImage(tile7,Dominos2[2]);
        setTileImage(tile8,Dominos2[3]);
        newplayerOrder.add(tile1SelectedBy);
        newplayerOrder.add(tile2SelectedBy);
        newplayerOrder.add(tile3SelectedBy);
        newplayerOrder.add(tile4SelectedBy);
        GameRound.setPlayerOrder(newplayerOrder);
        currentPlayerID = newplayerOrder.get(0);
        infoLabel.setText("Select new Tiles: Player "+currentPlayerID+"'s Turn..");
        kingdomPnl.setCurrentPlayerID(currentPlayerID);
	}
	
	public static void nextPlr() throws IOException {
		int nextPlr = GameRound.nextPlayer();
        currentPlayerID = nextPlr;
        infoLabel.setText("Select new Tiles: Player "+nextPlr+"'s Turn..");
		kingdomPnl.setCurrentPlayerID(nextPlr);
		selectionStarted = true;
		meeplePlaced = false;
		kingdomPnl.setMeeplePlaced(false);
		if(nextPlr==0) {
			infoLabel.setText("Round "+round_num+" Done..");
		}
	}
	
	protected void Tile1BtnActionPerformed(ActionEvent evt)throws IOException {
		GamePanel.playClickSound();
		if(tile1Selected == false) {
			mplLabel1 = new JLabel();
			
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel1.setIcon(new ImageIcon(img));
	            mplLabel1.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			tile1SelectedBy = currentPlayerID;
	        int nextPlr = GameRound.nextPlayer();
	        currentPlayerID = nextPlr; 
			infoLabel.setText("Player "+nextPlr+"'s Turn..");
			kingdomPnl.setCurrentPlayerID(nextPlr);
			if(nextPlr==0) {
				setNextButtons();
			}
			tile1.add(mplLabel1);
			tile1Selected = true;
			turnsCompleted++;
		}
	}
	protected void Tile2BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile2Selected == false) {
			mplLabel2 = new JLabel();
			
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel2.setIcon(new ImageIcon(img));
	            mplLabel2.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			tile2SelectedBy = currentPlayerID;
	        int nextPlr = GameRound.nextPlayer();
	        currentPlayerID = nextPlr;
			infoLabel.setText("Player "+nextPlr+"'s Turn..");
			kingdomPnl.setCurrentPlayerID(nextPlr);
			if(nextPlr==0) {
				setNextButtons();
			}
			tile2.add(mplLabel2);
			tile2Selected = true;
			turnsCompleted++;
		}
	}
	protected void Tile3BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile3Selected == false) {
			mplLabel3 = new JLabel();
			
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel3.setIcon(new ImageIcon(img));
	            mplLabel3.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			tile3SelectedBy = currentPlayerID;
	        int nextPlr = GameRound.nextPlayer();
	        currentPlayerID = nextPlr;
			infoLabel.setText("Player "+nextPlr+"'s Turn..");
			kingdomPnl.setCurrentPlayerID(nextPlr);
			if(nextPlr==0) {
				setNextButtons();
			}
			tile3.add(mplLabel3);
			tile3Selected = true;
			turnsCompleted++;
		}
	}
	protected void Tile4BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile4Selected == false) {
			mplLabel4 = new JLabel();
			
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel4.setIcon(new ImageIcon(img));
	            mplLabel4.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			tile4SelectedBy = currentPlayerID;
	        int nextPlr = GameRound.nextPlayer();
	        currentPlayerID = nextPlr;
			infoLabel.setText("Player "+nextPlr+"'s Turn..");
			kingdomPnl.setCurrentPlayerID(nextPlr);
			if(nextPlr==0) {
				setNextButtons();
			}
			tile4.add(mplLabel4);
			tile4Selected = true;
			turnsCompleted++;
		}
	}
	protected void Tile5BtnActionPerformed(ActionEvent evt)throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile5Selected == false && turnsCompleted >=num_of_players && !meeplePlaced) {
			mplLabel5 = new JLabel();
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel5.setIcon(new ImageIcon(img));
	            mplLabel5.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			if(tile1SelectedBy == currentPlayerID) {
				mplLabel1.setVisible(false);
			}
			else if(tile2SelectedBy == currentPlayerID) {
				mplLabel2.setVisible(false);
			}
			else if(tile3SelectedBy == currentPlayerID) {
				mplLabel3.setVisible(false);
			}
			else if(tile4SelectedBy == currentPlayerID) {
				mplLabel4.setVisible(false);
			}
			tile5SelectedBy = currentPlayerID;
			meeplePlaced = true;
			addTileToKingdom(currentPlayerID);
			tile5.add(mplLabel5);
			tile5Selected = true;
			turnsCompleted++;
			
		}
	}
	protected void Tile6BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile6Selected == false && turnsCompleted >=num_of_players && !meeplePlaced) {
			mplLabel6 = new JLabel();
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel6.setIcon(new ImageIcon(img));
	            mplLabel6.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			if(tile1SelectedBy == currentPlayerID) {
				mplLabel1.setVisible(false);
			}
			else if(tile2SelectedBy == currentPlayerID) {
				mplLabel2.setVisible(false);
			}
			else if(tile3SelectedBy == currentPlayerID) {
				mplLabel3.setVisible(false);
			}
			else if(tile4SelectedBy == currentPlayerID) {
				mplLabel4.setVisible(false);
			}
			tile6SelectedBy = currentPlayerID;
			meeplePlaced = true;
			addTileToKingdom(currentPlayerID);
			tile6.add(mplLabel6);
			tile6Selected = true;
			turnsCompleted++;
			
		}
	}
	protected void Tile7BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile7Selected == false && turnsCompleted >=num_of_players && !meeplePlaced) {
			mplLabel7 = new JLabel();
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel7.setIcon(new ImageIcon(img));
	            mplLabel7.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			if(tile1SelectedBy == currentPlayerID) {
				mplLabel1.setVisible(false);
			}
			else if(tile2SelectedBy == currentPlayerID) {
				mplLabel2.setVisible(false);
			}
			else if(tile3SelectedBy == currentPlayerID) {
				mplLabel3.setVisible(false);
			}
			else if(tile4SelectedBy == currentPlayerID) {
				mplLabel4.setVisible(false);
			}
			tile7SelectedBy = currentPlayerID;
			meeplePlaced = true;
			addTileToKingdom(currentPlayerID);
			tile7.add(mplLabel7);
			tile7Selected = true;
			turnsCompleted++;
			
		}
	}
	protected void Tile8BtnActionPerformed(ActionEvent evt)throws IOException {
		// TODO Auto-generated method stub
		GamePanel.playClickSound();
		if(tile8Selected == false && turnsCompleted >=num_of_players && !meeplePlaced) {
			mplLabel8 = new JLabel();
			try {
	            Image img = players[currentPlayerID-1].getPlrMeeple();
	            mplLabel8.setIcon(new ImageIcon(img));
	            mplLabel8.setBorder(null);
	          } catch (Exception ex) {
	            System.out.println(ex);
	          }
			if(tile1SelectedBy == currentPlayerID) {
				mplLabel1.setVisible(false);
			}
			else if(tile2SelectedBy == currentPlayerID) {
				mplLabel2.setVisible(false);
			}
			else if(tile3SelectedBy == currentPlayerID) {
				mplLabel3.setVisible(false);
			}
			else if(tile4SelectedBy == currentPlayerID) {
				mplLabel4.setVisible(false);
			}
			tile8SelectedBy = currentPlayerID;
			meeplePlaced = true;
			addTileToKingdom(currentPlayerID);
			tile8.add(mplLabel8);
			tile8Selected = true;
			turnsCompleted++;
			
		}
	}
	public static void setSelectionStarted(boolean selectionS) {
		selectionStarted = selectionS;
	}
	
	public static void setMeeplePlaced(boolean newMeepleP) {
		meeplePlaced = newMeepleP;
	}
	public void addTileToKingdom(int plrID) throws IOException {
		infoLabel.setText("Player "+plrID+" : Add Domino to Kingdom..");
		if(tile1SelectedBy == plrID) {
			String t1 = Dominos1[0].getTerrain1();
			String t2 = Dominos1[0].getTerrain2();
			PlayerKingdom.setSelectionStarted(true);
			PlayerKingdom.setTileToAdd(t1,t2);
			selectionStarted = true;
		}
		if(tile2SelectedBy == plrID) {
			String t1 = Dominos1[1].getTerrain1();
			String t2 = Dominos1[1].getTerrain2();
			PlayerKingdom.setSelectionStarted(true);
			PlayerKingdom.setTileToAdd(t1,t2);
			selectionStarted = true;
		}
		if(tile3SelectedBy == plrID) {
			String t1 = Dominos1[2].getTerrain1();
			String t2 = Dominos1[2].getTerrain2();
			PlayerKingdom.setSelectionStarted(true);
			PlayerKingdom.setTileToAdd(t1,t2);
			selectionStarted = true;
		}
		if(tile4SelectedBy == plrID) {
			String t1 = Dominos1[3].getTerrain1();
			String t2 = Dominos1[3].getTerrain2();
			PlayerKingdom.setSelectionStarted(true);
			PlayerKingdom.setTileToAdd(t1,t2);
			selectionStarted = true;
		}
		
	}
	
     public void doneButtonActionPerformed(java.awt.event.ActionEvent evt)throws IOException {
	    	GamePanel.playClickSound();
	    	if(meeplePlaced && !selectionStarted) {
	    		nextPlr();
	    	}
	    }
}
