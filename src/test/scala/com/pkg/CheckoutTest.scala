package com.pkg

import org.scalatest.FunSuite
import scala.util.Random

class CheckoutTest extends FunSuite {

  val validInput = Seq("A", "B", "C", "D")
  val random = new Random
  val randomValidInput: String = validInput(random.nextInt(validInput.length))
  val sampleCartNoOffers = collection.mutable.Map[String, Int]("A" -> 1, "B" -> 1, "C" -> 1)
  val sampleCartWithOffers = collection.mutable.Map[String, Int]("A" -> 4, "C" -> 1)

  test("Validates user input against pricing file") {
    assert(Checkout.validUserInput(randomValidInput))
  }

  test("Calculates cart total with no applicable offers") {
    assert(Checkout.calculateCartTotal(sampleCartNoOffers) == 100)
  }
  test("Calculates cart total with applicable offers") {
    assert(Checkout.calculateCartTotal(sampleCartWithOffers) == 200)
  }

}