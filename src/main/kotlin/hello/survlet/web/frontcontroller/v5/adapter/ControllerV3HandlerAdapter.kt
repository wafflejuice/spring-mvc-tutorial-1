package hello.survlet.web.frontcontroller.v5.adapter

import hello.survlet.web.frontcontroller.ModelView
import hello.survlet.web.frontcontroller.v3.ControllerV3
import hello.survlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter : MyHandlerAdapter {
    override fun supports(handler: Any): Boolean {
        return handler is ControllerV3
    }

    override fun handle(req: HttpServletRequest?, resp: HttpServletResponse?, handler: Any): ModelView {
        handler as ControllerV3
        val paramMap = createParamMap(req)

        return handler.process(paramMap)
    }

    private fun createParamMap(req: HttpServletRequest?): MutableMap<String, String> {
        val paramMap = mutableMapOf<String, String>()
        req?.parameterNames?.asIterator()
            ?.forEachRemaining { paramMap[it] = req.getParameter(it) }
        return paramMap
    }
}