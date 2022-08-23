package hello.survlet.web.frontcontroller.v5

import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v3.controller.MemberFormControllerV3
import hello.survlet.web.frontcontroller.v3.controller.MemberListControllerV3
import hello.survlet.web.frontcontroller.v3.controller.MemberSaveControllerV3
import hello.survlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.survlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.survlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import hello.survlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter
import hello.survlet.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServletV5 : HttpServlet() {

    val handlerMappingMap = mutableMapOf<String, Any>()
    val handlerAdapters = mutableListOf<MyHandlerAdapter>()

    init {
        initHandlerMappingMap()
        initHandlerAdapters()
    }

    fun initHandlerMappingMap() {
        handlerMappingMap["/front-controller/v5/v3/members/new-form"] = MemberFormControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members/save"] = MemberSaveControllerV3()
        handlerMappingMap["/front-controller/v5/v3/members"] = MemberListControllerV3()

        handlerMappingMap["/front-controller/v5/v4/members/new-form"] = MemberFormControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members/save"] = MemberSaveControllerV4()
        handlerMappingMap["/front-controller/v5/v4/members"] = MemberListControllerV4()
    }

    private fun initHandlerAdapters() {
        handlerAdapters.add(ControllerV3HandlerAdapter())
        handlerAdapters.add(ControllerV4HandlerAdapter())
    }

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val handler = getHandler(req)
        if (handler == null) {
            resp?.status = HttpServletResponse.SC_NOT_FOUND
            return
        }

        val adapter = handlerAdapters.find { it.supports(handler) }
            ?: throw IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=${handler}")

        val modelView = adapter.handle(req, resp, handler)

        val view = viewResolver(modelView.viewName)
        view.render(modelView.model, req, resp)
    }

    fun getHandler(req: HttpServletRequest?): Any? {
        return handlerMappingMap[req?.requestURI]
    }

    private fun viewResolver(viewName: String): MyView {
        return MyView("/WEB-INF/views/${viewName}.jsp")
    }
}