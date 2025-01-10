package org.acme.domain.entities

import jakarta.persistence.*
import kotlinx.serialization.Serializable
import org.hibernate.annotations.UuidGenerator

@Entity
@Table(name = "todos")
@Serializable
data class Todo(
    @Id
    @UuidGenerator
    val id: String? = null,

    @Column(nullable = false)
    var title: String = "",

    var description: String? = null,

    @Column(nullable = false)
    var completed: Boolean = false
)