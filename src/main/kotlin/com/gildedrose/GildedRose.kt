package com.gildedrose

class GildedRose(val items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {

            val rules = when {
                items[i].name == "Aged Brie" -> listOf(
                    Rule.QualityUpdateOverSellInRange(1, 1..50),
                    Rule.QualityUpdateOverSellInRange(2, Int.MIN_VALUE..0),
                    Rule.DecreaseSellIn(1),
                    Rule.ConstrainQuality(0..50)
                )
                items[i].name == "Sulfuras, Hand of Ragnaros" -> listOf(
                    Rule.ConstrainQuality(0..80)
                )
                items[i].name.startsWith("Backstage passes") -> listOf(

                    Rule.QualityUpdateOverSellInRange(1, 11..50),
                    Rule.QualityUpdateOverSellInRange(2, 6..10),
                    Rule.QualityUpdateOverSellInRange(3, 1..5),
                    Rule.QualityUpdateOverSellInRange(-items[i].quality, Int.MIN_VALUE..0),
                    Rule.DecreaseSellIn(1),
                    Rule.ConstrainQuality(0..50)
                )
                items[i].name.startsWith("Conjured") -> listOf(

                    Rule.QualityUpdateOverSellInRange(-2, 1..50),
                    Rule.QualityUpdateOverSellInRange(-4, Int.MIN_VALUE..0),
                    Rule.DecreaseSellIn(1),
                    Rule.ConstrainQuality(0..50)

                )
                else -> listOf (

                    Rule.QualityUpdateOverSellInRange(-1, 1..50),
                    Rule.QualityUpdateOverSellInRange(-2, Int.MIN_VALUE..0),
                    Rule.DecreaseSellIn(1),
                    Rule.ConstrainQuality(0..50)
                )

            }
            for (rule in rules) rule.apply(items[i])


        }
    }


}

