package training.java.satish.collection;

import java.util.Arrays;

/*
 * This class is used for sorting elements as Quick Sort method
 */
public class QuickSort {

	public static void main(String[] args) {
		
		System.out.println("Quick Sort implementation");
		System.out.println("--------------------------");
		
		//sample list for sorting
		int[] unSortedValues = { 8, 2, 5, 1, 6, 9, 3 };

		
		//call sorting algorithm
		new QuickSortAlgoritham().sort(unSortedValues);
	}
}

class QuickSortAlgoritham {
	public int[] input;
	public int length;

	public void sort(int[] values) {
		if (values != null && values.length > 0) {
			this.input = values;
			this.length = values.length;

			System.out.println("before sorting "+Arrays.toString(input));
			quickSort(0, length - 1);
			
			System.out.println("after sorting "+Arrays.toString(input));
		}
	}

	public void quickSort(int start, int end) {
	
		/*
		 * find middle index values.. we called as pivot point
		 * based on pivot point, we align least values in left and hight values on right side
		 */
		int pivot = input[(start + end) / 2]; // get pivot point value

		//these are for recursive start and end elements... in loop we have to maintain old values
		int dummyStart=start; 
		int dummyEnd=end;
		
		
		while (dummyStart <= dummyEnd) {
			//check until find bigger number 
			while (input[dummyStart] < pivot)
				dummyStart++;

			//check until smaller number
			while (input[dummyEnd] > pivot)
				dummyEnd--;

			//now swap numbers and change possition to check list
			if (dummyStart <= dummyEnd) {
				swapNumbers(dummyStart, dummyEnd);
				
				//now next element
				dummyStart++;
				dummyEnd--;
			}
		}
		
		/*
		 * until here, we have left elements and right elements based on pivot point
		 * 
		 * Next in case we need to again sort, check and call quickSort recursive 
		 */
		
		
		//for left elements
		if(start < dummyEnd)
			quickSort(start,dummyEnd);
		
		//for right elements
		if(dummyStart < end)
			quickSort(dummyStart,end);
		
		
		// all swapings apply on original list, so finnaly we get sorted on original list only
	}

	public void swapNumbers(int pos1, int pos2) {
		//swap numbers here with help of dummy variable
		int temp = input[pos1];
		input[pos1] = input[pos2];
		input[pos2] = temp;
	}
}
