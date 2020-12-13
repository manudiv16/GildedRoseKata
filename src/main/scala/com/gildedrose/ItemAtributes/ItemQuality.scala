package com.gildedrose.ItemAtributes

import com.gildedrose.ItemAtributes.ItemQuality.modifyFunc


case class ItemQuality(quality: Int) {
  val maxQuality = 50
  val normalIncreaseOrDecrease = 1


  def modify(implicit f: modifyFunc): ItemQuality = {
    val newQualityInt = f(normalIncreaseOrDecrease) + quality
    if (newQualityInt < 0 ) this
    else if (50 < newQualityInt) copy(quality=maxQuality)
    else copy(newQualityInt)

  }

  def reset: ItemQuality = copy(0)

  override def toString: String = s"$quality"
}

object ItemQuality {
  type modifyFunc = Int => Int
}

