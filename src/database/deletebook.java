package database;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class deletebook extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String isbn;
	
	public String getisbn(){
		return isbn;
	}
	
	public void setisbn(String isbn){
		this.isbn = isbn;
	}
	
	public String execute(){
		String url = "jdbc:mysql://localhost:3306/Lab2";
		String user = "root";
		String password = "84587353";
		ResultSet back;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功！");
			Statement sql = conn.createStatement();
			String de = "delete from Book where ISBN =" + isbn;
			sql.executeUpdate(de);
			conn.close();
			return "success";
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "error";
	}
}
