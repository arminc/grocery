package nl.coralic.grocery.rest.api

import org.scalatest.{WordSpecLike, Matchers}
import spray.testkit.ScalatestRouteTest
import akka.actor.ActorRefFactory

class BaseSpec extends Matchers with WordSpecLike with ScalatestRouteTest {

  def actorRefFactory: ActorRefFactory = system
}
