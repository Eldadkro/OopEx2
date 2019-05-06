package tree;

import java.util.Scanner;

public class ReversedWords {
	
	private static int isInside(Node head , String s) {
		return head.num(s) == 0 ? 0 :1;
	}
	
	private static String reversed(String s) {
		String ReS = "";
		while(s != null && !s.isEmpty() ) {
			ReS = ReS + s.charAt(s.length()-1);
			s = s.substring(0, s.length()-1);
		}
		return ReS;
	}
	public static int checkReversed() {
		Node head = new Node();
		int counter = 0;
		Scanner s = new Scanner(System.in);
		while(s.hasNext() != false ) {
			String token = s.next();
			if(token.equals("X"))
				break;
			counter += isInside(head, reversed(token));
			head.add(token);
		}
		s.close();
		return counter;
	}
	

}
