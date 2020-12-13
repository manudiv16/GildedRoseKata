package com.gildedrose

import com.gildedrose.ItemAtributes._

import scala.language.postfixOps

case class Conjured(name: ItemName, sellIn: ItemSellIn, quality: ItemQuality) extends Item {
  def update(): Conjured = copy(sellIn = sellIn.decreaseSell, quality = quality.modify)

  implicit def qualifyFun: Int => Int = -2 *
}
