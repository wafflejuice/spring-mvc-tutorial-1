package hello.survlet.web.frontcontroller

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyView(
    val viewPath: String
) {
    fun render(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val dispatcher = req?.getRequestDispatcher(viewPath)
        dispatcher?.forward(req, resp)
    }
}