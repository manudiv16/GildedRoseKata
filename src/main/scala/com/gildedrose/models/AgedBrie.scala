package com.gildedrose.models
import scala.language.postfixOps

import com.gildedrose.Item
import com.gildedrose.ItemAtributes.ItemQuality.modifyFunc
import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}

case class AgedBrie(name: ItemName, sellIn: ItemSellIn, quality: ItemQuality) extends Item {

  val newSellIn: ItemSellIn = sellIn.decreaseSell

  def update(): AgedBrie = {
    copy(sellIn = newSellIn, quality = quality.modify)
  }

  implicit def qualifyFun: modifyFunc =
    if (newSellIn.isAfterSellDay()) 2 *
    else 1 *

}
