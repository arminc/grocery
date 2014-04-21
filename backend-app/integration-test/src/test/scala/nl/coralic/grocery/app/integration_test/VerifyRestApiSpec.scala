package nl.coralic.grocery.app.integration_test

import com.jayway.restassured.RestAssured._
import org.hamcrest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VerifyRestApiSpec extends BaseSpec {

  private val url = "http://localhost:9999/grocery"

  "GroceryList Rest API" should {

    "allow storing a single item with name and the price" in {
      val oneItemInJsonFormat = "{\"name\": \"milk\", \"price\": 1}"
      given().contentType("application/json").and().body(oneItemInJsonFormat).
        when().post(s"$url/add").
        `then`().statusCode(200)
    }

    "allow retrieving the item" in {
      given().contentType("application/json").
        when().get(s"$url/items").
        `then`()
        .statusCode(200)
        .assertThat().body("", hasSize(1))
    }
  }

}
