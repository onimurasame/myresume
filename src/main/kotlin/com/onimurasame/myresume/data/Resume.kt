package com.onimurasame.myresume.data

import com.couchbase.client.java.repository.annotation.Field
import com.couchbase.client.java.repository.annotation.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Immutable
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy
import java.io.Serializable
import java.util.Date
import javax.persistence.Version
import javax.validation.constraints.NotNull

@Document
@Immutable
data class Resume(
        @Id @Field @GeneratedValue(strategy = GenerationStrategy.UNIQUE) val resumeId: Long,
        @Field @NotNull val user: User,
        @Version val version: Long,
        @LastModifiedDate val lastModifiedDate: Date,
        @CreatedDate val createdDate: Date,
        @Field val sections: List<Section>
) : Serializable

@Document
data class User(
    @Id val id: String,
    @Field @NotNull val firstName: String,
    @Field val middleName: String,
    @Field @NotNull val lastName: String
)

@Document
data class Section(
    @Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE) val id: Long,
    @Field @NotNull val name: String,
    @Field val data: Map<String, kotlin.Any>
)