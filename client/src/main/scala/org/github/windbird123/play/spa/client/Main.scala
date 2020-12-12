package org.github.windbird123.play.spa.client

import mhtml._
import org.scalajs.dom.document

object Main {
    def main(args: Array[String]): Unit = {
      val body =
          <div>
          <h1>Hi!!</h1>
          </div>

      mount(document.body, body)
    }
}
