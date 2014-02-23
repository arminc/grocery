package nl.coralic.grocery.rest.api

import spray.routing.HttpServiceActor
import nl.coralic.grocery.app.scala.api.GroceryListApi

class RestActor(grocery: GroceryListApi) extends HttpServiceActor with Routes {

  def receive = runRoute(routes)

  override def groceryList = grocery
}

trait Routes extends GroceryListRoutes {
  val routes = {
    pathPrefix("grocery") {
      addItem ~ getAllItems
    }
  }
}

