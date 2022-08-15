package hello.survlet.web.servletmvc

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet : HttpServlet() {
    val memberRepository = MemberRepository

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val username = req?.getParameter("username")
        val age = req?.getParameter("age")?.toIntOrNull()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        //Model에 데이터를 보관한다.
        req.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, resp)
    }
}