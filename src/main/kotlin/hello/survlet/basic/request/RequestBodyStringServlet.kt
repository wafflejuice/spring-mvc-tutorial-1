package hello.survlet.basic.request

import org.springframework.util.StreamUtils
import javax.servlet.ServletInputStream
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.text.Charsets.UTF_8

@WebServlet(name = "requestBodyStringServlet", urlPatterns = ["/request-body-string"])
class RequestBodyStringServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val inputStream: ServletInputStream? = req?.inputStream
        val messageBody: String = StreamUtils.copyToString(inputStream, UTF_8)

        println("messageBody = ${messageBody}")

        resp?.writer?.write("ok")
    }
}