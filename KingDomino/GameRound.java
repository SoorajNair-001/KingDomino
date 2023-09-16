/*does a game round
* draws 4 random tiles from the pile*/
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameRound {
	private int roundNumber;
	private int[] alreadyDrawn;
	private DominoTile[] newDominos;
	private DominoTile[] newDominos1;
	private DominoTile[] newDominos2;
	private static int[] playerOrder;
    private Integer num_of_players;
    private Integer num_of_comp;
	private static DominoTile[] DominoPack;
	private int nextIndex = 0 ;
	private static int currentPlayerIndex;
	private static boolean gameLabels;
	
	public GameRound(int roundNumber,boolean gameLabels,DominoTile[] newDominos,Integer num_of_players,Integer num_of_comp) throws IOException {
		this.roundNumber = roundNumber;
		this.newDominos = newDominos;
		this.num_of_players = num_of_players;
    	this.num_of_comp = num_of_comp;
    	this.gameLabels = gameLabels;
		DominoPack = new DominoTile[48];
		alreadyDrawn = new int[48];
		createDominoPack();
		createRound();
	}
	
	public void createRound() throws IOException {	
		if(getRoundNumber() == 1) {
			playerOrder = selectRandomPlayerOrder();
			setNewDominos1(draw4NewDominos());
			setNewDominos2(draw4NewDominos());
		}
		else 
		{
			newDominos1 = newDominos;
			setNewDominos2(draw4NewDominos());
		}
		GameBoard.infoLabel.setText("Player "+playerOrder[0]+"'s Turn..");
		GameBoard.setCurrentPlayerID(playerOrder[0]);
		currentPlayerIndex = 0;
	}
	
	public static int nextPlayer() {
		if(currentPlayerIndex <playerOrder.length-1) {
			currentPlayerIndex++;
			return playerOrder[currentPlayerIndex];}
		return 0;
	}
	public DominoTile drawRandomDomino() {
		Random rand = new Random();
		int randInt = rand.nextInt(48);
		DominoTile domino = DominoPack[randInt];
		return domino;
	}
	
	private DominoTile[] draw4NewDominos() {
		DominoTile[] new_dominos = new DominoTile[4];
		for(int i=0;i<4;i++) {
			Boolean drawn = false;
			int domino_num = 0;
			while(drawn == false) {
				DominoTile domino = drawRandomDomino();
				for(int k=0;k<48;k++) {
					if(alreadyDrawn[k] == domino.getTileNumber()) {
						drawn=false;
						break;
					}
					else {drawn = true;}
				}
				new_dominos[i]= domino;
				domino_num = domino.getTileNumber();
			}
			alreadyDrawn[nextIndex] = domino_num;
			nextIndex++;
			
		}
		
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<4;j++) {
			if(new_dominos[i].getTileNumber() > new_dominos[j].getTileNumber()) {
				DominoTile temp = new_dominos[i];
				new_dominos[i] = new_dominos[j];
				new_dominos[j] = temp;
			}
		}}
		
		return new_dominos;
	}
	
	private int[] selectRandomPlayerOrder() {
		if(num_of_players == 2) {
			int[] plrOrder = {1,2};
			Random rnd = ThreadLocalRandom.current();
			for (int i = plrOrder.length - 1; i > 0; i--){
		      int index = rnd.nextInt(i + 1);		
			  int a = plrOrder[index];
			  plrOrder[index] = plrOrder[i];
		      plrOrder[i] = a;
		    }
			return plrOrder;}
		else if(num_of_players == 3) {
			int[] plrOrder = {1,2,3};
			Random rnd = ThreadLocalRandom.current();
			for (int i = plrOrder.length - 1; i > 0; i--){
		      int index = rnd.nextInt(i + 1);		
			  int a = plrOrder[index];
			  plrOrder[index] = plrOrder[i];
		      plrOrder[i] = a;
		    }
			return plrOrder;}
		else if(num_of_players == 4) {
			int[] plrOrder = {1,2,3,4};
			Random rnd = ThreadLocalRandom.current();
			for (int i = plrOrder.length - 1; i > 0; i--){
		      int index = rnd.nextInt(i + 1);		
			  int a = plrOrder[index];
			  plrOrder[index] = plrOrder[i];
		      plrOrder[i] = a;
		    }
			return plrOrder;}
		return null;	
	}

	
	public static DominoTile[] getDominoPack(){
		return DominoPack;
	}
	
	public static void createDominoPack(){
		for(int i=1;i<=48;i++) {
			DominoTile domino = new DominoTile(i,gameLabels);
			DominoPack[i-1] = domino;
		}
	}
	
	public static void setPlayerOrder(ArrayList<Integer> newplayerOrder) {
		for(int i=0;i<4;i++) {
			playerOrder[i] = newplayerOrder.get(i);
		}
		currentPlayerIndex=0;
	}
	
	public int getRoundNumber() {
		return roundNumber;
	}

	public DominoTile[] getNewDominos1() {
		return newDominos1;
	}

	public void setNewDominos1(DominoTile[] newDominos1) {
		this.newDominos1 = newDominos1;
	}

	public DominoTile[] getNewDominos2() {
		return newDominos2;
	}

	public void setNewDominos2(DominoTile[] newDominos2) {
		this.newDominos2 = newDominos2;
	}
}
