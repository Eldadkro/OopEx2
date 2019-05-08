package game;

public class Player {

	private String name;
	private char mark;

	// constructor
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark;
	}

	// getter
	public String getName() {
		return name;
	}

	// getter
	public char getMark() {
		return mark;
	}

	@Override
	public String toString() {
		return name + "(" + mark + ")";
	}
}