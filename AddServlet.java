package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ToDoDAO;
import com.DB.DBConection;

@WebServlet("add_todo")
public class AddServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status=req.getParameter("status");
		
		ToDoDAO dao=new ToDoDAO(DBConection.getCon());
		boolean f=dao.addTodo(username, todo, status);
		
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("sucMsg", "Todo Added Successfuly");
			resp.sendRedirect("index.jsp");
//			System.out.println("Data Insert Succesfully");
		}
		else
		{
			session.setAttribute("failedMsg", "Todo Not Added Successfuly");
			resp.sendRedirect("index.jsp");
//			System.out.println("Error");
		}
		
//		System.out.println(username + " " + todo + " " +status);
		
		
	}
}
