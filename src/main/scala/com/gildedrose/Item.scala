package com.gildedrose

import com.gildedrose.ItemAtributes.ItemQuality.modifyFunc
import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}


trait Item {
  def update(): Item

  val name: ItemName
  val sellIn: ItemSellIn
  val quality: ItemQuality

  implicit def qualifyFun: modifyFunc

  override def toString: String = s"$name,$sellIn,$quality"
}



