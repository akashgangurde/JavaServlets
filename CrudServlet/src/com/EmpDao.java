package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpDao {
public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletcrud","root","");
		} catch (Exception e) {
			System.out.println();
		}
		
		return con;
	}
public static int save(Employee e){  
    int status=0;  
    try{  
        Connection con=EmpDao.getConnection();  
        PreparedStatement ps=con.prepareStatement(  
                     "insert into emptable(name,password,email,country) values (?,?,?,?)");  
        ps.setString(1,e.getName());  
        ps.setString(2,e.getPasssword());  
        ps.setString(3,e.getEmail());  
        ps.setString(4,e.getCountry());  
          
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return status;  
}  
}
