package hello.survlet.web.frontcontroller.v3.controller

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.ModelView
import hello.survlet.web.frontcontroller.v3.ControllerV3

class MemberSaveControllerV3 : ControllerV3 {
    private val memberRepository = MemberRepository

    override fun process(paramMap: Map<String, String>): ModelView {
        val username = paramMap["username"]
        val age = paramMap["age"]?.toInt()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        val mv = ModelView("save-result")
        mv.model["member"] = member as Any
        return mv
    }
}