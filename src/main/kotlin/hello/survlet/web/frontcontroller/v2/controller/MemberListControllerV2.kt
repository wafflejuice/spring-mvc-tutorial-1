package hello.survlet.web.frontcontroller.v2.controller

import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.MyView
import hello.survlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV2 : ControllerV2 {
    private val memberRepository = MemberRepository

    override fun process(req: HttpServletRequest?, resp: HttpServletResponse?): MyView {
        val members = memberRepository.findAll()
        req?.setAttribute("members", members)

        return MyView("/WEB-INF/views/members.jsp")
    }
}