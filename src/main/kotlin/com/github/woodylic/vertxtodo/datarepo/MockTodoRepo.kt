package com.github.woodylic.vertxtodo.datarepo

import com.github.woodylic.vertxtodo.entities.Todo
import com.github.woodylic.vertxtodo.entities.TodoRepo

class MockTodoRepo : TodoRepo {

  private val todoMap = HashMap<Int, Todo>()

  override fun save(todo: Todo) {
    todoMap[todo.id] = todo
  }

  override fun getById(id: Int): Todo {
    return todoMap[id]!!
  }

  override fun getAll(): Collection<Todo> {
    return todoMap.values
  }

  override fun deleteById(id: Int) {
    todoMap.remove(id)
  }

  override fun deleteAll() {
    todoMap.clear()
  }
}
