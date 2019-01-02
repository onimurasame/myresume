package com.onimurasame.myresume.data

import com.couchbase.client.java.repository.annotation.Field
import com.couchbase.client.java.repository.annotation.Id
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy
import java.io.Serializable
import java.util.Date
import javax.validation.constraints.NotNull

@Document
data class Resume(
    @Id @Field @GeneratedValue(strategy = GenerationStrategy.UNIQUE) val resumeId: Long,
    @Field @NotNull val language: Language,
    @Field @NotNull val user: User,
    @Version @Field val version: Long?,
    @LastModifiedBy @Field val lastModifiedBy: String?,
    @LastModifiedDate @Field val lastModifiedDate: Date?,
    @CreatedBy @Field val createdBy: String?,
    @CreatedDate @Field val createdDate: Date?,
    @Field val sections: List<Section>
) : Serializable