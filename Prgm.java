// importing jdbc packages
import java.sql.*;
public class jdbccon{
    public static void main(String[] args){
// Loading and registering jdbc driver   	 
   	 try{
   	 Class.forName("com.mysql.cj.jdbc.Driver");
   	 System.out.println("Driver loaded and registered successfully");
   	 }
   	 catch(ClassNotFoundException e)
   	 {
   	 System.out.println("Exception "+e);
   	 }
// Creating a connection object
   	 try{
   	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprogramming","yadhu","password");
// creating a Statement object
   	 Statement smt=con.createStatement();
// Executing Statement object and return a query Resultset and process
   	 ResultSet rs=smt.executeQuery("select name from student");
   	 while(rs.next())
   	 {
   	 System.out.println(rs.getString("name"));
   	 }
   	 rs.close();
   	 smt.close();
   	 con.close();
   	 }
   	 catch(SQLException SE)
   	 {
   	 System.out.println("Sql exception"+SE);
   	 }
   	 
   	 }
   	 }
    	

