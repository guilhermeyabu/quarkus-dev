package org.acme.domain.abstract_repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import org.acme.domain.entities.Todo

@ApplicationScoped
interface ITodoRepository : PanacheRepositoryBase<Todo, String>