package com.egstep.code.part.com.controller

import com.egstep.code.entity.ComUserMst
import com.egstep.code.part.com.service.UserService
import com.egstep.code.part.sam.service.OneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired lateinit var service: UserService

    @GetMapping
    fun getUsers(): List<ComUserMst> {
        return service.getUsers()
    }

}
