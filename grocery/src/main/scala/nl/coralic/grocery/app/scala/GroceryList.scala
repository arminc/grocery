package nl.coralic.grocery.app.scala

import scala.collection.mutable
import nl.coralic.grocery.app.scala.interfaces.GroceryListRequestTrait

case class Item(name: String, price: Double)

object GroceryList {
  def apply() = new GroceryList
}

class GroceryList extends GroceryListRequestTrait {

  private val items = new mutable.ListBuffer[Item]

  def add(name: String, price: Double) = items += Item(name, price)

  def allItems = items.toList

  def totalPrice = items.map(_.price).sum
}
