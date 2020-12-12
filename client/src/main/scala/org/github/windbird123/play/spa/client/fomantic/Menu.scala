package org.github.windbird123.play.spa.client.fomantic

import org.querki.jquery.JQuery

import scala.scalajs.js

// native
@js.native
trait Menu extends JQuery {
  def tab(): Unit = js.native
}

object Menu {
  implicit def jq2menu(jq: JQuery): Menu = jq.asInstanceOf[Menu]
}
