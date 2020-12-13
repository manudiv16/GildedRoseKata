package com.gildedrose

object GildedRose {
  def updateQuality(items: Array[Item]): Array[Item] =
    for (i <- items) yield i.update()
}