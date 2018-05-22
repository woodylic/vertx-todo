package com.github.woodylic.vertxtodo.entities

import java.util.concurrent.atomic.AtomicInteger

data class Todo(
  var id: Int,
  var title: String,
  var completed: Boolean,
  var order: Int,
  var url: String) {

  companion object {
    private val acc = AtomicInteger(0)

    fun getIncId(): Int {
      return acc.incrementAndGet()
    }
  }
}
