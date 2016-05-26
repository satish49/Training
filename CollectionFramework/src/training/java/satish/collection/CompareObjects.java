package training.java.satish.collection;

public class CompareObjects {

	public static void main(String[] args) {
		
		Employee emp=new Employee("satish",20,34);
		/*
		 	System.out.println("empl hash code  "+emp);
			System.out.println("empl hash code  "+emp.hashCode());
			System.out.println("empl hash code  "+emp.toString());
		*/
		Employee emp1=new Employee("satish",20,34);
		/*
		  	System.out.println("empl hash code  "+emp1);
			System.out.println("empl hash code  "+emp1.hashCode());
			System.out.println("empl hash code  "+emp1.toString());
		 */
		
		
		//compare two objects
		if(emp.equals(emp1))
			System.out.println("true");
		else
			System.out.println("false");
	}
}
