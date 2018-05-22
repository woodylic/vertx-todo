package com.github.woodylic.vertxtodo.services

import com.github.woodylic.vertxtodo.entities.Todo
import com.github.woodylic.vertxtodo.entities.TodoRepo
import com.sun.org.apache.xpath.internal.operations.Bool
import io.vertx.core.Future
import java.util.*

class TodoServceImpl(val todoRepo: TodoRepo) : TodoService {

  override fun create(todo: Todo): Future<Boolean> {
    val id = Todo.getIncId()
    todo.id = id
    todoRepo.save(todo)
    return Future<Boolean>(true)
  }

  override fun update(todo: Todo): Future<Boolean> {
    todoRepo.save(todo)
  }

  override fun getById(id: Int): Future<Optional<Todo>> {
    todoRepo.getById(id)
  }

  override fun getAll(): Future<Collection<Todo>> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteById(id: Int): Future<Boolean> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteAll(): Future<Boolean> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}
