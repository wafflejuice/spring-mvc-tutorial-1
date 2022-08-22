package hello.survlet.web.frontcontroller.v5

import hello.survlet.web.frontcontroller.ModelView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface MyHandlerAdapter {

    fun supports(handler: Any): Boolean

    fun handle(req: HttpServletRequest?, resp: HttpServletResponse?, handler: Any): ModelView
}