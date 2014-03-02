package nl.coralic.grocery.app.rest.api

import org.scalatest.{WordSpecLike, Matchers}
import spray.testkit.ScalatestRouteTest
import akka.actor.ActorRefFactory
import org.scalatest.mock.MockitoSugar

abstract class BaseSpec extends Matchers with WordSpecLike with ScalatestRouteTest with MockitoSugar {

  def actorRefFactory: ActorRefFactory = system
}
