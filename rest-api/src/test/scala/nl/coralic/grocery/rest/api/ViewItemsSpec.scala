package nl.coralic.grocery.rest.api

import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait
import nl.coralic.grocery.app.scala.{Item => GroceryItem}
import org.mockito.Mockito._
import RestMessages._
import spray.httpx.SprayJsonSupport._
import spray.httpx.unmarshalling._

class ViewItemsSpec extends BaseSpec with ItemsApi {

  private val mockO = mock[ItemsRequestTrait]
  val groceryData = List(GroceryItem("milk", 1), GroceryItem("bread", 1))
  when(mockO.getItems).thenReturn(groceryData)
  override def groceryList = mockO

  "User" should {
    "be able to view items" in {
      val response = Get("/items") ~> items
      response ~> check {
        status.isSuccess should equal(true)
        body.as[List[Item]].right.get should have size 2
      }
    }
  }
}
