package database;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;

public class showdetail extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String title;
	private String isbn;
	private int authorid;
	private String publisher;
	private String publishdate;
	private int price;
	private String name;
	private int age;
	private String country;
	public String getisbn(){
		return isbn;
	}
	
	public void setisbn(String isbn){
		this.isbn = isbn;
	}
	
	public String gettitle(){
		return title;
	}
	
	public void settitle(String title){
		this.title = title;
	}
	
	public int getauthorid(){
		return authorid;
	}
	
	public void setauthorid(int authorid){
		this.authorid = authorid;
	}
	
	public String getpublisher(){
		return publisher;
	}
	
	public void setpublisher(String publisher){
		this.publisher = publisher;
	}
	
	public String getpublishdate(){
		return publishdate;
	}
	
	public void setpublishdate(String publishdate){
		this.publishdate = publishdate;
	}
	
	public int getprice(){
		return price;
	}
	
	public void setprice(int price){
		this.price = price;
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
	
	public int getage(){
		return age;
	}
	
	public void setage(int age){
		this.age = age;
	}
	
	public String getcountry(){
		return country;
	}
	
	public void setcountry(String country){
		this.country = country;
	}
	
	public String execute(){
		String url = "jdbc:mysql://localhost:8806/BookDB";
		String user = "root";
		String password = "";
		ResultSet detail, authordetail;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功！");
			Statement sql = conn.createStatement();
			String query = "select * from Book where Title =" + title;
			detail = sql.executeQuery(query);
			if(detail.next()){
				authorid = detail.getInt("AuthorID");
				isbn = detail.getString("ISBN");
				publisher = detail.getString("Publisher");
				publishdate = detail.getString("PublishDate");
				price = detail.getInt("Price");
				String query1 = "select * from Author where AuthorID =/'" + Integer.toString(authorid) + "/'";
				authordetail = sql.executeQuery(query1);
				if(authordetail.next()){
					name = authordetail.getString("Name");
					age = authordetail.getInt("Age");
					country = authordetail.getString("Country");
					conn.close();
					return "success";
				}
				return "error";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "error";
	}
}
