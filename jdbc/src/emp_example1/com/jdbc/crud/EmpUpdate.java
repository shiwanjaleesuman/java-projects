/**
 * 
 */
package emp_example1.com.jdbc.crud;

import java.util.Scanner;

import emp_example1.com.jdbc.dao.EmpDao;
import emp_example1.com.jdbc.entities.Emp;

/**
 * @author ssuman
 *
 */
public class EmpUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpDao dao = new EmpDao();
		Emp emp = new Emp();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Name of the Employee: ");
		emp.setName(in.nextLine());
		
		System.out.print("Enter Job: ");
		emp.setJob(in.nextLine());
		
		System.out.print("Enter Salary: ");
		emp.setSalary(in.nextInt());
		
		try
		{
			dao.updateEmp(emp);
			System.out.println("successfully updated.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
