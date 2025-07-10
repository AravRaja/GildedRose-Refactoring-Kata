package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        items.forEach {item ->

           when {
                item.name == "Aged Brie" -> Items.AgedBrie.update(item)
                item.name == "Sulfuras, Hand of Ragnaros" -> Items.Sulfuras.update(item)
                item.name.startsWith("Backstage passes") -> Items.BackstagePass.update(item)
                item.name.startsWith("Conjured") -> Items.Conjured.update(item)
                else -> Items.NormalItem.update(item)

            }



        }
    }


}

