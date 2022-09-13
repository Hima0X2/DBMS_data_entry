package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class abc {
public static boolean update(String name,String gpa,String number,String roll) {
	boolean f=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
	  //  System.out.println("Connected With the database successfully");
		//String q="update emp set name='"+name+"',gpa ='"+gpa+"'number = '"+number+"' where roll='"+roll+"'";
		//Preparestatement
		String q="update emp set name='"+name+"',gpa ='"+gpa+"'number = '"+number+"' where roll='"+roll+"'";
		Statement pstmt=(Statement) con.prepareStatement(q);
		pstmt.execute(q);
		f=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
}
