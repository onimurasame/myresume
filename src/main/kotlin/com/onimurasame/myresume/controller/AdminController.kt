package com.onimurasame.myresume.controller

import com.google.gson.Gson
import com.onimurasame.myresume.data.Resume
import com.onimurasame.myresume.repository.ResumeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/admin"])
class AdminController {

    private val gson: Gson = Gson()

    @Autowired
    private lateinit var resumeRepository: ResumeRepository

    @PostMapping
    fun addResume(resume: Resume): ResponseEntity<String> {
        val savedResume: Resume = resumeRepository.save(resume)
        return ResponseEntity(gson.toJson(savedResume), HttpStatus.CREATED)
    }

}