package hello.survlet.web.servletmvc

import hello.survlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberListServlet", urlPatterns = ["/servlet-mvc/members"])
class MvcMemberListServlet : HttpServlet() {
    val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val members = memberRepository.findAll()

        req?.setAttribute("members", members)

        val viewPath = "/WEB-INF/views/members.jsp"
        val dispatcher = req?.getRequestDispatcher(viewPath)
        dispatcher?.forward(req, resp)
    }
}