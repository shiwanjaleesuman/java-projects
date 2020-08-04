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
	//Product tProduct = new Product();
	
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
	
	public void createProduct(Product pProduct) throws Exception
	{
		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
		PreparedStatement ps = con.prepareStatement("Insert into Product(Code, Name,Price) values (?,?,?)");
		ps.setString(1, pProduct.getCode());
		ps.setString(2, pProduct.getName());
		ps.setFloat(3, pProduct.getPrice());
		ps.executeUpdate();
		con.close();
	}
	
	public void updateProductDetails(Product pProduct) throws Exception
	{
		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
		PreparedStatement ps = con.prepareStatement("Update Product set Name = ?, Price = ? where Code = ?");
		ps.setString(1, pProduct.getName());
		ps.setFloat(2, pProduct.getPrice());
		ps.setString(3, pProduct.getCode());
		ps.executeUpdate();
		con.close();
	}
	
	public static void deleteProduct(String code) throws Exception 
	{
		Connection con = (Connection) MySQLConnUtils.getMySQLConnection();
        PreparedStatement ps = con.prepareStatement("Delete From Product where Code= ?");
        ps.setString(1, code);
        ps.executeUpdate();
    }
}
