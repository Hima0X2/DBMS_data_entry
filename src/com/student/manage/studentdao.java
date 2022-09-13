package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentdao {
public static boolean insert(student s) {
	boolean f=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
	   // System.out.println("Connected With the database successfully");
		String q="insert into emp values(?,?,?,?)";
		//Preparestatement
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1,s.getRoll());
		pstmt.setString(2,s.getNumber());
		pstmt.setString(3,s.getName());
		pstmt.setString(4,s.getGpa());
		pstmt.executeUpdate();
		f=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
public static boolean delete(String roll) {
	boolean f=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
		String q="delete from emp where roll=?";
		//Preparestatement
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1,roll);
		pstmt.executeUpdate();
		f=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
public static boolean update(String u,String value,String roll) {
	boolean f=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
	  //  System.out.println("Connected With the database successfully");
		String q="update emp set "+u+"=? where roll=?";
		//Preparestatement
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setString(1,value);
		pstmt.setString(2, roll);
		pstmt.executeUpdate();
		f=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;
}
}
