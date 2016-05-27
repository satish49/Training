package training.java.satish.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindLargestAndSmallestValues {

	public static void main(String[] args) {
		System.out.println("Programes for find Large and Small number from data");
		System.out.println("----------------------------------------------------\n");
		int[] values = { 163, 243, 12, 12, 54, 3, 96, 25, 56 };
		

		//find by array
		FindUsingArray ll = new FindUsingArray();
		ll.findUsingArray(values);
	
		//find by List
		@SuppressWarnings("rawtypes")
		List<Integer> listValues=new ArrayList<Integer>();
		for(int i : values)
			listValues.add(i);
		
		FindUsingList nn=new FindUsingList();
		nn.findUsingList(listValues);
		
		
		//find using TreeSet
		TreeSet<Integer> setValues=new TreeSet<Integer>(listValues); //Sorted and duplicates will eliminate
		System.out.println("\nBy using TreeSet");
		System.out.println("---------------");
		System.out.print("large  =  "+setValues.last());
		System.out.println("    small =  "+setValues.first());
		
		
	}

}
/*
 * This is for find smallest and largest number in array
 * 
 */
class FindUsingArray {

	public void findUsingArray(int[] values) {
		System.out.println("By using Arrays");
		System.out.println("---------------");

		int small = values[0];
		int large = values[1];

		for (int i : values) {
			if (small > i)
				small = i;

			if (large < i)
				large = i;
		}

		System.out.println("\n"+"large  =" + large + "   small=" + small +"\n");
	}
}


class FindUsingList {

	public void findUsingList(List values) {
		System.out.println("By using List...");
		System.out.println("----------------");

		int large=(int) Collections.max(values);
		int small=(int) Collections.min(values);
		 	

		System.out.println("large  =" + large + "   small=" + small+"\n");
	}
}
