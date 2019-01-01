package com.onimurasame.myresume.data

import com.couchbase.client.java.repository.annotation.Field
import com.couchbase.client.java.repository.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy
import javax.validation.constraints.NotNull

@Document
data class Section(
    @Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE) val id: Long,
    @Field @NotNull val name: String,
    @Field val data: Map<String, kotlin.Any>
)