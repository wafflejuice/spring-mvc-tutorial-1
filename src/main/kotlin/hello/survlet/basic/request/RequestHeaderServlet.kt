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
        printHeaderUtils(req)
        printEtc(req)
    }

    private fun printStartLine(req: HttpServletRequest?) {
        println("--- REQUEST-LINE - start ---")

        println("req?.method = ${req?.method}")
        println("req?.protocol = ${req?.protocol}")
        println("req?.scheme = ${req?.scheme}")
        println("req?.requestURL = ${req?.requestURL}")
        println("req?.requestURI = ${req?.requestURI}")
        println("req?.queryString = ${req?.queryString}")
        println("req?.isSecure = ${req?.isSecure}")

        println("--- REQUEST-LINE - end ---")
        println()
    }

    private fun printHeaders(req: HttpServletRequest?) {
        println("--- Headers - start ---")

        req?.headerNames?.asIterator()?.forEachRemaining { println(it) }

        println("req?.getHeader(\"host\")} = ${req?.getHeader("host")}")

        println("--- Headers - end ---")
        println()
    }

    private fun printHeaderUtils(req: HttpServletRequest?) {
        println("--- Header Utils - start ---")

        println("[Host 편의 조회]")
        println("req?.serverName = ${req?.serverName}")
        println("req?.serverPort = ${req?.serverPort}")
        println()

        println("[Accept-Language 편의 조회]")
        req?.locales?.asIterator()?.forEachRemaining { println("locale = ${it}") }
        println("req?.locale = ${req?.locale}")
        println()

        println("[cookie 편의 조회]")
        req?.cookies?.forEach { println("${it.name} : ${it.value}") }
        println()

        println("[Content 편의 조회]")
        println("req?.contentType = ${req?.contentType}")
        println("req?.contentLength = ${req?.contentLength}")
        println("req?.characterEncoding = ${req?.characterEncoding}")

        println("--- Header Utils - end ---")
        println()
    }


    private fun printEtc(req: HttpServletRequest?) {
        println("--- etc - start ---")

        println("[Remote 정보]")
        println("req?.remoteHost = ${req?.remoteHost}")
        println("req?.remoteAddr = ${req?.remoteAddr}")
        println("req?.remotePort = ${req?.remotePort}")
        println()

        println("[Local 정보]")
        println("req?.localName = ${req?.localName}")
        println("req?.localAddr = ${req?.localAddr}")
        println("req?.localPort = ${req?.localPort}")

        println("--- etc - end ---")
        println()
    }
}