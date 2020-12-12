package org.github.windbird123.play.spa.client

import mhtml._
import org.github.windbird123.play.spa.client.navigo.Navigo
import org.scalajs.dom.document

object Main {
  def main(args: Array[String]): Unit = {
    val body =
      <div>
          <h1>Hi!!</h1>
          <a href="/test">test go</a>
          </div>

    mount(document.body, body)

    val router = new Navigo(null, true, "#")
    router
      .on("/test", () => println("KKKKKK"))
      .resolve()
  }
}
