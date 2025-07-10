package com.gildedrose

import com.gildedrose.Items.AgedBrie.rules

sealed class Items {
    fun update(item: Item){
        rules.forEach {it.apply(item)}
    }

    abstract val rules: List<Rule>

     data object AgedBrie: Items() {
        override val rules = listOf(
                        Rule.QualityUpdateOverSellInRange(1, 1..50),
                        Rule.QualityUpdateOverSellInRange(2, Int.MIN_VALUE..0),
                        Rule.DecreaseSellIn(1),
                        Rule.ConstrainQuality(0..50)
        )




    }
    data object  Sulfuras: Items(){
        override val  rules = listOf(
                        Rule.ConstrainQuality(0..80)
                    )
    }
    data object BackstagePass: Items(){
        override val rules = listOf(
                            Rule.QualityUpdateOverSellInRange(1, 11..50),
                            Rule.QualityUpdateOverSellInRange(2, 6..10),
                            Rule.QualityUpdateOverSellInRange(3, 1..5),
                            Rule.QualityUpdateOverSellInRange(-Int.MAX_VALUE, Int.MIN_VALUE..0),
                            Rule.DecreaseSellIn(1),
                            Rule.ConstrainQuality(0..50)
                            )
    }
    data object Conjured: Items(){
        override val rules = listOf(
                            Rule.QualityUpdateOverSellInRange(-2, 1..50),
                            Rule.QualityUpdateOverSellInRange(-4, Int.MIN_VALUE..0),
                            Rule.DecreaseSellIn(1),
                            Rule.ConstrainQuality(0..50)
                            )


    }
    data object NormalItem : Items(){
        override val rules = listOf (

            Rule.QualityUpdateOverSellInRange(-1, 1..50),
            Rule.QualityUpdateOverSellInRange(-2, Int.MIN_VALUE..0),
            Rule.DecreaseSellIn(1),
            Rule.ConstrainQuality(0..50)
        )


    }

}