package nl.coralic.grocery.rest.api

import spray.routing.HttpServiceActor

class RestActor extends HttpServiceActor with ItemsApi {

  def receive = runRoute(routes)

  val routes = {
    pathPrefix("grocery") {
      addItem
    }
  }
}

