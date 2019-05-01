package game;

public class TicTacToe extends Game {
	
	
	public TicTacToe(String player1, String player2) {
		super(3,3,new Player(player1,'X'),new Player(player2,'O'));
		
	}

	@Override
	protected boolean doesWin(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean onePlay(Player P) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player play() {
		// TODO Auto-generated method stub
		return null;
	}

}
