package com.github.woodylic.vertxtodo.web

import com.github.woodylic.vertxtodo.services.TodoService
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class TodoVerticle(val todoService: TodoService): AbstractVerticle() {

  override fun start(future: Future<Void>) {

  }
}
