// jdbc program for inserting , deleting and updating records in employeee table
/*

import java.sql.*;
import java.io.*;
public class program1{
	public static void main(String[] args){
	{try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
		System.out.println("Exception : "+e);
		}
		try{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprogramming","yadhu","password");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select ename from employee");
		while(rs.next())
		{
		System.out.println(rs.getString("ename"));
		}
		rs.close();
		stmt.close();
		con.close();
		}
		catch(SQLException SE)
		{
		System.out.println("exception:");
		}
		}}}
		
	*/
	
	
import java.sql.*;
import java.io.*;
public class program1{
	public static void main(String[] args){
	System.out.println(".......EMPLOYEE TABLE CONTROLLER V1........\n");
	ResultSet rs;
ResultSetMetaData rm;
String ename,job,eno,salary;
int n,ch;
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprogramming","yadhu","password");
	Statement stmt=con.createStatement();
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	while(true)
	{
	System.out.println("\n1.select\n2.insert\n3.Update\n4.Delete\n5.Exit\nEnter you choice : ");
	ch=Integer.parseInt(br.readLine());
	switch(ch)
	{
	case 1: 
		rs=stmt.executeQuery("select * from employee");
		rm=rs.getMetaData();
		n=rm.getColumnCount();
		while(rs.next())
		{
		for(int i=1;i<n+1;i++)
			System.out.print(rs.getString(i)+"\t\t");
		System.out.println();
		}
		break;
	case 2: 
		System.out.println("Enter Eno");
		eno=br.readLine();
		System.out.println("Enter Ename");
		ename=br.readLine();
		System.out.println("Enter job");		
		job=br.readLine();
		
		System.out.println("Enter Salary");
		salary=br.readLine();
		
		
		stmt.execute("insert into employee values("+eno+",'"+ename+"','"+job+"',"+salary+")");
		System.out.println("\n 1 Record Inserted");
		break;
	case 3:
		System.out.println("Enter employee no to Edit : ");
		eno=br.readLine();
		System.out.println("Enter Name");
		ename=br.readLine();

		System.out.println("Enter Job");
		job = br.readLine();
		System.out.println("Enter Salary");
		salary=br.readLine();
		stmt.execute("update employee set ename= '"+ename+"',job='"+job+"' where eno="+eno+"");
		System.out.println("1 Record Updated");
		break;
	case 4:
		System.out.println("Enter E.no to Delete : ");
		eno=br.readLine();
		stmt.execute("delete from employee where eno="+eno+"");
		System.out.println("1 Record Deleted");
		break;
	case 5:
		br.close();
		con.close();
		System.exit(0);
	}
		
	
	
	
	
	}
	}
	
	catch(Exception e)
	{
	System.out.println("error"+e);
	}
	}
	}
	
	
