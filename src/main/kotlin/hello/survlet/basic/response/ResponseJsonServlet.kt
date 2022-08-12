package hello.survlet.basic.response

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import hello.survlet.basic.HelloData
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
    private val objectMapper = jacksonObjectMapper()

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        //Content-Type: application/json
        resp?.contentType = "application/json"
        resp?.characterEncoding = "utf-8"

        val helloData = HelloData(username = "kim", age = 20)
        val result = objectMapper.writeValueAsString(helloData)
        resp?.writer?.write(result)
    }
}