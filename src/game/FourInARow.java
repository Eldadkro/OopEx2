package game;

public class FourInARow extends Game {

	public FourInARow(String player1, String player2) {
		super(6,7,new Player(player1,'W'),new Player(player2,'B'));
	}
	
	protected boolean doesWin(int i, int j) {
		return maxLineContaining(i, j) == 4 ? true:false;
	}
	
	private int checkline(int line) {
		for(int i = 0; i<n;i++)
			if(isEmpty(i, line))
				return i;
		return -1;
				
	}
	
	protected boolean onePlay(Player p) {
		int move,row;
		do {
			System.out.println("please enter column:");
			move = s.nextInt();
			row = checkline(move);
		} while(row == -1);

		board[row][move] = p;
		return doesWin(row, move);
	}
	
}
