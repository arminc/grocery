package nl.coralic.grocery.rest.api

import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait
import org.mockito.Mockito._

class RestApiSpec extends BaseSpec with Routes {

  private val mockO = mock[ItemsRequestTrait]
  when(mockO.getItems).thenThrow(new RuntimeException())

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
