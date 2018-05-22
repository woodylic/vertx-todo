package com.github.woodylic.vertxtodo.web

import com.github.woodylic.vertxtodo.datarepo.MockTodoRepo
import com.github.woodylic.vertxtodo.entities.Todo
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.http.HttpServerResponse
import io.vertx.core.logging.LoggerFactory
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.core.json.Json

class SingleApplicationVerticle: AbstractVerticle() {
  private val logger = LoggerFactory.getLogger(javaClass)

  private val HTTP_PORT = 8082

  override fun start(future: Future<Void>) {
    val router = Router.router(vertx)

    router.route().handler(BodyHandler.create())

    router.get(Constants.API_GET).handler({ctx -> handleGetById(ctx)})
    router.get(Constants.API_GET_ALL).handler({ctx -> handleGetAll(ctx)})
    router.post(Constants.API_CREATE).handler({ctx -> handleCreate(ctx)})
//    router.put(Constants.API_UPDATE).handler({ctx -> handleUpdate(ctx)})
//    router.delete(Constants.API_DELETE).handler({ctx -> handleDeleteById(ctx)})
//    router.delete(Constants.API_DELETE_ALL).handler({ctx -> handleDeleteAll(ctx)})

    vertx.createHttpServer()
      .requestHandler({req -> router.accept(req)})
      .listen(HTTP_PORT, { result ->
        if(result.succeeded())
          future.complete()
        else
          future.fail(result.cause())
      })
  }

  private val todoRepo = MockTodoRepo()

  private fun sendError(statusCode: Int, response: HttpServerResponse) {
    response.setStatusCode(statusCode).end()
  }

//  private fun wrapObject(todo: Todo, context: RoutingContext): Todo {
//    val id = todo.id
//    if (id > Todo.getIncId()) {
//      Todo.setIncIdWith(id)
//    } else if (id == 0)
//      todo.setIncId()
//    todo.url = context.request().absoluteURI() + "/" + todo.id
//    return todo
//  }

  private fun handleGetById(context: RoutingContext) {
    val todoID = context.request().getParam("id") // (1)
    if (todoID == null)
      sendError(400, context.response()) // (2)
    else {
      val todo = todoRepo.getById(todoID.toInt())
      context.response()
        .putHeader("content-type", "application/json")
        .end(todo)
    }
  }

  private fun handleGetAll(context: RoutingContext) {
    return todoRepo.getAll()
  }

  private fun handleCreate(context: RoutingContext) {
    val todo = wrapObject(Todo(context.bodyAsString), context)
    val encoded = Json.encodePrettily(todo)
    todoRepo.save(todo)
  }

//  private fun handleUpdate(context: RoutingContext) {
//
//  }
//
//  private fun handleDeleteById(context: RoutingContext) {
//
//  }
//
//  private fun handleDeleteAll(context: RoutingContext) {
//
//  }
}
