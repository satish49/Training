package training.java.satish.collection;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int n =0;
		System.out.println("enter which fibonacci value u want");
		Scanner sc = new Scanner(System.in);
		try {
			n=sc.nextInt();
			
			FibonacciSeries fb=new FibonacciSeries();
			
			//fibonacci by iteration
			fb.fibonacciIteration(n);
			
			//fibonacci by recursive
			long fibValue=fb.fibonacciRecursive(n);
			
			System.out.println("fibonacci value of "+n +" usinng recursive is "+fibValue);
		} catch (Exception e) {
			System.out.println("you enter non-number .. please re launch and enter only number");
		}
	
	}
	
	
	 public  void fibonacciIteration(int n)
	 {
		 //by iteration
		long x=0,y=1,z=1;
		
		for(int i=2;i<n;i++)
		{
			x=y;
			y=z;
			z=x+y;
		}
		
		System.out.println("fibonacci of "+n +" using iteration "+ "is ="+z);
	 }
	 
	 public  int fibonacciRecursive(int value)
	 {
		 //by recursive
		 if((value==1) || (value==0))
			 return value;

		 return fibonacciRecursive(value-1) + fibonacciRecursive(value-2);
	 }
}
