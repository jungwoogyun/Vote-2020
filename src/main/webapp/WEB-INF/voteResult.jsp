<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
	body{
		text-align:center;
		 
	}
	header
	{
		height:80px;
	}
	nav
	{
	
	}
	nav ul
	{
		list-style:none;
		padding-left:0px;
		display:flex;
		justify-content: space-evenly;
	}
	nav li a{
		text-decoration:none;
		color : black;
	}
	section
	{
		height:800px;
	}
	footer	
	{
		height:300px;
	}
	
</style>

</head>
<body>



<header>
	<h1>(과정평가형 정보처리산업기사)지역구의원투표 프로그램 ver 2020-05</h1>
</header>
<nav>
	<ul>
		<li><a href="/memberList.do" >후보조회</a></li>
		<li><a href="/voteMember.do">투표하기</a></li>
		<li><a href="/voteList.do">투표검수조회</a></li>
		<li><a href="/voteResult.do"  style="color:red">후보자등수</a></li>
		<li><a href="/main.do">홈으로</a></li>	
	</ul>
</nav>

<section>
	<%@page import="java.util.*,Dto.*" %>
	<% 
	 		
		RankDTO [] rank = (RankDTO [])request.getAttribute("rank");
		
	
		
	%>
	<style>
		td,th{border : 1px solid gray;}
	</style>
		<div style="width:50%;margin:100px auto;">
			<h2>후보자등수</h2>
			<table align=center style="width:500px;">
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				
				<%
			
					for(int i=0;i<rank.length;i++)
					{
				%>
				<tr>	
					<td><%=rank[i].getDto().getM_no() %></td>
					<td><%=rank[i].getDto().getM_name() %></td>
					<td><%=rank[i].getVoteval() %></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

</section>
<footer>
HRDKOREA Copyright@2015 All rights reserved. Human Resources Development Service of Korea
</footer>

</body>
</html>