package hello.survlet.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import hello.survlet.basic.HelloData
import org.springframework.util.StreamUtils
import javax.servlet.ServletInputStream
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.text.Charsets.UTF_8

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet : HttpServlet() {
    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val inputStream: ServletInputStream? = req?.inputStream
        val messageBody: String = StreamUtils.copyToString(inputStream, UTF_8)
        println("messageBody = ${messageBody}")

        val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
        println("helloData = ${helloData}")
    }
}