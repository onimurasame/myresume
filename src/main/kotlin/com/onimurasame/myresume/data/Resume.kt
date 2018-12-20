package com.onimurasame.myresume.data

import org.hibernate.annotations.CreationTimestamp
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "Resumes")
data class Resume(
        @Id
        @Column(name = "id", updatable = false, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @OneToOne
        val user: User,
        val version: Int,
        @CreationTimestamp
        val createdOn: LocalDateTime,
        @OneToMany
        val sections: List<Section>
) : Serializable

@Entity
@Table(name = "Users")
data class User(
        @Id
        val id: String,
        val firstName: String,
        val middleName: String,
        val lastName: String
)

@Entity
@Table(name = "Sections")
data class Section(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val name: String,
        @ElementCollection
        @JoinTable(name = "Section_data", joinColumns = [JoinColumn(name = "SECTION_ID")])
        @MapKeyColumn(name = "KEY")
        @Column(name = "VALUE")
        val data: Map<String, String>
)