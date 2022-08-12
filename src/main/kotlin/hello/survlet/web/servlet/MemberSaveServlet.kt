package hello.survlet.web.servlet

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {

    private val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("MemberSaveServlet.service")
        val username = req?.getParameter("username")
        val age = req?.getParameter("age")?.toIntOrNull()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        resp?.contentType = "text/html"
        resp?.characterEncoding = "utf-8"

        val writer = resp?.writer
        writer?.write(
            """
                <html>
                <head>
                 <meta charset="UTF-8">
                </head>
                <body>
                성공
                <ul>
                 <li>id=${member.id}</li>
                 <li>username=${member.username}</li>
                 <li>age=${member.age}</li>
                </ul>
                <a href="/index.html">메인</a>
                </body>
                </html>
            """.trimIndent()
        )
    }
}