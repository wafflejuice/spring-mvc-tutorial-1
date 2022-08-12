package hello.survlet.basic.response

import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ResponseHeaderServlet : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        //[status-line]
        resp?.status = HttpServletResponse.SC_OK

        //[response-headers]
        //resp?.setHeader("Content-Type", "text/plain;charset=utf-8")
        resp?.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        resp?.setHeader("Pragma", "no-cache")
        resp?.setHeader("my-header", "hello")

        //[Header 편의 메서드]
        content(resp)
        cookie(resp)
        redirect(resp)

        //[message body]
        resp?.writer?.print("ok")
    }

    private fun content(resp: HttpServletResponse?) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //resp?.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp?.contentType = "text/plain"
        resp?.characterEncoding = "utf-8"
        //resp?.setContentLength(2); //(생략시 자동 생성)
    }

    private fun cookie(resp: HttpServletResponse?) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //resp?.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        val cookie = Cookie("myCookie", "good")
        cookie.maxAge = 600 //600초
        resp?.addCookie(cookie)
    }

    private fun redirect(resp: HttpServletResponse?) {
        //Status Code 302
        //Location: /basic/hello-form.html
        //resp?.status = HttpServletResponse.SC_FOUND; //302
        //resp?.setHeader("Location", "/basic/hello-form.html");
        resp?.sendRedirect("/basic/hello-form.html")
    }
}