package game;

import java.util.Scanner;

public abstract class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);
	
	public Game(int n,int m,Player p1,Player p2) {
		super(n,m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
	}
	
	protected abstract boolean doesWin(int i, int j) ;
	
	protected boolean onePlay(Player p) {
		while (true) {
			System.out.print(p.toString() + ", please enter x and y:");
			int i = s.nextInt();
			int j = s.nextInt();
			if (isEmpty(i, j)) {
				board[i][j] = p;
				return doesWin(i, j);
			}
			System.out.println("There is a piece there already...");
		}
	}
	
	public Player play() ;
	
}
