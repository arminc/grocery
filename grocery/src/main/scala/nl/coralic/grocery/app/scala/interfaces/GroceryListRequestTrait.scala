package nl.coralic.grocery.app.scala.interfaces

import nl.coralic.grocery.app.scala.Item

trait GroceryListRequestTrait {
  def add(name: String, price: Double)
  def allItems: List[Item]
}
