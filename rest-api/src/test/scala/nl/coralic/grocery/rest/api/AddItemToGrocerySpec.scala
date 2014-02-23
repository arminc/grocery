package nl.coralic.grocery.rest.api
import RestMessages._
import spray.httpx.SprayJsonSupport._
import spray.httpx.unmarshalling._
import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait

class AddItemToGrocerySpec extends BaseSpec with GroceryListApi {

  override def groceryList = mock[GroceryListRequestTrait]

  "User" should {
    "be able to add an item to the grocery list" in {
      val item = Item("milk", 10.1)
      val response = Post("/add", item) ~> addItem
      response ~> check {
        status shouldBe 'isSuccess
        body.as[Item] should equal(Right(item))
      }
    }
  }
}
