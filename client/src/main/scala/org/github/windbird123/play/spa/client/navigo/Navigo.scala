package org.github.windbird123.play.spa.client.navigo

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class Navigo(root: String, userHash: Boolean, hash: String) extends js.Any {
  def on(path: String, fn: js.Function0[Unit]): Navigo = js.native
  def resolve(): Unit                                  = js.native
}
