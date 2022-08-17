package hello.survlet.web.frontcontroller.v2.controller

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV2 : ControllerV2 {
    private val memberRepository = MemberRepository

    override fun process(req: HttpServletRequest?, resp: HttpServletResponse?): MyView {
        val username = req?.getParameter("username")
        val age = req?.getParameter("age")?.toIntOrNull()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        //Model에 데이터를 보관한다.
        req.setAttribute("member", member)

        return MyView("/WEB-INF/views/save-result.jsp")
    }
}