package game;


public class Board {
	protected Player[][] board;
	protected int n, m;
	
	//constructor 
	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	// puts a player in the spot i,j if it's empty 
	protected boolean set(int i, int j, Player p) {
		if(isEmpty(i, j)) {
			board[i][j] = p;
			return true;
		}
		return false;
	}

	// returns true if the spot is empty false if it isn't 
	public boolean isEmpty(int i, int j) {
		return board[i][j] == null ? true : false;
	}

	//returns what is in spot i,j
	public Player get(int i, int j) {
		return board[i][j] == null ? null : board[i][j];
	}
	
	//returns true if the board is full false if their is an open spot
	public boolean isFull() {
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(board[i][j] == null)
					return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				str.append(board[i][j] == null? ".":
					board[i][j].getMark());
			str.append("\n");
		}	
		return str.toString();
	}

	// returns the max in 1d array
	private int max(int[] arr) {
		int maximum = 1;
		for(int val : arr)
			maximum = val>maximum ? val:maximum;
		return maximum;
	}
	
	// returns how many times the object in spot i,j is repeated
	// is succession on vector (deltaI,deltaJ)
	private int countVector(int i,int j,int deltaI,int deltaJ) {
		Player p = board[i][j];
		int sum = 0;
		while (i < n && i >= 0 && j < m && j >= 0) {
			if (board[i][j] != p)
				return sum;
			sum++;
			i += deltaI;
			j += deltaJ;
		}
		return sum;

	}
	
	// returns how many times the object in spot i,j is repeated
	// is succession on line (deltaI,deltaJ)
	private int lineContaining(int i,int j,int deltaI,int deltaJ) {
		return countVector(i, j, deltaI, deltaJ) + 
				countVector(i, j, -deltaI, -deltaJ)-1;
	}
	
	//return the maximum amount p is repeated on any of the lines
	protected int maxLineContaining(int i ,int j) {
		int []results = new int[4];
		int index = 0;
		//for horizontal line;
		results[index++] = lineContaining(i, j, 1, 0);
		//for vertical line
		results[index++] = lineContaining(i, j, 0, 1);
		//for main diagonal
		results[index++] = lineContaining(i, j, 1, 1);
		//for secondary diagonal
		results[index++] = lineContaining(i, j, 1,-1);
		return max(results);
		 
	}
	
}
