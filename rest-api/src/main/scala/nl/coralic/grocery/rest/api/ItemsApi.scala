package nl.coralic.grocery.rest.api

import spray.routing.HttpService
import RestMessages._
import spray.httpx.SprayJsonSupport._
import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait

trait ItemsApi extends HttpService {

  def groceryList: ItemsRequestTrait

  val addItem = path("item") {
    post {
      entity(as[Item]) {
        item =>
          complete {
            groceryList.addItem(item.name, item.price)
            item
          }
      }
    }
  }

  val items = path("items") {
    get {
      complete {
        groceryList.getItems.map(l => Item(l.name, l.price))
      }
    }
  }
}
