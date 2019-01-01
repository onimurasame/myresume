package com.onimurasame.myresume.repository

import com.onimurasame.myresume.data.User
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed
import org.springframework.data.couchbase.core.query.ViewIndexed
import org.springframework.data.couchbase.repository.CouchbaseRepository

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "user")
interface UserRepository : CouchbaseRepository<User, String>