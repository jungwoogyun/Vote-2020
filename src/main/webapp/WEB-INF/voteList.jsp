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
		<li><a href="/voteList.do" style="color:red">투표검수조회</a></li>
		<li><a href="/voteResult.do">후보자등수</a></li>
		<li><a href="/main.do">홈으로</a></li>	
	</ul>
</nav>

<section>
	<%@page import="java.util.*,Dto.*" %>
	<% 
		ArrayList<VoteDTO> vlist = (ArrayList<VoteDTO>)request.getAttribute("vlist");
		ArrayList<MemberDTO> mlist = (ArrayList<MemberDTO>)request.getAttribute("mlist");
		
		vlist.forEach(dto -> System.out.println(dto));
	%>
	<style>
		td,th{border : 1px solid gray;}
	</style>
		<div style="width:80%;margin:3px auto;">
			<h2>투표검수조회</h2>
			<table align=center style="width:800px;">
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<%
				for(int i=0;i<vlist.size();i++)
				{
				%>
					<tr>
						<!-- 1번째 열  -->
						<td><%=vlist.get(i).getV_name() %></td>

						
						<!-- 2번째 열  -->
						<%
							String birth = vlist.get(i).getV_jumin();
							String yyyy = birth.substring(0,2);
							yyyy = "19"+yyyy;
							String mm = birth.substring(2,4);
							String dd = birth.substring(4,6);
							birth = yyyy+"년"+mm+"월"+dd+"일생";
						%>
						<td><%=birth %></td>
						
						<!-- 3번째 열  -->
						<%
							Calendar current = Calendar.getInstance();
						
							int currentYear  = current.get(Calendar.YEAR);
					        int currentMonth = current.get(Calendar.MONTH) + 1;
					        int currentDay   = current.get(Calendar.DAY_OF_MONTH);
					        
					        // 만 나이 구하기 2022-1995=27 (현재년-태어난년)  
					        int age = currentYear - Integer.parseInt(yyyy);
					       
					        // 만약 생일이 지나지 않았으면 -1
					        if ( Integer.parseInt(mm) * 100 + Integer.parseInt(dd) > currentMonth * 100 + currentDay) 
					             	age--;
					         // 5월 26일 생은 526
					         // 현재날짜 5월 25일은 525
					         // 두 수를 비교 했을 때 생일이 더 클 경우 생일이 지나지 않은 것이다.
					         
					         
						%>
						<td><%="만 " + (age-2)+"세" %></td>
						
						
						<!-- 4번째 열  -->
						<%
							String gender = vlist.get(i).getV_jumin().substring(6,7);
							if(gender.equals("1"))
							{
						%>
						<td><%="남" %></td>
						<%
							}
							else
							{
						%>
						<td><%="여" %></td>
						<%
							}
						%>
						
						<!-- 5번째 열  -->
						<%
							for(int j=0;j<mlist.size();j++)
							{
								if(vlist.get(i).getN_no().equals(mlist.get(j).getM_no()))
								{
									%><td><%=mlist.get(j).getM_name() %></td><%
									 break;
								}
								
							}
						%>
						 
						
						
						
						<!-- 6번째 열  -->
						<td><%=vlist.get(i).getV_time().substring(0,2)+":"+vlist.get(i).getV_time().substring(2,4) %></td>
						
						<%
							String confirm = vlist.get(i).getV_confirm();
							if(confirm.equals("Y"))
							{
								%>
								<td>확인</td>
								<% 
							}
							else
							{
								%>
								<td>미확인</td>
								<%
							}
						%>
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