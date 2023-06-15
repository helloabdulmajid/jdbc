package com.jdbcpackages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Launch {

	public static void main(String[] args) throws Exception {
	
		Connection con = createConnection();
		//createDatabase(con);	
	    //createTable(con);
	    
	   // staticQuery(con);
	    
	    //insertDynamicData(con);
	    
	   // deleteDynamicdata(con);
		
		
		//update 
		
		  try
		    {
		    	Scanner s= new Scanner(System.in);
		    	
		    	while(true)
		    	{
		    		System.out.print("Enter Your roll Number ");
				    int roll=s.nextInt();
				    System.out.print("Enter Your New Name ");
				    String newname=s.next();
				   
				    String sql="update advjava1.students set name='"+newname+"' where roll="+roll;
				    Statement st=con.createStatement();
				    int row=st.executeUpdate(sql);
				    System.out.println(row + "rows Updated");
				    System.out.println("Do you want continue y/n");
				    char c=s.next().charAt(0);
				    if(c=='n' || c=='N')
				    {
				    	System.out.println("Thanks You");
				    	break;
				    }
		    	
		    	}
		      }
		    	
		    	catch(Exception e)
		    	{
		    		System.out.println(e);
		    	}
	}
		
		    





	private static void deleteDynamicdata(Connection con) {
		//delete data
	    
	    try
	    {
	    	Scanner s= new Scanner(System.in);
	    	
	    	while(true)
	    	{
	    		System.out.print("Enter Your roll Number ");
			    int roll=s.nextInt();
			   
			    String sql="delete from advjava1.students where roll="+roll;
			    Statement st=con.createStatement();
			    int row=st.executeUpdate(sql);
			    System.out.println(row + "rows Updated");
			    System.out.println("Do you want continue y/n");
			    char c=s.next().charAt(0);
			    if(c=='n' || c=='N')
			    {
			    	System.out.println("Thanks You");
			    	break;
			    }
	    	}
		    
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}
	    
	    
		
	

	private static void insertDynamicData(Connection con) {
		//dynamic data insert 
	    
	    try
	    {
	    	Scanner s= new Scanner(System.in);
	    	
	    	while(true)
	    	{
	    		System.out.print("Enter Your roll Number ");
			    int roll=s.nextInt();
			    System.out.print("Enter Your Name ");
			    String name=s.next();
			    System.out.print("Enter Your Phone Number ");
			    int phone=s.nextInt();
			    
			    String sql="insert into advjava1.students(roll,name,phone) values ("+roll+",'"+name+"',"+phone+")";
			    Statement st=con.createStatement();
			    int row=st.executeUpdate(sql);
			    System.out.println(row + "rows Updated");
			    System.out.println("Do you want continue y/n");
			    char c=s.next().charAt(0);
			    if(c=='n' || c=='N')
			    {
			    	System.out.println("Thanks You");
			    	break;
			    }
	    	}
		    
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	}

	private static void staticQuery(Connection con) {
		//data insert 
	    try
		{
			//String sql1="insert into students(roll,name,phone) values(1,Abdul Majid,9887654321)";  //oracle
			String sql1="insert into advjava1.students(roll,name,phone) values(2,'Abdul Majid2',1298876543)";  //mysql
				Statement st1=con.createStatement();
				int row=st1.executeUpdate(sql1);
				System.out.println(row + "rows Updated");
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static void createDatabase(Connection con) {
		//create database
		try {
			String sql="create database advjava1";  //mysql
			Statement st=con.createStatement();
			boolean execute=st.execute(sql);
			System.out.println(execute);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static void createTable(Connection con) {
		//create table


		try
		{
			String sql1="create table advjava1.students(roll int primary key,name varchar(50),phone int(12))";  //mysql
			//	String sql1="create table students(roll int primary key,name varchar(50),phone int(12))";  //oracle ->databse name not requid 
				Statement st1=con.createStatement();
				boolean execute1=st1.execute(sql1);
				System.out.println(execute1);
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static Connection createConnection() throws ClassNotFoundException, SQLException {
		//url
		String url ="jdbc:mysql://localhost:3306";    //mysql
		//String url ="jdbc:oracle:thin@localhost:1521:xe";    //oracle
		
		//username
		String username="root";
		//password
		String password="";
		
		//driver loading
		Class.forName("com.mysql.cj.jdbc.Driver");   //mysql driver loading
		// Class.forName("oracle.jdbc.driver.OracleDriver");    //oracle driver loading
		
		//Factory Design Pattern
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}

}
