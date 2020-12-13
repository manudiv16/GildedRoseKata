package com.gildedrose.models

import com.gildedrose.Item
import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}

case class Conjured(name: ItemName, sellIn: ItemSellIn, quality: ItemQuality) extends Item {
  def update(): Conjured = copy(sellIn = sellIn.decreaseSell, quality = quality.modify)

  implicit def qualifyFun: Int => Int = -2 *
}
