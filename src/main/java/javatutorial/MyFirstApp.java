package javatutorial;

import java.util.ArrayList;

public class MyFirstApp  implements Cloneable {
	int id;
	int myVariable;
	String s;

	public int hashCode() {
		return id;
	}
	static void increment(int x) {
		x = x + 1;
	}

	static void increment(MyFirstApp y) {
		y.myVariable++;
	}
	
	public static void main(String[] args) {
		System.out.println("I Rule!");

		int x = 100;
		while (x > 12) {
			x = x - 2;
		}

		System.out.println("Value of x is " + x);

		int y = 100;
		for (; y > 12;) {
			y = y - 2;
			String str = "abl";
		}

		System.out.println("Value of y is " + y);

		int a = 10;

		MyFirstApp.increment(a);

		System.out.println(a);
		
		MyFirstApp app = new MyFirstApp();
		
		
		app.myVariable = 10;
//		increment(app);
		System.out.println(app.myVariable);
		
		
		MyFirstApp appClone = null;
		try {
			appClone = (MyFirstApp) app.clone();
			// TODO Auto-generated catch block
		}
			catch(Exception e) {
			e.printStackTrace();
		}
		increment(appClone);

		System.out.println(app.myVariable);
		System.out.println(appClone.myVariable);
		
//		int[] nums;
//		nums = new int[7];
//		int length = nums.length;
//		System.out.println(length);
//
//		ArrayList<String> strList = new ArrayList<String>();
//		strList.add("Hello");
//		strList.add("World");
//		for (String s : strList) {
//			System.out.println(s);
//		}
	}

}
