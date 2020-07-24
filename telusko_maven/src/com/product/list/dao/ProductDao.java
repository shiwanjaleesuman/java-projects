package com.product.list.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.list.connections.MySQLConnUtils;
import com.product.list.entities.Product;

/**
 * @author ssuman
 *
 */
public class ProductDao 
{
	Product tProduct = new Product();
	
	public Product getProductDetailsBySku(String pCode) throws Exception
	{
		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
		Product product = new Product();
		
		if(product != null)
		{
			PreparedStatement ps = con.prepareStatement("select * from Product where code=?");
			ps.setString(1, pCode);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				product = mapRecord(rs);
			}
		}
		return product;
	}
	
	public List<Product> getAllProductList() throws Exception
	{
		
		List<Product> tProducts = new ArrayList<>();
		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
		
//		if(tProducts != null)
//		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
			while(rs.next())
			{
				tProducts.add(mapRecord(rs));
				//tProducts.add(tProduct);			
			}
			return tProducts;
//		}
		//return tProducts;
	}
	
	private Product mapRecord(ResultSet rset) throws Exception

	{
		Product tProduct = new Product();
		tProduct.setCode(rset.getString(1));
		tProduct.setName(rset.getString(2));
		tProduct.setPrice(rset.getFloat(3));
		return tProduct;
	}

//	public boolean isSKUExists(String pCode) throws Exception
//	{
//		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
//		Product tProduct = new Product();
//		if(tProduct.getCode() != null)
//		{
//			PreparedStatement ps;
//			try 
//			{
//				ps = con.prepareStatement("select * from Product where code=?");
//				ps.setString(1, pCode);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next())
//				{
//					return true;
//				}
//			} 
//			catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
}
