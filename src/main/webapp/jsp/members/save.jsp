<%@ page import="hello.servelt.domain.member.Member" %>
<%@ page import="hello.servelt.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: real_
  Date: 2021-09-11
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //requset, response는 그냥 사용 가능하다
    MemberRepository memberRepository = MemberRepository.getInstance();


    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username,age);
    memberRepository.save(member);


%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>