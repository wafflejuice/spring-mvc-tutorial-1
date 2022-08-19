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

    fun render(model: MutableMap<String, Any>, req: HttpServletRequest?, resp: HttpServletResponse?) {
        modelToRequestAttribute(model, req)
        val dispatcher = req?.getRequestDispatcher(viewPath)
        dispatcher?.forward(req, resp)
    }

    private fun modelToRequestAttribute(
        model: MutableMap<String, Any>,
        req: HttpServletRequest?
    ) {
        model.forEach { (key, value) -> req?.setAttribute(key, value) }
    }
}