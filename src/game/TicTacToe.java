package game;

public class TicTacToe extends Game {
	
	//constructor 
	public TicTacToe(String player1, String player2) {
		super(3,3,new Player(player1,'X'),new Player(player2,'O'));
	}

	//overrides doesWin so we would actually play tic-tac-toe
	@Override
	protected boolean doesWin(int i,int j) {
		return maxLineContaining(i, j) == 3 ? true:false;
	}
	
}
