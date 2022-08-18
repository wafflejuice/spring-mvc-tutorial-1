package hello.survlet.web.frontcontroller.v3.controller

import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.ModelView
import hello.survlet.web.frontcontroller.v3.ControllerV3

class MemberListControllerV3 : ControllerV3 {
    private val memberRepository = MemberRepository

    override fun process(paramMap: Map<String, String>): ModelView {
        val members = memberRepository.findAll()
        val mv = ModelView("members")
        mv.model.put("members", members)

        return mv
    }
}