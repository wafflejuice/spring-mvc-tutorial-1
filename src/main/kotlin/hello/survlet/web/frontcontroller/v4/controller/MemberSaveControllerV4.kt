package hello.survlet.web.frontcontroller.v4.controller

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import hello.survlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4 : ControllerV4 {

    private val memberRepository = MemberRepository

    override fun process(paramMap: Map<String, String>, model: MutableMap<String, Any>): String {
        val username = paramMap["username"]
        val age = paramMap["age"]?.toInt()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        model["member"] = member

        return "save-result"
    }
}