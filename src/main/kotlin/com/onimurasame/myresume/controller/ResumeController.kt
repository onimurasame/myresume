package com.onimurasame.myresume.controller

import com.onimurasame.myresume.data.Resume
import com.onimurasame.myresume.service.ResumeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/resume"])
class ResumeController {

    @Autowired
    private lateinit var resumeService: ResumeService

    @GetMapping(path = ["/{userId}"])
    fun getResumeByName(@PathVariable("userId") userId: String): ResponseEntity<Resume> {
        return ResponseEntity(resumeService.getResumeByUserId(userId), HttpStatus.OK)
    }
}