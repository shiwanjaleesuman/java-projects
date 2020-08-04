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

@WebServlet("/update")
public class UpdateProductDetails extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tCode = request.getParameter("up_code");
    	String tName = request.getParameter("up_name");
    	String tPrice = request.getParameter("up_price");
    	
    	float price = 0;
    	try {
            price = Float.parseFloat(tPrice);
        } catch (Exception e) {
        }
    	//Product product = null;
    	String errorString = null;
    	ProductDao dao = new ProductDao();
    	
//    	try 
//    	{
//			product = dao.getProductDetailsBySku(tCode);
//			request.setAttribute("Product", product);
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductRecord.jsp");
//	        dispatcher.forward(request, response);
//		} 
//    	catch (Exception e1) {
//			e1.printStackTrace();
//		}

    	Product tProduct = new Product(tCode, tName, price);
    	
    	List<Product> products = null;
    	
    	if(tCode == null)
    	{
    		errorString = "Invalid details entered!";
    	}
    	else
    	{
    		try 
    		{
				dao.updateProductDetails(tProduct);
				products = dao.getAllProductList();
				
				request.setAttribute("Products", products);
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
