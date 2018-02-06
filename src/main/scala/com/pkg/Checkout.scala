package com.pkg

object Checkout {

  val userPrompt: String = "Enter Q to quit or enter the item's SKU: "

  def validUserInput(userinput: String): Boolean = {
    val testedItem = PricingChecker.pricingFromFile \\ userinput
    if (testedItem.isEmpty) false
    else {
      val sku = testedItem.head.label
      sku.contains(userinput)
    }
  }

  def calculateWithOffer(sku: String, itemcount: Int): Int = {
    val offerUnits = PricingChecker.getOfferUnits(sku)
    val offerPrice = PricingChecker.getOfferPrice(sku)
    val singleItemPrice = PricingChecker.getSingleItemPrice(sku)
    ((itemcount / offerUnits) * offerPrice) + ((itemcount % offerUnits) * singleItemPrice)
  }

  def calculateCartTotal(cartcontents: collection.mutable.Map[String, Int]): Int = {
    val itemPrices = cartcontents map {case (key, value) => (key, calculateWithOffer(key, value))}
    itemPrices.values.sum
  }

  var shoppingCart = collection.mutable.Map[String, Int]().withDefaultValue(0)


  def addToShoppingCart(): Unit = {
    var userInput = readLine(userPrompt).capitalize
    if (validUserInput(userInput) && userInput != "Q") {
      shoppingCart(userInput) += 1
      var total = calculateCartTotal(shoppingCart)
      println(s"Items scanned: ${shoppingCart.mkString}. Total: $total")
    addToShoppingCart()} else {System.exit(0)}
//      userInput = readLine(userPrompt).capitalize
//    }
//    System.exit(0)
  }

}