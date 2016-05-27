package training.java.satish.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FindDuplicatesInArray {

	private static int[] data = new int[100];

	public static void main(String[] args) {

		// store random numbers to array
		for (int i = 0; i < 100; i++) {
			data[i] = getRandomNumberInRange(1, 100);
		}

		//print numbers
		for (int i = 0; i < 100; i++) {
			System.out.println(data[i]);
		}
		System.out.println("______________________________________________________________");
		// find duplicates
		System.out.println("no.of duplicates in array is " + findDuplicates(data));
	}

	//find random number
	private static int getRandomNumberInRange(int min, int max) {

		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	//this is for finding total no.of duplicates in array
	private static int findDuplicates(int[] values) {
		Set<Integer> valus = new HashSet<Integer>();
		int count = 0;
		for (int i : values) {
			if (valus.contains(i)) {
				System.out.println("duplicate values... " + i);
				count++;
			} else {
				// add to set
				valus.add(i);
			}
		}
		return count;
	}

}
