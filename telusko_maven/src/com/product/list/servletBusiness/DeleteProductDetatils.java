package com.product.list.servletBusiness;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.list.dao.ProductDao;
import com.product.list.entities.Product;

@WebServlet("/delete")
public class DeleteProductDetatils extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tCode = request.getParameter("dt_code");
		
		ProductDao dao = new ProductDao();
		
		Product tProduct = new Product();
		
		try 
		{
			dao.deleteProduct(tCode);
			tProduct = dao.getProductDetailsBySku(tCode);
			
//			if(!(tCode.isBlank()))
//			{
				request.setAttribute("Product", tProduct);
				RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
				rd.forward(request, response);
//			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
