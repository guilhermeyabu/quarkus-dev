package org.acme.resources

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.acme.domain.entities.Todo
import org.acme.domain.services.TodoService

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TodoResource(private val service: TodoService) {

    @GET
    fun getAllTodos(): List<Todo> = service.getAllTodos()

    @GET
    @Path("/{id}")
    fun getTodoById(@PathParam("id") id: String): Response {
        val todo = service.getTodoById(id)
        return if (todo != null) Response.ok(todo).build() else Response.status(Response.Status.NOT_FOUND).build()
    }

    @POST
    fun createTodo(todo: Todo): Response {
        val createdTodo = service.createTodo(todo)
        return Response.status(Response.Status.CREATED).entity(createdTodo).build()
    }

    @PUT
    @Path("/{id}")
    fun updateTodo(@PathParam("id") id: String, updatedTodo: Todo): Response {
        val todo = service.updateTodo(id, updatedTodo)
        return if (todo != null) Response.ok(todo).build() else Response.status(Response.Status.NOT_FOUND).build()
    }

    @DELETE
    @Path("/{id}")
    fun deleteTodoById(@PathParam("id") id: String): Response {
        return if (service.deleteTodoById(id)) Response.noContent().build() else Response.status(Response.Status.NOT_FOUND).build()
    }
}