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

    def menu() =
        <div>
            <div class="ui top attached inverted menu">
                <div class="header item" >Brand</div>
                {
                tab.map { tabName =>
                    val prop = if (tabName == "first") "item active" else "item"
                    <div class={prop} data-tab="first" onclick={() => router.navigate("first")}>First</div>
                }

                }

                {
                tab.map { tabName =>
                    val prop = if (tabName == "second") "item active" else "item"
                    <div class={prop} data-tab="second" onclick={() => router.navigate("second")}>Second</div>
                }

                }

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
                {
                tab.map { tabName =>
                    val prop =
                        if (tabName == "first") "ui bottom attached tab segment active" else "ui bottom attached tab segment"
                    <div class={prop} data-tab="first">
                        <h1>First</h1>
                    </div>
                }
                }


                {
                tab.map { tabName =>
                    val prop =
                        if (tabName == "second") "ui bottom attached tab segment active" else "ui bottom attached tab segment"
                    <div class={prop} data-tab="second">
                        <h1>Second</h1>
                    </div>
                }
                }

            </div>
        </div>

    val body =
      <div>
            {menu()}
        </div>

    mount(document.body, body)

    // 주의: 아래 dropdown() 대상이 되는 $(".ui .dropdown") 이 Var 값(tab) 에 의해 다시 그려지지 않도록 해야 한다.
    import org.github.windbird123.play.spa.client.fomantic.Dropdown._
    $(".ui .dropdown").dropdown()
  }
}
