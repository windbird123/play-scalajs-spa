package org.github.windbird123.play.spa.client

import mhtml._
import org.github.windbird123.play.spa.client.navigo.Navigo
import org.querki.jquery.$
import org.scalajs.dom.document

import scala.scalajs.js
import scala.xml.Node

object Main {
  val defaultTab: String       = "first"
  val selectedTab: Var[String] = Var(defaultTab)
  val queryPart: Var[String]   = Var("")

  def main(args: Array[String]): Unit = {
    val router = new Navigo("/", false, "#")

    // 위의 facade 이용 대신에 아래와 같이 하는 것도 가능 !!!
    // val router = js.Dynamic.newInstance(js.Dynamic.global.Navigo)("/", false, "#")
    router
      .on(
        ":tab",
        (params: js.Dictionary[Any], q: String) => {
          selectedTab := params.get("tab").map(_.toString).getOrElse(defaultTab)
          queryPart := q
        }
      )
      .resolve()

    def createMenuItem(name: String) = selectedTab.map { tabName =>
      val prop = if (tabName == name) "item active" else "item"
      <div class={prop} data-tab={name} onclick={() => router.navigate({ name }); ()}>{name}</div>
    }

    def createTabSegment(name: String)(node: Node) = selectedTab.map { tabName =>
      val prop = if (tabName == name) "ui bottom attached tab segment active" else "ui bottom attached tab segment"
      <div class={prop} data-tab={name}> {node} </div>
    }

    def menu() =
      <div>
            <div class="ui top attached inverted menu">
                <div class="header item" >Brand</div>
                {createMenuItem("first")}
                {createMenuItem("second")}
                {createMenuItem("third")}

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
                {createTabSegment("first")(<div>{First.content}</div>)}
                {createTabSegment("second")(<div>Second</div>)}
                {createTabSegment("third")(<div>Third</div>)}
            </div>
        </div>

    val body =
      <div>
            {menu()}
        </div>

    mount(document.body, body)

    // 주의: 아래 dropdown() 대상이 되는 $(".ui .dropdown") 이 Var 값(tab) 에 의해 다시 그려지지 않도록 해야 한다.
    // 다시 그려질 경우 dropdown 이 동작 안함

    import org.github.windbird123.play.spa.client.fomantic.Dropdown._
    $(".ui .dropdown").dropdown()

    // 위와 같이 facade 를 만들어도 되지만, dynamic types 를 사용하는 방법도 있다.
    //     https://www.scala-js.org/doc/interoperability/facade-types.html#calling-javascript-from-scalajs-with-dynamic-types
//    val formanticTab = js.Dynamic.newInstance(js.Dynamic.global.$)(".ui .dropdown")
//    formanticTab.dropdown()
  }
}
