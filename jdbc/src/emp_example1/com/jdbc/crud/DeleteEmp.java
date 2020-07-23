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
public class DeleteEmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpDao dao = new EmpDao();
		Emp emp = new Emp();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Id of the Employee to be deleted: ");
		int id = in.nextInt();

		try
		{
			int deleted = dao.remove(id);
			if(deleted>0)
			{
				System.out.println(deleted+" record successfully removed.");
			}
			else
			{
				System.out.println("Invalid Id");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}