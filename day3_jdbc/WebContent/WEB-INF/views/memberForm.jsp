<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frmLogin" method="post" action="${contextPath}/member/addMember.do">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="id" value="" size="20" />
				</td>
				<td><input type="password" name="pwd" value="" size="20" />
				</td>
				<td><input type="text" name="name" value="" size="20" />
				</td>
				<td><input type="email" name="email" value="" size="20" />
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
				<input type="submit" value="회원가입" /> 
				<input type="reset" value="다시입력" />
			</td>
			</tr>
		</table>
	</form>

</body>
</html>