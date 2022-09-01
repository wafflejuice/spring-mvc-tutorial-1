package hello.survlet.web.springmvc.v1

import hello.survlet.domain.member.Member
import hello.survlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class SpringMemberSaveControllerV1 {
    val memberRepository = MemberRepository

    @RequestMapping("/springmvc/v1/members/save")
    fun process(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val username = request.getParameter("username")
        val age = request.getParameter("age")?.toInt()

        val member = Member(username = username!!, age = age!!)
        memberRepository.save(member)

        val modelAndView = ModelAndView("save-result")
        modelAndView.addObject("member", member)

        return modelAndView
    }
}