package tree;

public class Node {
	 private static final int NUMBER_OF_LETTERS = 26;
	 private Node[] children = new Node[NUMBER_OF_LETTERS];
	 private int count;
	 
	 public int num(String s) {
		 if(s.isEmpty()) // if it's the end of the string or empty
			 return count;
		 Node tmp = children[s.charAt(0) - 'a' ]; //the child
		 return tmp == null ? 0 : tmp.num(s.substring(1)); // coninue down the chain into the end
	 }
	 
	 public void add(String s) {
		 if(s.isEmpty()) { // if it's the end of the string or empty
			 count ++;
			 return;
		 }
		 if(children[s.charAt(0) - 'a' ] == null)
			 children[s.charAt(0) - 'a'] = new Node();
		 children[s.charAt(0) - 'a'].add(s.substring(1));
	 	}
	 
	 
	 
}
