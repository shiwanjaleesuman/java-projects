package com.product.list.servletBusiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.list.dao.ProductDao;
import com.product.list.entities.Product;

@WebServlet("/list")
public class ListServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String tCode = request.getParameter("code");
		ProductDao dao = new ProductDao();
		Product tProduct = new Product();
		List<Product> product = null;
		
		try 
		{
			tProduct = dao.getProductDetailsBySku(tCode);
			product = dao.getAllProductList();
			
			if(!(tCode.isBlank()))
			{
//				request.setAttribute("SKU", tProduct.getCode());
//				request.setAttribute("Name", tProduct.getName());
//				request.setAttribute("Price", tProduct.getPrice());
				request.setAttribute("Product", tProduct);
				RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Products", product);
				RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
				rd.forward(request, response);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
	}
}
