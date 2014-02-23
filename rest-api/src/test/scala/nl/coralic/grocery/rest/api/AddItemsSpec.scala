package nl.coralic.grocery.rest.api
import RestMessages._
import spray.httpx.SprayJsonSupport._
import spray.httpx.unmarshalling._
import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait

class AddItemsSpec extends BaseSpec with ItemsApi {

  override def groceryList = mock[ItemsRequestTrait]

  "User" should {
    "be able to add an item" in {
      val item = Item("milk", 10.1)
      val response = Post("/item", item) ~> addItem
      response ~> check {
        status.isSuccess should equal(true)
        body.as[Item] should equal(Right(item))
      }
    }
  }
}
