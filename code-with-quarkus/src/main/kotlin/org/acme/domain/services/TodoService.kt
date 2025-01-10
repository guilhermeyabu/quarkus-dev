package org.acme.domain.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.acme.domain.abstract_repositories.ITodoRepository
import org.acme.domain.entities.Todo

@ApplicationScoped
class TodoService(private val repository: ITodoRepository) {

    fun getAllTodos(): List<Todo> = repository.listAll()

    fun getTodoById(id: String): Todo? = repository.findById(id)

    @Transactional
    fun createTodo(todo: Todo): Todo {
        repository.persist(todo)
        return todo
    }

    @Transactional
    fun updateTodo(id: String, updatedTodo: Todo): Todo? {
        val existingTodo = repository.findById(id) ?: return null
        existingTodo.title = updatedTodo.title
        existingTodo.description = updatedTodo.description
        existingTodo.completed = updatedTodo.completed
        return existingTodo
    }

    @Transactional
    fun deleteTodoById(id: String): Boolean {
        return repository.deleteById(id)
    }
}