package com.egstep.code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/my")
class MyController {

    @Autowired lateinit var service: OneService

    @GetMapping
    fun main(): ModelAndView {
        val mv = ModelAndView()
        mv.viewName = "abc"

        mv.addObject("user", User(name="zany"))

        return mv
    }

}

data class User(
    val name: String
)
