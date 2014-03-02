package nl.coralic.grocery.rest.api

import spray.json.DefaultJsonProtocol

object RestMessages {

  case class Item(name: String, price: Double)

  object Item extends DefaultJsonProtocol {
    implicit val format = jsonFormat2(Item.apply)
  }
}
