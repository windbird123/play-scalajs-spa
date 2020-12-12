package org.github.windbird123.play.spa.client.fomantic

import org.querki.jquery.JQuery

import scala.scalajs.js

// native
@js.native
trait Dropdown extends JQuery {
  def dropdown(): Unit = js.native
}

object Dropdown {
  implicit def jq2dropdown(jq: JQuery): Dropdown = jq.asInstanceOf[Dropdown]
}
