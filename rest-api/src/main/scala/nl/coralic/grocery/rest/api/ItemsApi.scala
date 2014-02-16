package nl.coralic.grocery.rest.api

import spray.routing.HttpService
import RestMessages._
import spray.httpx.SprayJsonSupport._

trait ItemsApi extends HttpService {

  val addItem = path("item") {
    post {
      entity(as[Item]) {
        item =>
          complete {
            item
          }
      }
    }
  }
}
