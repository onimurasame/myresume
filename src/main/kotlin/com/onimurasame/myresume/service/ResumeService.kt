package com.onimurasame.myresume.service

import com.onimurasame.myresume.data.Resume
import com.onimurasame.myresume.repository.ResumeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service

@Service
class ResumeService {

    @Autowired
    private lateinit var resumeRepository: ResumeRepository

    @Autowired
    private lateinit var userService: UserService

    fun getResumeByUserId(id: String): Resume? {
        try {
            return resumeRepository.findResumeByUserId(id)
        } catch (e: EmptyResultDataAccessException) {
            return null
        }
    }

    fun addResume(resume: Resume): Resume {
        userService.addUser(resume.user)
        return resumeRepository.save(resume)
    }
}