package com.onimurasame.myresume.controller

import com.google.gson.Gson
import com.onimurasame.myresume.data.Resume
import com.onimurasame.myresume.service.ResumeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/admin"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
class AdminController {

    private val gson: Gson = Gson()

    @Autowired
    private lateinit var resumeService: ResumeService

    @PostMapping
    fun addResume(@RequestBody resume: Resume): ResponseEntity<Resume> {
        return ResponseEntity(resumeService.addResume(resume), HttpStatus.CREATED)
    }
}