package nl.coralic.grocery.app.scala.api

case class GroceryItem(name: String, price: Double)

trait GroceryListApi {
  def add(name: String, price: Double)
  def allItems: List[GroceryItem]
}
