package hello.survlet.web.servlet

import hello.survlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet : HttpServlet() {
    private val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val members = memberRepository.findAll()

        resp?.contentType = "text/html"
        resp?.characterEncoding = "utf-8"

        val writer = resp?.writer
        writer?.write(
            """
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
            """.trimIndent()
        )
        writer?.write("\n")

        for (member in members) {
            writer?.write(
                """
                    <tr>
                     <td>${member.id}</td>
                     <td>${member.username}</td>
                     <td>${member.age}</td>
                    </tr>
                """.trimIndent()
            )
            writer?.write("\n")
        }

        writer?.write(
            """
                 </tbody>
                </table>
                </body>
                </html>
            """.trimIndent()
        )
    }
}