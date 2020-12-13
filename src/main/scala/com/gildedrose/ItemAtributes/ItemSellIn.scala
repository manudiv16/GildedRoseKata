package com.gildedrose.ItemAtributes

case class ItemSellIn(sellIn: Int) {


  def isAfterSellDay(day: Int = 0): Boolean = sellIn <= day

  def decreaseSell: ItemSellIn = copy(sellIn - 1)

  override def toString = s"$sellIn"

}
