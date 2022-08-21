package hello.survlet.web.frontcontroller.v4.controller

import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.v4.ControllerV4

class MemberListControllerV4 : ControllerV4 {

    private val memberRepository = MemberRepository

    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {

        val members = memberRepository.findAll()

        model["members"] = members

        return "members"
    }
}