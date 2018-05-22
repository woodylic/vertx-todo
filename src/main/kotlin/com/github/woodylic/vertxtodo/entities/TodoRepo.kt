package com.github.woodylic.vertxtodo.entities

interface TodoRepo {
  fun save(todo: Todo)

  fun getById(id: Int): Todo

  fun getAll(): Collection<Todo>

  fun deleteById(id: Int)

  fun deleteAll()
}
