package tree;

import java.util.Scanner;

public class ReversedWords {
	
	//private function that checks if s is inside the tree
	private static int isInside(Node head , String s) { 
		return head.num(s) == 0 ? 0 :1;
	}
	
	// private function that returns the reversed string 
	private static String reversed(String s) {
		String ReS = "";
		while(s != null && !s.isEmpty() ) {
			ReS = ReS + s.charAt(s.length()-1);
			s = s.substring(0, s.length()-1);
		}
		return ReS;
	}
	
	//returns the amount of words that have been repeated in the string 
	//but in reverse
	public static int checkReversed() {
		Node head = new Node(); // starts a new tree to handle the words 
		int counter = 0; // counter that we are gonna return 
		Scanner s = new Scanner(System.in); //input handler
		while(s.hasNext() != false ) { // continue untill the input buffer is empty 
			String token = s.next(); // gets the next word 
			if(token.equals("X")) // break if we got "X"
				break;
			counter += isInside(head, reversed(token)); // checks if inside and adds it to counter
			head.add(token); // adds the token to the tree
		}
		s.close(); // close the scanner
		return counter;
	}
	

}
