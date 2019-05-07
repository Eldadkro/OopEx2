package tasks;

public class Tasks {

	private int num;
	private boolean[][] dependecies; // 2d array of boolean for dependencies 

	// scanner
	public Tasks(int num) { 
		this.num = num;
		dependecies = new boolean[num][num];
	}

	public boolean dependsOn(int task1, int task2) {

		// adds dependency on for two tasks
		// return true if success , false if it was bad

		// ====================bad values==============
		if (task1 == task2 || task1 < 0 || task2 < 0 || task1 >= num || task2 >= num)
			return false;

		// ===================good values==============
		dependecies[task1][task2] = true;
		return true;

	}
	//need work
	public int[] order() {
		/**
		 * complexity O(N^3) insights: 1) if we in iteration i we have nothing to add to
		 * arr it means we have a loop 2) finding an order is actually a transmutation
		 * of N numbers meaning that an order is array of exactly N numbers 3) if we
		 * iterate over our dependencies and we have nothing to print then we have a
		 * loop
		 */

		int[] arr = new int[num]; // the order of numbers
		boolean[] flags = new boolean[num]; // array that holds if we 
											//already added numbers to the order
		int index = 0; // the index we use to monitor the last entry of the order
		boolean flag; //used to represent if we found something to add to the order
		// add the independent tasks
		int i;
		for (int k = 0; k < num; k++) {
			for (i = 0; i < num; i++) {
				flag = false;
				for (int j = 0; j < num; j++)
					if (dependecies[i][j] == true)
						flag = true;
				if (!flag && flags[i] != true) { // if we have something to print
					arr[index++] = i; // add to the order
					flags[i] = true;
					for (int j = 0; j < num; j++) // remove the dependencies for i task
						dependecies[j][i] = false;
					break;
				}
			} 
			if(num == i) // if we have a loop and can't print 
				return null;
		}
		return arr;
	}
}
