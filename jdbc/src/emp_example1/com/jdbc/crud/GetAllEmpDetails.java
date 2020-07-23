/**
 * 
 */
package emp_example1.com.jdbc.crud;

import java.util.Iterator;
import java.util.List;

import emp_example1.com.jdbc.dao.EmpDao;
import emp_example1.com.jdbc.entities.Emp;

/**
 * @author ssuman
 *
 */
public class GetAllEmpDetails {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmpDao dao=new EmpDao();
		try
		{
		List<Emp> list=dao.getAllEmpDetails();
		Iterator<Emp> itr=list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
