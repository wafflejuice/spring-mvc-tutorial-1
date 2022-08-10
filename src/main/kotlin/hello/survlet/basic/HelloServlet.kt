package hello.survlet.basic

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/hello"])
class HelloServlet(

): HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.service(req, resp)
        println("HelloServlet.service")
    }
}