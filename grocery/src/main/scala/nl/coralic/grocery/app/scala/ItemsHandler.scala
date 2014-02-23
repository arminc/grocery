package nl.coralic.grocery.app.scala

import scala.collection.mutable
import nl.coralic.grocery.app.scala.interfaces.ItemsRequestTrait

case class Item(name: String, price: Double)

object ItemsHandler {
  def apply() = new ItemsHandler
}

class ItemsHandler extends ItemsRequestTrait {

  private val items = new mutable.ListBuffer[Item]

  def addItem(name: String, price: Double) = items += Item(name, price)

  def getItems = items.toList

  def totalPrice() = items.map(_.price).sum
}
