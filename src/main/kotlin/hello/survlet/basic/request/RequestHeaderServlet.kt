package hello.survlet.basic.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet: HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        printStartLine(req)
        printHeaders(req)
    }

    private fun printStartLine(req: HttpServletRequest?) {
        println("req.method = ${req?.method}")
        println("req.protocol = ${req?.protocol}")
        println("req.scheme = ${req?.scheme}")
        println("req.requestURL = ${req?.requestURL}")
        println("req.requestURI = ${req?.requestURI}")
        println("req.queryString = ${req?.queryString}")
        println("req.isSecure = ${req?.isSecure}")
    }

    private fun printHeaders(req: HttpServletRequest?) {
        req?.headerNames?.asIterator()?.forEachRemaining {
            println("headerName = ${it}")
        }
    }
}