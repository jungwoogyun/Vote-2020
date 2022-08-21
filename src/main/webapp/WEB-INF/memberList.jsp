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
		<li><a href="/memberList.do" style="color:red">후보조회</a></li>
		<li><a href="/voteMember.do">투표하기</a></li>
		<li><a href="/voteList.do">투표검수조회</a></li>
		<li><a href="/voteResult.do">후보자등수</a></li>
		<li><a href="/main.do">홈으로</a></li>	
	</ul>
</nav>

<section>
	<%@page import="java.util.*,Dto.*" %>
	<% 
		ArrayList<MemberDTO> mlist = (ArrayList<MemberDTO>)request.getAttribute("mlist");
		ArrayList<PartyDTO> plist = (ArrayList<PartyDTO>)request.getAttribute("plist");
	%>
	<style>
		td,th{border : 1px solid gray;}
	</style>
		<div style="width:80%;margin:100px auto;">
			<h2>후 보 조 회</h2>
			<table align=center style="width:800px;">
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
				<%
				for(int i=0;i<mlist.size();i++)
				{
				%>
				<tr>
					<td><%=mlist.get(i).getM_no() %></td>
					<td><%=mlist.get(i).getM_name() %></td>
					
					<td>
						<%
							for(int j=0;j<plist.size();j++)
							{
								if(mlist.get(i).getP_code().equals(plist.get(i).getP_code()))
								{
									%> <%=plist.get(i).getP_name() %> <%
									break;
								}
								
							}
						%>
					</td>
					
					<td>
					
						<% 
							int pno = Integer.parseInt(mlist.get(i).getP_school()); 
							if(pno==1)
							{
								%>고졸<%
							}
							else if(pno==2)
							{
								%>학사<%
							}
							else if(pno==3){
								%>석사<%
							}
							else{
								%>박사<%
							}
						%>
					
					</td>
					<td><%=mlist.get(i).getM_jumin().substring(0, 6)+"-"+mlist.get(i).getM_jumin().substring(6,13) %></td>
					<td><%=mlist.get(i).getM_city() %></td>
					<td>
						<%
							for(int j=0;j<plist.size();j++)
							{
								if(mlist.get(i).getP_code().equals(plist.get(i).getP_code()))
								{
									%> <%=plist.get(i).getP_tel1()+"-"+plist.get(i).getP_tel2()+"-"+plist.get(i).getP_tel3() %> <%
									break;
								}
								
							}
						%>
					
					</td>
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