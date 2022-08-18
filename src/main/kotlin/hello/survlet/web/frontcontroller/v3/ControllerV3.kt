package hello.survlet.web.frontcontroller.v3

import hello.survlet.web.frontcontroller.ModelView

interface ControllerV3 {
    fun process(paramMap: Map<String, String>): ModelView
}