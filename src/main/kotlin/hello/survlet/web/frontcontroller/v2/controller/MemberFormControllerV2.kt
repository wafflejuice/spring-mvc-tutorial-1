package hello.survlet.web.frontcontroller.v2.controller

import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV2() : ControllerV2 {
    override fun process(req: HttpServletRequest?, resp: HttpServletResponse?): MyView {
        return MyView("/WEB-INF/views/new-form.jsp")
    }
}