package org.acme.data.repositories

import jakarta.enterprise.context.ApplicationScoped
import org.acme.domain.abstract_repositories.ITodoRepository

@ApplicationScoped
class TodoRepository : ITodoRepository