package hello.survlet.web.frontcontroller.v4

import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.survlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.survlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerServletV4 : HttpServlet() {
    private val controllerMap = mutableMapOf<String, ControllerV4>(
        "/front-controller/v4/members/new-form" to MemberFormControllerV4(),
        "/front-controller/v4/members/save" to MemberSaveControllerV4(),
        "/front-controller/v4/members" to MemberListControllerV4()
    )

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("FrontControllerServletV4.service")

        val controller = controllerMap[req?.requestURI]
        if (controller == null) {
            resp?.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val paramMap = createParamMap(req)
        val model = mutableMapOf<String, Any>()
        val viewName = controller.process(paramMap, model)

        val view = viewResolver(viewName)
        view.render(model, req, resp)
    }

    private fun viewResolver(viewName: String): MyView {
        return MyView("/WEB-INF/views/${viewName}.jsp")
    }

    private fun createParamMap(req: HttpServletRequest?): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        req?.parameterNames?.asIterator()
            ?.forEachRemaining { paramMap[it] = req.getParameter(it) }
        return paramMap
    }
}