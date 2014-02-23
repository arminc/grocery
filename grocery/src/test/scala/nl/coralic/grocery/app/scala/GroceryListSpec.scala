package nl.coralic.grocery.app.scala

class GroceryListSpec extends BaseSpec {

  private var groceryList = GroceryList()

  override def beforeEach() {
    groceryList = GroceryList()
  }

  "GroceryList" should {
    "allow storing a single item with name and the price" in {
      groceryList.add("milk", 10)
    }

    "allow retrieving the item" in {
      groceryList.add("milk", 10)
      val item = groceryList.allItems.head
      item.name should equal("milk")
      item.price should equal(10)
    }

    "allow storing multiple items" in {
      groceryList.add("milk", 15)
      groceryList.add("chocolate", 20)
      val items = groceryList.allItems
      items should have length 2

      items.head.name should equal("milk")
      items.head.price should equal(15)

      items.last.name should equal("chocolate")
      items.last.price should equal(20)
    }

    "show total price for all items" in {
      groceryList.add("milk", 15)
      groceryList.add("chocolate", 20.43)
      groceryList.totalPrice should equal(35.43)
    }
  }
}
