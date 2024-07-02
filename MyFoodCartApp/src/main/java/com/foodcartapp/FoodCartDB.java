package com.foodcartapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDB {
	
	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/food?UseSSL=false";
		String uid="root";
		String password="Nani@1902";
		
		ArrayList<Food> food= new ArrayList<>();
		//load the driver 
		Class.forName("com.mysql.jdbc.Driver");
		//making connection
		Connection con=DriverManager.getConnection(url,uid,password);
		//statement 
		Statement st= con.createStatement();
		
		// process and loop the result 
		ResultSet rs=st.executeQuery("select * from foodcart");
		while(rs.next()) { 
			int id=rs.getInt(1);
			String item=rs.getString(2);
		    float price =rs.getFloat(3);
		    Food f=new Food(id,item,price);
		    food.add(f);
		}
		
		return food;
	}

}
