package com.onimurasame.myresume.repository

import com.onimurasame.myresume.data.Section
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed
import org.springframework.data.couchbase.core.query.ViewIndexed
import org.springframework.data.couchbase.repository.CouchbaseRepository

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "section")
interface SectionRepository : CouchbaseRepository<Section, Long>