package hello.survlet.web.frontcontroller.v3

import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import hello.survlet.web.frontcontroller.v3.controller.MemberListControllerV3
import hello.survlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerServletV3 : HttpServlet() {
    private val controllerMap = mutableMapOf<String, ControllerV3>(
        "/front-controller/v3/members/new-form" to MemberFormControllerV3(),
        "/front-controller/v3/members/save" to MemberSaveControllerV3(),
        "/front-controller/v3/members" to MemberListControllerV3()
    )

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("FrontControllerServletV3.service")

        val controller = controllerMap[req?.requestURI]
        if (controller == null) {
            resp?.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val paramMap = createParamMap(req)
        val modelView = controller.process(paramMap)

        val view = viewResolver(modelView.viewName)
        view.render(modelView.model, req, resp)
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