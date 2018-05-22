package com.github.woodylic.vertxtodo.services

import com.github.woodylic.vertxtodo.entities.Todo
import io.vertx.core.Future
import java.util.*


interface TodoService {
  fun create(todo: Todo): Future<Boolean>
  fun update(todo: Todo): Future<Boolean>
  fun getById(id: Int): Future<Optional<Todo>>
  fun getAll(): Future<Collection<Todo>>
  fun deleteById(id: Int): Future<Boolean>
  fun deleteAll(): Future<Boolean>
}
