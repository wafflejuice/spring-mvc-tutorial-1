<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.survlet.domain.member.Member" %>
<%@ page import="hello.survlet.domain.member.MemberRepository" %>
<%
    //request, response 사용 가능
    //jsp도 결국 servlet으로 바뀌기 때문
    MemberRepository memberRepository = MemberRepository.INSTANCE;
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(0, username, age);
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
