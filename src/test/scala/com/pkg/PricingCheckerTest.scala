package com.pkg

import org.scalatest.FunSuite

class PricingCheckerTest extends FunSuite {

  test("Gets correct item price by the item's SKU") {
    assert(PricingChecker.getSingleItemPrice("A") == 50)
  }
  test("Gets correct value for the item bundle eligible to offer") {
    assert(PricingChecker.getOfferUnits("A") == 3)
    assert(PricingChecker.getOfferUnits("B") == 2)
  }

  test("Gets correct offer price by the item's SKU") {
    assert(PricingChecker.getOfferPrice("A") == 130)
  }

}