package com.product.list.servletBusiness;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.list.dao.ProductDao;
import com.product.list.entities.Product;

@WebServlet("/create")
public class CreateProductServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String code = request.getParameter("cr_code");
    	String tName = request.getParameter("cr_name");
    	String tPrice = request.getParameter("cr_price");
    	
    	float price = 0;
    	try {
            price = Float.parseFloat(tPrice);
        } catch (Exception e) {
        }
    	
    	String errorString = null;
    	
    	ProductDao dao = new ProductDao();
    	
    	List<Product> product = null;
    	
    	Product tProduct = new Product(code, tName, price);
    	
    	if(code == null || tName == null || price == 0)
    	{
    		errorString = "Invalid details entered!";
    	}
    	else
    	{
    		try 
    		{
				dao.createProduct(tProduct);
				
				product = dao.getAllProductList();
				
				request.setAttribute("Products", product);
				RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
				rd.forward(request, response);
				
			} 
    		catch (Exception e) 
    		{
				e.printStackTrace();
			}
    	}
	}
}
