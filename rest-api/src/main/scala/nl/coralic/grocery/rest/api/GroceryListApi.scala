package nl.coralic.grocery.rest.api

import spray.routing.HttpService
import RestMessages._
import spray.httpx.SprayJsonSupport._
import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait

trait GroceryListApi extends HttpService {

  def groceryList: GroceryListRequestTrait

  val addItem = path("add") {
    post {
      entity(as[Item]) {
        item =>
          complete {
            groceryList.add(item.name, item.price)
            item
          }
      }
    }
  }

  val getAllItems = path("items") {
    get {
      complete {
        groceryList.allItems.map(l => Item(l.name, l.price))
      }
    }
  }
}
