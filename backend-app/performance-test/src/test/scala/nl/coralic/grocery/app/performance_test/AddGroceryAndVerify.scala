package nl.coralic.grocery.app.performance_test

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import assertions._
import scala.concurrent.duration.DurationDouble

class AddGroceryAndVerify extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9999")
    .acceptHeader("application/json")
    .userAgentHeader("curl/7.35.0")

  val contentTypeJson = Map("Content-Type" -> "application/json")

  val scnOne = scenario("Add grocery items and verify")
    .exec(http("Add one grocery item")
    .post("/grocery/add")
    .headers(contentTypeJson)
    .body(RawFileBody("oneGroceryItem.json"))
    .check(status.is(200)
    ,jsonPath("$.").count.is(1)))

  val scnTwo = scenario("Verify get items performance")
    .exec(http("Verify that one grocery item is available")
    .get("/grocery/items")
    .check(status.is(200)))

  setUp(scnOne.inject(atOnce(1 user)), scnTwo.inject(constantRate(2 usersPerSec) during (10 seconds)))
    .protocols(httpProtocol)
    .assertions(global.failedRequests.count.is(0))
}

