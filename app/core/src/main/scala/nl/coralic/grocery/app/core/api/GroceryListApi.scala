package nl.coralic.grocery.app.core.api

case class GroceryItem(name: String, price: Double)

trait GroceryListApi {
  def add(name: String, price: Double)
  def allItems: List[GroceryItem]
}
