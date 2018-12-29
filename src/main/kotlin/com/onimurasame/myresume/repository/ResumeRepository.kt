package com.onimurasame.myresume.repository

import com.onimurasame.myresume.data.Resume
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed
import org.springframework.data.couchbase.core.query.ViewIndexed
import org.springframework.data.couchbase.repository.CouchbaseRepository

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "resume")
interface ResumeRepository : CouchbaseRepository<Resume, Long> {

    fun findResumeByUserId(id: String): Resume
}