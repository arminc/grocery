package nl.coralic.grocery.rest.api

import spray.routing.HttpServiceActor
import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait

class RestActor(grocery: ItemsRequestTrait) extends HttpServiceActor with Routes {

  def receive = runRoute(routes)

  override def groceryList: ItemsRequestTrait = grocery
}

trait Routes extends ItemsApi {
  val routes = {
    pathPrefix("grocery") {
      addItem ~ items
    }
  }
}

