package org.github.windbird123.play.spa.client.navigo

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class Navigo(root: String, useHash: Boolean, hash: String) extends js.Any {
  def on(routes: js.Any): Navigo                                                   = js.native
  def on(path: String, fn: js.Function0[Unit]): Navigo                             = js.native
  def on(path: String, fn: js.Function1[js.Dictionary[Any], Unit]): Navigo         = js.native
  def on(path: String, fn: js.Function2[js.Dictionary[Any], String, Unit]): Navigo = js.native
  def resolve(): Unit                                                              = js.native

  def navigate(path: String): Unit                          = js.native
  def navigate(path: String, isAbsolutePath: Boolean): Unit = js.native
}
