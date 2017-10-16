<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-----
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图书详情</title>
	</head>
<body>
<body bgcolor="#FFE4E1">
	<h1 align="center">作者信息</h1>
	<table width="100%" border="1" align="center">
		<tr>
			<th>AuthorID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
		</tr>
		<%
			ArrayList<Map<String, String>> list2 = (ArrayList<Map<String, String>>) session.getAttribute("authorlist");
			if (list2.size() > 0) {
				out.print("<tr align=\"center\"><td>" + list2.get(0).get("AuthorID") + "</td>\n");
				out.print("<td>" + list2.get(0).get("Name") + "</td>\n");
				out.print("<td>" + list2.get(0).get("Age") + "</td>\n");
				out.print("<td>" + list2.get(0).get("Country") + "</td></tr>\n");
			} else {
				out.print("<tr><td>" + "false" + "</td></tr>\n");
			}
		%>

	</table>
	</table>
	<h1 align="center">作品详细信息</h1>
	<table width="100%" border="1" align="center">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>AuthorID</th>
			<th>Publisher</th>
			<th>PublishDate</th>
			<th>Price</th>
		</tr>
		<%
			ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) session.getAttribute("booklist");
			if (list.size() > 0) {
				out.print("<tr align=\"center\"><td>" + list.get(0).get("ISBN") + "</td>\n");
				out.print("<td>" + list.get(0).get("Title") + "</td>\n");
				out.print("<td>" + list.get(0).get("AuthorID") + "</td>\n");
				out.print("<td>" + list.get(0).get("Publisher") + "</td>\n");
				out.print("<td>" + list.get(0).get("PublishDate") + "</td>\n");
				out.print("<td>" + list.get(0).get("Price") + "</td></tr>\n");
			} else {
				out.print("<tr><td>" + "false" + "</td></tr>\n");
			}
		%>

	</table>
	</br>
	<div>
		<a href="index.jsp">返回主页</a>

	</div>
</body>
</html>