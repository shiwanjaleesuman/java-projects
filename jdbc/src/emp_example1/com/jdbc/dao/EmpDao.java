/**
 * 
 */
package emp_example1.com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import emp_example1.com.jdbc.entities.Emp;

/**
 * @author ssuman
 *
 */
public class EmpDao 
{
	private Connection getConnection() throws Exception
	{
		//register the Driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//to make the connection object
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivy", "admin", "admin");
		return con;
	}
	
	public void saveEmp(Emp e) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into Emp ((name, job, salary) values(?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getJob());
		ps.setInt(3, e.getSalary());
		ps.executeUpdate();
		con.close();
	}
	
	public void updateEmp(Emp e) throws Exception
	{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("update Emp set name=?, job=?, salary=? where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getJob());
		ps.setInt(3, e.getSalary());
		ps.executeUpdate();
		con.close();
	}
	
	public Emp getEmpDetailsById(int id) throws Exception
	{
		Emp emp = null;
		Connection con = getConnection();
		if(emp != null)
		{
			PreparedStatement ps = con.prepareStatement("select * from Emp where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				emp = mapRecord(rs);
			}
		}
		return emp;
	}
	
	public List<Emp> getAllEmpDetails() throws Exception
	{
		List<Emp> emp = new ArrayList<Emp>();
		Connection con = getConnection();
		
		if(emp != null)
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");
			while(rs.next())
			{
				emp.add(mapRecord(rs));
			}
		}
		return emp;
	}
	
	private Emp mapRecord(ResultSet rset) throws Exception
	{
		Emp e=new Emp();
		e.setId(rset.getInt(1));
		e.setName(rset.getString(2));
		e.setJob(rset.getString(3));
		e.setSalary(rset.getInt(4));
		return e;
	}
	
	public int remove(int id) throws Exception
	{
	Connection con = getConnection();
	PreparedStatement stmt=con.prepareStatement(
	"delete from Emp where id=?");
	stmt.setInt(1, id);
	int deleted=stmt.executeUpdate();
	con.close();
	return deleted;
	}
}
