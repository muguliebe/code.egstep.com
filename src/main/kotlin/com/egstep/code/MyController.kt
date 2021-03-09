package com.egstep.code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/my")
class MyController {

    @Autowired lateinit var service: OneService
    @Autowired lateinit var ctx: ApplicationContext

    @GetMapping
    fun main(): ModelAndView {
        val mv = ModelAndView()
        mv.viewName = "abc"

        mv.addObject("user", User(name="zany"))

        return mv
    }

    @GetMapping("/beans")
    fun beans(): ModelAndView {
        val mv = ModelAndView()
        mv.viewName = "beans"

        val result = arrayListOf<String>()
        for(beanName:String in ctx.beanDefinitionNames) {
            result.add(beanName)
        }
        mv.addObject("beans", result)
        println("result = ${result}")
        return mv
    }

}

data class User(
    val name: String
)

data class Bean(
    val idx: Int,
    val name: String
)
