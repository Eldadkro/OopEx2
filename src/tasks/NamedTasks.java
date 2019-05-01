package tasks;

public class NamedTasks extends Tasks {

	private String[] names;
	
	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}
	
	private int IsInside(String task) {
		for(int i=0;i<names.length;i++)
			if(names[i] == task)
				return i;
		return -1;
	}
	
	public boolean dependsOn(String task1,String task2){
		int a=IsInside(task1),b = IsInside(task2);
		return super.dependsOn(a, b);
	}
	
	public String[] nameOrder() {
		int[] arr = super.order();
		if(arr == null)
			return null;
		String[] strArr = new String[names.length];
		for(int i=0;i<names.length;i++)
			strArr[i] = names[arr[i]];
		return strArr;
	}

	
}
