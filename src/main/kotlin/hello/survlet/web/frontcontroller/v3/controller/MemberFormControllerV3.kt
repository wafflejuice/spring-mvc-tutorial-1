package hello.survlet.web.frontcontroller.v3.controller

import hello.survlet.web.frontcontroller.ModelView
import hello.survlet.web.frontcontroller.v3.ControllerV3

class MemberFormControllerV3 : ControllerV3 {
    override fun process(paramMap: Map<String, String>): ModelView {
        return ModelView("new-form")
    }
}