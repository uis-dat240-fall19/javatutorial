package javatutorial;

import java.util.HashMap;
import java.util.HashSet;

public class DataStructures {

	public static void main(String[] args) {
		HashMap<String, Integer> myMap = new HashMap<String, Integer>();
		HashMap<MyFirstApp, Integer> myMap1 = new HashMap<MyFirstApp, Integer>();
		myMap.put("Hello", 1);
		myMap.put("World", 2);
		myMap.put("Norway", 47);
		myMap.put("Denmark", 45);
		String str = "Norway";
		int hashCode = str.hashCode();
		if (myMap.containsKey("Hello")) {
			int val = myMap.get("Hello");
			System.out.println(val);
		}
		for(String key : myMap.keySet()) {
			int val = myMap.get(key);
			System.out.println(key + ", " + val);
		}
		
		HashSet<String> mySet = new HashSet<String>();
		mySet.add("hello");
		mySet.add("Hello");
	}

}
