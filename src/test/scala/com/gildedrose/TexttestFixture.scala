package com.gildedrose

import com.gildedrose.ItemFactory.itemFactory
import scalaz._
import effect._
import IO._



object TexttestFixture {
  def main(args: Array[String]): Unit = {

    val items: Array[(String, Int, Int)] = Array[(String, Int, Int)](
      ("+5 Dexterity Vest", 10, 20),
      ("Aged Brie", 2, 0),
      ("Elixir of the Mongoose", 5, 7),
      ("Sulfuras, Hand of Ragnaros", 0, 80),
      ("Sulfuras, Hand of Ragnaros", -1, 80),
      ("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      ("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      ("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      ("Conjured Mana Cake", 3, 6)
    )

    val clasifiedItems: Array[Item] = items flatMap itemFactory
    printUpdatedDays(15,clasifiedItems).unsafePerformIO()

  }

  val printItems: Array[Item] => IO[Unit] = { i:Array[Item] => IO(i foreach println) }

  def printUpdatedDays(n: Int, clasifiedItems: Array[Item], cont:Int=0): IO[Unit] = for {
      _ <- putStrLn("-------- day " + cont + " --------")
      _ <- putStrLn("name,sellIn,quality")
      _ <- printItems(clasifiedItems)
      _ <- if (cont != n) printUpdatedDays(n,GildedRose.updateQuality(clasifiedItems),cont+1)
      else IO()
    } yield ()

}
