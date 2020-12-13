package com.gildedrose

import com.gildedrose.ItemAtributes.ItemQuality.modifyFunc
import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}

import scala.language.postfixOps

case class BackstagePasses(name: ItemName, sellIn: ItemSellIn, quality: ItemQuality) extends Item {

  val newSellIn: ItemSellIn = sellIn.decreaseSell

  def update(): BackstagePasses = {
    if (newSellIn.isAfterSellDay()) copy(sellIn = newSellIn, quality = quality.reset)
    else copy(sellIn = newSellIn, quality = quality.modify)

  }

  implicit def qualifyFun: modifyFunc =
    if (newSellIn.isAfterSellDay(5)) 2 *
    else if (newSellIn.isAfterSellDay(10)) 3 *
    else 1 *
}
