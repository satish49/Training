package training.java.satish.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharingDataThreads {

	public static void main(String[] args) {
		DataClass dc=new DataClass();
		dc.setValues();

		System.out.println("list of array is      "+DataClass.list);
		ThreadOneClass tOne=new ThreadOneClass();
		Thread t1=new Thread(tOne);
		
		ThreadTwoClass tTwo=new ThreadTwoClass();
		Thread t2=new Thread(tTwo);
		
		t1.start();
		
		t2.start();
		
	}
}

class DataClass {
	static final List<Integer> list = new ArrayList<Integer>();

	public void setValues() {
		Random rn = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(rn.nextInt(10));
		}
	}
}

class ThreadOneClass implements Runnable {
	public void run() {
		//here read even index values
		List<Integer> list=DataClass.list;
		List<Integer> evenList=new ArrayList<Integer>();
		int count=0;
		for(int value: list)
		{
			if(count%2==0){
				//System.out.println(Thread.currentThread().getName()+"  value "+value);
				evenList.add(value);
			}
			count++;
		}
		
		System.out.println("even index values are "+evenList);
	}
}

class ThreadTwoClass implements Runnable {
	public void run() {
		//here read odd index values
		List<Integer> list=DataClass.list;
		List<Integer> oddList=new ArrayList<Integer>();
		int count=0;
		for(int value: list)
		{
			if(count%2==1){
				//System.out.println(Thread.currentThread().getName()+"  value "+value);
				oddList.add(value);
			}
			count++;
		}
		System.out.println("odd  index values are "+oddList);
	}
}