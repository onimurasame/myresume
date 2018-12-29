package com.onimurasame.myresume

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing

@SpringBootApplication
class MyresumeApplication

fun main(args: Array<String>) {
    runApplication<MyresumeApplication>(*args)
}
