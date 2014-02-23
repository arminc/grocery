package nl.coralic.grocery.main

import akka.actor.{ActorSystem, Props}
import nl.coralic.grocery.rest.api.RestActor
import nl.coralic.grocery.app.scala.GroceryList
import com.typesafe.config.ConfigFactory
import akka.io.IO
import akka.io.Tcp.CommandFailed
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext

object Run extends App {

  implicit val system = ActorSystem("IpAnalyserSystem", ConfigFactory.load())
  private val rest = system.actorOf(Props(classOf[RestActor], GroceryList()))
  implicit def timeout: Timeout = 10.seconds
  implicit def executionContext: ExecutionContext = system.dispatcher

  startServer()

  private def startServer() {
    val binding = IO(Http) ? Http.Bind(rest, interface = "0.0.0.0", port = 9090)
    binding.onSuccess {
      case CommandFailed(bind) => sys.exit(1) //exit if not able to bind
    }
  }
}
