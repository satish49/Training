package training.java.satish.collection;

public class Employee {

	private String eName;
	private int eAge;
	private int eSalary;
	
	public Employee(String name,int age,int salary)
	{
		this.eName=name;
		this.eAge=age;
		this.eSalary=salary;
	}
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int geteAge() {
		return eAge;
	}
	public void seteAge(int eAge) {
		this.eAge = eAge;
	}
	public int geteSalary() {
		return eSalary;
	}
	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}
	
	
	/* override hashCode and equals*/
	public boolean equals(Object ob)
	{
		boolean status=false;
		
		if(ob == null && (ob.getClass() != this.getClass()))
		{
			status=false;
		}
		else 
		{
			Employee emp=(Employee)ob;
			if(this.eAge==emp.eAge && this.eName==emp.eName && this.eSalary==emp.eSalary)
				status=true;
		}
		
		return status;
		//return (this.eName==((Employee)ob).eName);
	}
	
	
	public int hashCode()
	{
		
		int hash=49;
		
		hash+=5*this.eName.hashCode();
		
		return hash;
		
		
	}
	
}
