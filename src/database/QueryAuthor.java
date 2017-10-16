package database;

import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class QueryAuthor extends ActionSupport{   
	private static final long serialVersionUID = 1L;
	private String Authorname;
	private ArrayList<Booklist> titles = new ArrayList<Booklist>(); 
	
	public String getAuthorname(){
		return Authorname;
	}
	
	public void setAuthorname(String Authorname){
		this.Authorname = Authorname;
	}
	
	public ArrayList<Booklist> gettitles(){     
		return titles;
	}
	
	public void settitles(ArrayList<Booklist> titles){
		this.titles = titles;
	}
	
	public String execute(){
	
		String url = "jdbc:mysql://localhost:3306/BookDB";
		String user = "root";
		String password = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			return "error";
		}
		try{
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功！");
			//Statement sql = conn.createStatement();
			String query = "select AuthorID from Author where";
			query += " Name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Authorname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("AuthorID");
				String bg = "select * from Book where";
				bg += " AuthorID = ?";
				PreparedStatement qs = conn.prepareStatement(bg);
				qs.setInt(1, id);
				ResultSet title = qs.executeQuery();
				while(title.next()){
					String temp = title.getString("Title");
					String is = title.getString("ISBN");
					Booklist tmp = new Booklist(Authorname,temp,is);
					titles.add(tmp);
				}
				if(titles.isEmpty()){
					System.out.println("1");
				}
				else{
					System.out.println(titles.size());
				}
				for(int i = 0;i < titles.size();i++){
					System.out.println(titles.get(i));
				}
				conn.close();
				return "success";
			}
			else{
				return "error";
			}
		}catch(SQLException e){
			return "error";
		}
	}
}

class Booklist{
	private String authorname;
	private String title;
	private String isbn;
	public Booklist(String authorname, String title, String isbn){
		this.authorname = authorname;
		this.title = title;
	};
	public String getauthorname(){
		return authorname;
	}
	public void setauthorname(String authorname){
		this.authorname = authorname;
	}
	public String gettitle(){
		return title;
	}
	public void settitle(String title){
		this.title = title;
	}
	public String getisbn(){
		return isbn;
	}
	public void setisbn(String isbn){
		this.isbn = isbn;
	}
}