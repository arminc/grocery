package nl.coralic.grocery.rest.api

import spray.routing.HttpServiceActor
import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait

class RestActor(grocery: GroceryListRequestTrait) extends HttpServiceActor with Routes {

  def receive = runRoute(routes)

  override def groceryList = grocery
}

trait Routes extends GroceryListApi {
  val routes = {
    pathPrefix("grocery") {
      addItem ~ getAllItems
    }
  }
}

