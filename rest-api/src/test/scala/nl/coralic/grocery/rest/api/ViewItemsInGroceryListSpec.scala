package nl.coralic.grocery.rest.api

import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait
import nl.coralic.grocery.app.scala.{Item => GroceryItem}
import org.mockito.Mockito._
import RestMessages._
import spray.httpx.SprayJsonSupport._
import spray.httpx.unmarshalling._

class ViewItemsInGroceryListSpec extends BaseSpec with GroceryListApi {

  private val mockO = mock[GroceryListRequestTrait]
  val groceryData = List(GroceryItem("milk", 1), GroceryItem("bread", 1))
  when(mockO.allItems).thenReturn(groceryData)

  override def groceryList = mockO

  "User" should {
    "be able to view items in the grocery list" in {
      val response = Get("/items") ~> getAllItems
      response ~> check {
        status.isSuccess should equal(true)
        body.as[List[Item]].right.get should have size 2
      }
    }
  }
}
