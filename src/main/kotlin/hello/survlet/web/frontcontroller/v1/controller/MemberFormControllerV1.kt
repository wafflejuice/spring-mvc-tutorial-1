package hello.survlet.web.frontcontroller.v1.controller

import hello.survlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV1 : ControllerV1 {
    override fun process(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val viewPath = "/WEB-INF/views/new-form.jsp"
        val dispatcher = req?.getRequestDispatcher(viewPath)
        dispatcher?.forward(req, resp)
    }
}