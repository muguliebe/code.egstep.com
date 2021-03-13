package com.egstep.code.part.com.controller

import com.egstep.code.entity.ComUserMst
import com.egstep.code.repo.jpa.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired lateinit var repo: UserRepo

    @GetMapping
    fun getUsers(): List<ComUserMst> {
        return repo.findAll(PageRequest.of(0, 10)).toList()
    }
}
