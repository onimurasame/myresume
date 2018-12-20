package com.onimurasame.myresume.repository

import com.onimurasame.myresume.data.Resume
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ResumeRepository : CrudRepository<Resume, Long> {

    fun findResumeByUserId(userId: String): Resume

}