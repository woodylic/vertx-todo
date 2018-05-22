package com.github.woodylic.vertxtodo

import com.github.woodylic.vertxtodo.web.SingleApplicationVerticle
import io.vertx.core.AbstractVerticle

class MainVerticle: AbstractVerticle() {
  override fun start() {
    vertx.deployVerticle(SingleApplicationVerticle::class.java.name)
  }
}
