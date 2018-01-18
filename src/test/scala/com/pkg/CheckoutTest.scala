package com.pkg

import org.scalatest.FunSuite
import scala.util.Random

class CheckoutTest extends FunSuite {

  val validInput = Seq("A", "B", "C", "D")
  val random = new Random
  val randomValidInput: String = validInput(random.nextInt(validInput.length))
  val sampleCart = Vector[String]("A", "A", "B")

  test("Validates user input against pricing file") {
    assert(Checkout.validUserInput(randomValidInput))
  }

  test("Gets correct item price by the item's SKU") {
    assert(Checkout.getItemPrice("A") == 50)
  }

  test("Calculates cart total") {
    assert(Checkout.calculateCartTotal(sampleCart) == 130)
  }

}