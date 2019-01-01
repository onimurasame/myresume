package com.onimurasame.myresume.data

import com.couchbase.client.java.repository.annotation.Field
import com.couchbase.client.java.repository.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import javax.validation.constraints.NotNull

@Document
data class User(
    @Id val id: String,
    @Field @NotNull val firstName: String,
    @Field val middleName: String,
    @Field @NotNull val lastName: String
)