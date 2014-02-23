package nl.coralic.grocery.app.scala

class ItemsHandlerSpec extends BaseSpec {

  private var receiptHandler = ItemsHandler()

  override def beforeEach() {
    receiptHandler = ItemsHandler()
  }

  "ItemsHandler" should {
    "allow storing a single grocery item with name and the price" in {
      receiptHandler.addItem("milk", 10)
    }

    "allow retrieving the item name" in {
      receiptHandler.addItem("milk", 10)
      val item = receiptHandler.getItems.head
      item.name should equal("milk")
    }

    "allow retrieving the item price" in {
      receiptHandler.addItem("milk", 10.1)
      val item = receiptHandler.getItems.head
      item.price should equal(10.1)
    }

    "allow storing multiple items" in {
      receiptHandler.addItem("milk", 15)
      receiptHandler.addItem("chocolate", 20)
      val items = receiptHandler.getItems
      items.length should equal(2)

      items.head.name should equal("milk")
      items.head.price should equal(15)

      items.last.name should equal("chocolate")
      items.last.price should equal(20)
    }

    "show total price for all items" in {
      receiptHandler.addItem("milk", 15)
      receiptHandler.addItem("chocolate", 20.43)
      val price = receiptHandler.totalPrice()
      price should equal(35.43)
    }
  }
}
