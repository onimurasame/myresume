package com.onimurasame.myresume.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories
import org.springframework.data.domain.AuditorAware
import java.util.Optional

@Configuration
@EnableCouchbaseAuditing(auditorAwareRef = "auditorAware")
@EnableCouchbaseRepositories(basePackages = ["com.onimurasame.myresume.repository"])
class CouchbaseAuditConfiguration : AbstractCouchbaseConfiguration() {

    @Value("\${spring.couchbase.bootstrap-hosts}")
    private lateinit var bootstrapHosts: MutableList<String>

    @Value("\${spring.couchbase.bucket.name}")
    private lateinit var bucketName: String

    @Value("\${spring.couchbase.bucket.password}")
    private lateinit var bucketPassword: String

    /**
     * The password of the bucket (can be an empty string).
     *
     * @return the password of the bucket.
     */
    override fun getBucketPassword(): String {
        return bucketPassword
    }

    /**
     * The name of the bucket to connect to.
     *
     * @return the name of the bucket.
     */
    override fun getBucketName(): String {
        return bucketName
    }

    /**
     * The list of hostnames (or IP addresses) to bootstrap from.
     *
     * @return the list of bootstrap hosts.
     */
    override fun getBootstrapHosts(): MutableList<String> {
        return bootstrapHosts
    }

    @Bean
    fun auditorAware(): AuditorAware<String> {
        return AuditorAware { Optional.of("Unknown") }
    }
}