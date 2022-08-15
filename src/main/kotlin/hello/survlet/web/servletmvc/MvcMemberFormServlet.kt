package hello.survlet.web.servletmvc

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = ["/servlet-mvc/members/new-form"])
class MvcMemberFormServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        // Web-INF는 외부에서 호출 불가
        val viewPath = "/WEB-INF/views/new-form.jsp"
        val dispatcher = req?.getRequestDispatcher(viewPath)
        // forward != redirect
        dispatcher?.forward(req, resp)
    }
}