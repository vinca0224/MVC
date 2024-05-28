<%@ page import=""java.util.List %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance(); 
    List<Member> members = memberRepository.findAll();
%>
<html>    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <%
        for(Member member : members){
            out.write("member.getId() + " " + member.getUsername() + " " + member.getAge());
        }
    %>
</body>
</html>