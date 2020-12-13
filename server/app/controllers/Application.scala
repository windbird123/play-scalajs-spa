package controllers

import play.api.mvc._

import javax.inject._

case class Search(query: Option[String])

@Singleton
class Application @Inject() (cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder)
    extends MessagesAbstractController(cc) {
  def index(tab: String, query: Option[String]): Action[AnyContent] = Action(implicit request => Ok(views.html.index()))
}
