package nl.coralic.grocery.app.scala

import scala.collection.mutable
import nl.coralic.grocery.app.scala.api.{GroceryItem, GroceryListApi}

object GroceryList {
  def apply() = new GroceryList
}

class GroceryList extends GroceryListApi {

  private val items = new mutable.ListBuffer[GroceryItem]

  def add(name: String, price: Double) = items += GroceryItem(name, price)

  def allItems = items.toList

  def totalPrice = items.map(_.price).sum
}
