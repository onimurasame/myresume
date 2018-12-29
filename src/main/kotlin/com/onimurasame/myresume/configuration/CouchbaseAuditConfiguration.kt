package com.onimurasame.myresume.configuration

import com.onimurasame.myresume.data.ResumeAuditor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing

@Configuration
@EnableCouchbaseAuditing
class CouchbaseAuditConfiguration {

    @Bean
    fun auditorAware(): ResumeAuditor {
        return ResumeAuditor()
    }
}