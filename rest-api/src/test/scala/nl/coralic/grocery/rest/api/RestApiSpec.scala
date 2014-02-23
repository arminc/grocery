package nl.coralic.grocery.rest.api

import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait
import org.mockito.Mockito._

class RestApiSpec extends BaseSpec with Routes {

  private val mockO = mock[GroceryListRequestTrait]
  when(mockO.allItems).thenThrow(new RuntimeException())

  override def groceryList = mockO

  "User" should {
    "get an error" when {
      "exception is thrown by the route" in {
        val response = Get("/grocery/items") ~> routes
        response ~> check {
          status.isFailure should equal(true)
          status.intValue should equal(500)
        }
      }
    }
  }
}
