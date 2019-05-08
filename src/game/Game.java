package game;

import java.util.Scanner;

public class Game extends Board {
	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	// constructor
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;
	}

	// returns true if we won and false if we didn't
	protected boolean doesWin(int i, int j) {
		return i == 0 && j == 0 ? true : false;
	}

	// play a single move for player p
	protected boolean onePlay(Player p) {
		while (true) {
			System.out.print(p.toString() + ", please enter x and y:");
			int i = s.nextInt();
			int j = s.nextInt();
			if (set(i, j, p))
				return doesWin(i, j);
			System.out.println("There is a piece there already...");
		}
	}

	// start playing the game until one player wins or the board is full
	public Player play() {
		while (!isFull()) {
			if (onePlay(players[0]))
				return players[0];
			if (onePlay(players[1]))
				return players[1];
		}
		return null;
	}

}
