package nl.coralic.grocery.app.scala.interfaces

import nl.coralic.grocery.app.scala.Item

trait ItemsRequestTrait {
  def addItem(name: String, price: Double)
  def getItems: List[Item]
}
