/*
 * This file is only for debug from IDE.
 * The standard entry of this application is MainVerticle.
 */

package com.github.woodylic.vertxtodo

import io.vertx.core.Launcher

fun main(args: Array<String>) {
  System.setProperty(
    "vertx.logger-delegate-factory-class-name",
    "io.vertx.core.logging.SLF4JLogDelegateFactory")
  Launcher.executeCommand("run", MainVerticle::class.java.name)
}
