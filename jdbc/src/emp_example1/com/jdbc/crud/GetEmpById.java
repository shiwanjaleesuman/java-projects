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
public class GetEmpById {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpDao dao=new EmpDao();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter EmpId: ");
		int id=in.nextInt();
		try
		{
			Emp e=dao.getEmpDetailsById(id);
			
			if(e !=null)
				System.out.println(e);
			else
				System.out.println("Invalid Id.");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
