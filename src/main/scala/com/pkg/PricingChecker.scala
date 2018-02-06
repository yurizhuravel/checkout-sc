package com.pkg

import scala.xml.XML

object PricingChecker {

  val pricingFileName: String = "pricing.xml"
  val pricingFromFile: scala.xml.NodeSeq = XML.loadFile(pricingFileName)

  def getSingleItemPrice(sku: String): Int = {
    val price = (pricingFromFile \ sku \ "@price").head.toString
    price.toInt
  }

  def getOfferUnits(sku: String): Int = {
    val offerUnits = (pricingFromFile \ sku \ "@offerUnits").head.toString
    if (offerUnits.nonEmpty) offerUnits.toInt else 1
  }

  def getOfferPrice(sku: String): Int = {
    val offerPrice = (pricingFromFile \ sku \ "@offerPrice").head.toString
    if (offerPrice.nonEmpty) offerPrice.toInt else getSingleItemPrice(sku: String)
  }
}
