<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查找结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    

  </head>
<body>
<body bgcolor="#FFE4E1">
<br/><br/><br/><br/><br/><br/><br/><br/>
	<h1 align="center">作者作品</h1>
	<table width="100%" border="1" align="center">
		<tr>
			<th align="center">书名</th>
			<th align="center">查询详细信息</th>
			<th align="center">删除</th>

		</tr>
		
         <tr>
         
           <td>
           <s:iterator value="titles">
              <s:property value="title" />
              </s:iterator>
           </td>
           <td>
               <a href="showdetail.action?isbn=<s:property value="#list.isbn" />"></a>
           </td>
           <td>
              <a href="delete.action?isbn=<s:property value="#list.isbn"/>">delete</a>
           </td>
            
         </tr>
        
       


	</table>
	<br />
		<a href="/lab2">返回主页</a>
</body>
</html>
