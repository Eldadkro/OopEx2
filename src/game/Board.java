package game;


public class Board {
	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	protected boolean set(int i, int j, Player p) {
		if(isEmpty(i, j)) {
			board[i][j] = p;
			return true;
		}
		return false;
	}

	public boolean isEmpty(int i, int j) {
		return board[i][j] == null ? true : false;
	}

	public Player get(int i, int j) {
		return board[i][j] == null ? null : board[i][j];
	}
	
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

	private int max(int[] arr) {
		int maximum = 1;
		for(int val : arr)
			maximum = val>maximum ? val:maximum;
		return maximum;
	}
	
	private int countVector(int i,int j,int deltaI,int deltaJ) {
		Player p = board[i][j];
		int sum=0;
		for(int indexI=i;indexI<n && indexI>=0;indexI+=deltaI)
			for(int indexJ=j;indexJ<m && indexJ>=0;indexJ+=deltaJ) {
				if(board[indexI][indexJ] != p)
					return sum;
				sum++;
			}
		return sum;
	}
	
	private int lineContaining(int i,int j,int deltaI,int deltaJ) {
		return countVector(i, j, deltaI, deltaJ) + 
				countVector(i, j, -deltaI, -deltaJ)-1;
	}
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
