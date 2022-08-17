package hello.survlet.web.frontcontroller.v2

import hello.survlet.web.frontcontroller.MyView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface ControllerV2 {
    fun process(
        req: HttpServletRequest?,
        resp: HttpServletResponse?
    ): MyView
}