package hello.survlet.web.frontcontroller.v5.adapter

import hello.survlet.web.frontcontroller.ModelView
import hello.survlet.web.frontcontroller.v4.ControllerV4
import hello.survlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter : MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV4
    }

    override fun handle(req: HttpServletRequest?, resp: HttpServletResponse?, handler: Any): ModelView {
        handler as ControllerV4
        val paramMap = createParamMap(req)
        val model = mutableMapOf<String, Any>()

        val viewName = handler.process(paramMap, model)

        val modelView = ModelView(viewName)
        modelView.model = model

        return modelView
    }

    private fun createParamMap(req: HttpServletRequest?): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        req?.parameterNames?.asIterator()
            ?.forEachRemaining { paramMap[it] = req.getParameter(it) }
        return paramMap
    }
}