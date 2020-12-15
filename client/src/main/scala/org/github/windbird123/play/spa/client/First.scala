package org.github.windbird123.play.spa.client

import org.scalajs.dom.document
import org.scalajs.dom.raw.HTMLInputElement

import scala.xml.Elem

object First {
  val content: Elem =
    <div>
          <h1>First</h1>

          <form class="ui form">
              <div class="field">
                  <label>search</label>
                  <input id="queryInput" type="text" name="query" placeholder="your query"/>
              </div>
              <button class="ui button" type="submit" onclick={ () => Main.queryPart := document.getElementById("queryInput").asInstanceOf[HTMLInputElement].value }>Submit</button>
          </form>

          <div>All query parts: {Main.queryPart}</div>
      </div>
}
