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
	tr
	{
	 border:1px solid gray;
	 text-align:left;
	}
	td
	{
	border:1px solid gray;
	}
	button
	{

	}
</style>

</head>
<body>



<header>
	<h1>(과정평가형 정보처리산업기사)지역구의원투표 프로그램 ver 2020-05</h1>
</header>
<nav>
	<ul>
		<li><a href="/memberList.do">후보조회</a></li>
		<li><a href="/voteMember.do"><span style="color:red">투표하기</span></a></li>
		<li><a href="/voteList.do">투표검수조회</a></li>
		<li><a href="/voteResult.do">후보자등수</a></li>
		<li><a href="/main.do">홈으로</a></li>	
	</ul>
</nav>
<section>

	<div style="width:80%;margin:100px auto;">
		<h2>투 표 하 기</h2>
		<form method=post  name=voteform  onsubmit="return false">
			<table align=center  >
				<tr>
					<td>주민번호</td>
					<td width=500px;><input type="text" name="v_jumin"></td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input type="text" name="v_name"></td>
				</tr>
				<tr>
					<td>후보번호</td>
					<td>
						<select name="m_no">
							<option value=0></option>
							<option value=1>[1]김후보</option>
							<option value=2>[2]이후보</option>
							<option value=3>[3]박후보</option>
							<option value=4>[4]조후보</option>
							<option value=5>[5]최후보</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>투표시간</td>
					<td><input type="text" name="v_time"></td>
				</tr>
				<tr>
					<td>투표장소</td>
					<td><input type="text" name="v_area"></td>
				</tr>
				<tr>
					<td>유권자확인</td>
					<td>
						<input type="radio"  name="v_confirm" value="Y"> 확인
						<input type="radio"  name="v_confirm" value="N"> 미확인 
					</td>
				</tr>
				<input type=hidden name=flag value=true>
				<tr style="text-align:center;">
					<td colspan=2><button onclick="inputcheck()">투표하기</button><button onclick="resetfunc()">다시하기</button></td>
				</tr>
			</table>
		</form>
	</div>

</section>

<footer>
HRDKOREA Copyright@2015 All rights reserved. Human Resources Development Service of Korea
</footer>

</body>



<script>

	function inputcheck()
	{
		 
		var f = document.voteform;
		
		if(f.v_jumin.value.trim()==""){
			alert("주민번호가 입력되지 않았습니다!");
			f.v_jumin.focus();
			return false;
		}
		if(f.v_name.value.trim()==""){
			alert("성명이 입력되지 않았습니다!");
			f.v_name.focus();
			return false;
		}
		if(!f.m_no.selectedIndex){
			alert("후보번호가 선택되지 않았습니다!");
			f.m_no.focus();
			return false;
		}
		if(f.v_time.value.trim()==""){
			alert("투표시간이 입력되지 않았습니다!");
			f.v_time.focus();
			return false;
		}
		if(f.v_area.value.trim()==""){
			alert("투표장소가 입력되지 않았습니다!");
			f.v_area.focus();
			return false;
		}	
		if(f.v_confirm.value.trim()==""){
			alert("유권자확인이 선택되지 않았습니다!");
			f.v_confirm.focus();
			return false;
		}
			
		f.action="/voteMember.do";
		f.submit();
		

	}

	function resetfunc()
	{
		
		var f = document.voteform;
		var result = confirm("정보를 지우고 처음부터 다시 입력합니다!");

		if(result==true)
		{
			f.reset();	
			f.v_jumin.focus()	 
			return ;
		}
		else 
		{
			return ;	
		}
		
	}
</script>





</html>