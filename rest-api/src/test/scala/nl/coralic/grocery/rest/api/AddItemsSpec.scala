package nl.coralic.grocery.rest.api
import RestMessages._
import spray.httpx.SprayJsonSupport._


class AddItemsSpec extends BaseSpec with ItemsApi{

  "User" should {
    "be able to add an item" in {
      val item = Item("milk", 10.1)
      val response = Post("/item", item) ~> addItem
      response ~> check {
        status.isSuccess should equal(true)
        println(body)
      }
    }

    "get an error" when {

      "response takes more than 5 seconds" in {
        println()
      }
    }
  }
}
