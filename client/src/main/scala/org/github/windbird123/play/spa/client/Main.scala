package org.github.windbird123.play.spa.client

import mhtml._
import org.github.windbird123.play.spa.client.navigo.Navigo
import org.querki.jquery.$
import org.scalajs.dom.raw.{ HTMLElement, HTMLLinkElement }
import org.scalajs.dom.{ document, Event }

import scala.scalajs.js

object Main {
  def main(args: Array[String]): Unit = {
    val defaultTab = "first"
    val tab        = Var(defaultTab)

    val router = new Navigo("/", false, "#")

    router
      .on(":tab", (params: js.Dictionary[Any]) => tab := params.get("tab").map(_.toString).getOrElse(defaultTab))
      .resolve()

    def menu(selectedTab: String) = {
        <div>
            <div class="ui top attached inverted menu">
                <div class="header item" >Brand</div>
                <div class={if (selectedTab == "first") "item active" else "item"} data-tab="first" onclick={ () => tab := "first" }>First</div>
                <div class={if (selectedTab == "second") "item active" else "item"} data-tab="second" onclick={ () => tab := "second" }>Second</div>
                <div class={if (selectedTab == "third") "item active" else "item"} data-tab="third" onclick={ () => tab := "third" }>Third</div>

                <div class="ui dropdown item" tabindex="0">
                    Dropdown
                    <i class="dropdown icon"></i>
                    <div class="menu transition hidden" tabindex="-1">
                        <div class="item">Action</div>
                        <div class="item">Another Action</div>
                        <div class="item">Something else here</div>
                        <div class="divider"></div>
                        <div class="item">Separated Link</div>
                        <div class="divider"></div>
                        <div class="item">One more separated link</div>
                    </div>
                </div>
                <div class="right menu">
                    <div class="item">
                        <div class="ui transparent inverted icon input">
                            <i class="search icon"></i>
                            <input type="text" placeholder="Search"/>
                        </div>
                    </div>
                    <a class="item">Link</a>
                </div>
            </div>

            <div>
                <div class={ if (selectedTab == "first") "ui bottom attached tab segment active" else "ui bottom attached tab segment" } data-tab="first">
                    <h1>First</h1>
                </div>
                <div class={ if (selectedTab == "second") "ui bottom attached tab segment active" else "ui bottom attached tab segment" } data-tab="second">
                    <h1>Second</h1>
                </div>
                <div class={ if (selectedTab == "third") "ui bottom attached tab segment active" else "ui bottom attached tab segment" } data-tab="third">
                    <h1>Third</h1>
                </div>
            </div>

            <div id="test"></div>


        </div>

    }

    val body =
        <div>
            {tab.map(menu)}
        </div>

    mount(document.body, body)


      val sc = {
        tab.map { _ =>
            import org.github.windbird123.play.spa.client.fomantic.Dropdown._
            $(".ui .dropdown").dropdown()
            <div></div>
        }
      }

      val test = document.getElementById("test")
    mount(test, sc)

  }
}
