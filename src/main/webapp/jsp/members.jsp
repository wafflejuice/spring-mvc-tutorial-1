<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.survlet.domain.member.MemberRepository" %>
<%@ page import="hello.survlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%

  MemberRepository memberRepository = MemberRepository.INSTANCE;
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write("    <tr>\n");
            out.write("        <td>" + member.getId() + "</td>\n");
            out.write("        <td>" + member.getUsername() + "</td>\n");
            out.write("        <td>" + member.getAge() + "</td>\n");
            out.write("    </tr>\n");
        }
    %>
    </tbody>
</table>
</body>
</html>