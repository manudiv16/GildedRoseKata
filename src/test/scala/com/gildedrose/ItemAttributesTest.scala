package com.gildedrose
import scala.language.postfixOps
import com.gildedrose.ItemAtributes.ItemQuality
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ItemAttributesTest extends AnyFlatSpec with Matchers {

  "Item quality" should "modify the quality with less than 0" in {

    val itemQuality: ItemQuality = ItemQuality(0)

    assert(itemQuality.modify(-2*).quality == 0)

    assert(itemQuality.modify(2*).quality == 2)

  }

  it should "modify the quality with more than 50" in {
    val itemQuality: ItemQuality = ItemQuality(50)

    assert(itemQuality.modify(2*).quality == 50)

    assert(itemQuality.modify(-2*).quality == 48)
  }

  it should "modify with implicit function" in {
    implicit val a: Int => Int = -1 *
    val itemQuality: ItemQuality = ItemQuality(50)
    assert(itemQuality.modify.quality == 49)
  }


}

