package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.*;

public class ToDoDAO 
{
public  Connection con;

	
	



	public ToDoDAO(Connection con) {
	super();
	this.con = con;
}






	public boolean addTodo(String name,String todo,String status)
	{
		boolean f=false;
		
		try
		{
			String sql="insert into todo_app1(name,todo,status) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement( sql);
			
			ps.setString(1,name);
			ps.setString(2, todo);
			ps.setString(3, status);
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	 
	
	public List<TodoDlts> getTodo()
	{
		List<TodoDlts> list=new ArrayList<TodoDlts>();
		TodoDlts t=null;
		try
		{
			String sql="select * from todo_app1";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet re=ps.executeQuery();
			while(re.next())
			{
				t=new TodoDlts();
				t.setId(re.getInt(1));
				t.setName(re.getString(2));
				t.setTodo(re.getString(3));
				t.setStatus(re.getString(4));
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return list;
		
	}
	

}
