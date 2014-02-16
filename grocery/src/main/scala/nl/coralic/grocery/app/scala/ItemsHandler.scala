package nl.coralic.grocery.app.scala

import scala.collection.mutable

case class Item(name: String, price: Double)

object ItemsHandler {
  def apply() = new ItemsHandler
}

class ItemsHandler extends ItemsRequestTrait {

  val items = new mutable.ListBuffer[Item]

  def addItem(name: String, price: Double) = items += Item(name, price)

  def totalPrice() = items.map(_.price).sum
}
