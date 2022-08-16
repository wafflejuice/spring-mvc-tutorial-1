package hello.survlet.web.frontcontroller.v1.controller

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV1 : ControllerV1 {
    private val memberRepository = MemberRepository

    override fun process(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val username = req?.getParameter("username")
        val age = req?.getParameter("age")?.toIntOrNull()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        //Model에 데이터를 보관한다.
        req.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, resp)
    }
}