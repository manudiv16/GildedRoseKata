package com.gildedrose

import com.gildedrose.ItemAtributes.{ItemName, ItemQuality, ItemSellIn}

object ItemFactory {

  type DefaultItem = (String, Int, Int)

  def isAgedBrie(words: String): Boolean = words.matches(".*[Aa]ged.*[Bb]rie.*")

  def isSulfuras(words: String): Boolean = words.matches(".*[Ss]ulfuras.*")

  def isBackstagePasses(words: String): Boolean = words.matches(".*[Bb]ackstage [Pp]asses.*")

  def isConjured(words: String): Boolean = words.matches(".*[Cc]onjured.*")

  def itemFactory(defaultItem: DefaultItem): Option[Item] = defaultItem match {
    case (a, b, c) if isAgedBrie(a) => Some(AgedBrie(ItemName(a), ItemSellIn(b), ItemQuality(c)))
    case (a, b, c) if isSulfuras(a) => Some(Sulfuras(ItemName(a), ItemSellIn(b), ItemQuality(c)))
    case (a, b, c) if isBackstagePasses(a) => Some(BackstagePasses(ItemName(a), ItemSellIn(b), ItemQuality(c)))
    case (a, b, c) if isConjured(a) => Some(Conjured(ItemName(a), ItemSellIn(b), ItemQuality(c)))
    case (a, b, c) => Some(StandardItem(ItemName(a), ItemSellIn(b), ItemQuality(c)))
  }

}
