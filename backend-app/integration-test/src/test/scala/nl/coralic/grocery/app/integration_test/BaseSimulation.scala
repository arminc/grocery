package nl.coralic.grocery.app.integration_test

import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

abstract class BaseSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9999")
    .acceptHeader("application/json")
    .userAgentHeader("curl/7.35.0")

  val contentTypeJson = Map("Content-Type" -> "application/json")

}
