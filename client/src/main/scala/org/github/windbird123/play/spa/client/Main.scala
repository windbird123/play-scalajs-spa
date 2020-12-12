package org.github.windbird123.play.spa.client

import mhtml._
import org.querki.jquery.$
import org.scalajs.dom.document

object Main {
  def main(args: Array[String]): Unit = {

    def menu =
      <div>
            <div class="ui top attached inverted menu">
                <div class="header item">Brand</div>
                <a class="active item" data-tab="first">First</a>
                <a class="item" data-tab="second">Second</a>
                <a class="item" data-tab="third">Third</a>

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
                <div class="ui bottom attached active tab segment" data-tab="first">
                    <h1>First</h1>
                </div>
                <div class="ui bottom attached tab segment" data-tab="second">
                    <h1>Second</h1>
                </div>
                <div class="ui bottom attached tab segment" data-tab="third">
                    <h1>Third</h1>
                </div>
            </div>
        </div>

    val body =
      <div>
        {menu}
        </div>

    mount(document.body, body)

    import org.github.windbird123.play.spa.client.fomantic.Dropdown._
    import org.github.windbird123.play.spa.client.fomantic.Menu._
    $(".menu .item").tab()
    $(".ui .dropdown").dropdown()
  }
}
