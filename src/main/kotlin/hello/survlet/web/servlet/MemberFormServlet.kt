package hello.survlet.web.servlet

import hello.survlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberFormServlet", urlPatterns = ["/servlet/members/new-form"])
class MemberFormServlet : HttpServlet() {

    private val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html"
        resp?.characterEncoding = "utf-8"

        val writer = resp?.writer
        writer?.write(
            """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset=\"UTF-8\">
                <title>Title</title>
                </head>
                <body>
                <form action="/servlet/members/save" method="post">
                 username: <input type="text" name="username" />
                 age: <input type="text" name="age" />
                 <button type="submit">전송</button>
                </form>
                </body>
                </html>
            """.trimIndent()
        )
    }
}