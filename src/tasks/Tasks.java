package tasks;

public class Tasks {

	private int num;
	private boolean[][] dependecies;

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

		int[] arr = new int[num];
		boolean[] flags = new boolean[num];
		int index = 0;
		int i;
		boolean flag;
		// add the independent tasks
		for (int k = 0; k < num; k++) {
			for (i = 0; i < num; i++) {
				flag = false;
				for (int j = 0; j < num; j++)
					if (dependecies[i][j] == true)
						flag = true;
				if (!flag && flags[i] != true) { // if we have something to print
					arr[index++] = i;
					flags[i] = true;
					for (int j = 0; j < num; j++)
						dependecies[j][i] = false;
					break;
				}
			} 
			if(num == i)
				return null;
		}
		return arr;
	}
}
