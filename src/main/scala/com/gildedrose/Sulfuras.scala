package com.gildedrose

import com.gildedrose.ItemAtributes.ItemQuality.modifyFunc
import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}

import scala.language.postfixOps

case class Sulfuras(name: ItemName, sellIn: ItemSellIn) extends Item {
  val quality: ItemQuality = ItemQuality(80)

  def update(): Sulfuras = copy(sellIn = sellIn.decreaseSell)

  implicit def qualifyFun: modifyFunc = 0 *
}

object Sulfuras {
  def apply(name: ItemName, sellIn: ItemSellIn, quality: ItemQuality): Sulfuras = {
    new Sulfuras(name, sellIn)
  }
}