package game;

public class FourInARow extends Game {

	// constructor
	public FourInARow(String player1, String player2) {
		super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	// overrides doesWin so we would actually play tic-tac-toe
	@Override
	protected boolean doesWin(int i, int j) {
		return maxLineContaining(i, j) == 4 ? true : false;
	}

	// checks the line if we have a spot to place P and returns it
	private int checkline(int line) {
		for (int i = 0; i < n; i++)
			if (isEmpty(i, line))
				return i;
		return -1;

	}

	// calls in order to play a single turn for player p
	@Override
	protected boolean onePlay(Player p) {
		int move, row;
		do {
			System.out.println("please enter column:");
			move = s.nextInt();
			row = checkline(move);
		} while (row == -1);

		board[row][move] = p;
		return doesWin(row, move);
	}

}
