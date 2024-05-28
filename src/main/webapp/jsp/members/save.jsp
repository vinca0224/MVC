<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    
    System.out.printLN("MemberSaveServlet.service");

    String username = req.getParameter("username");
    int age = Integer.parseInt(req.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    성공
    <ul>
        <li>id=<%= member.getId()%> </li>
        <li>username=<%= member.getUsername()%> </li>
        <li>age=<%= member.getAge()%> </li>
    </ul>
    <a href="/index.html">main</a>
</body>
</html>