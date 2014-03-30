package nl.coralic.grocery.app.integration_test

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import assertions._

class AddGroceryAndVerify extends BaseSimulation {

  val scn = scenario("Add grocery items and verify")
    .exec(http("Add one grocery item")
    .post("/grocery/add")
    .headers(contentTypeJson)
    .body(RawFileBody("oneGroceryItem.json"))
    .check(status.is(200)
    ,jsonPath("$.").count.is(1)))

    .exec(http("Verify no grocery items available")
    .get("/grocery/items")
    .check(status.is(200)
    ,jsonPath("$.").count.is(1)))

  setUp(scn.inject(atOnce(1 user)))
    .protocols(httpProtocol)
    .assertions(global.failedRequests.count.is(0))
}

