package com.gildedrose

sealed class Rule {
    abstract fun apply(item: Item)

    data class ConstrainQuality(val range: ClosedRange<Int>): Rule() {
        override fun apply(item: Item) {
            item.quality = item.quality.coerceIn(range)
        }
    }

    data class DecreaseSellIn(val amount: Int): Rule() {
        override fun apply(item: Item){
           item.sellIn -= amount
        }
    }

    data class QualityUpdateOverSellInRange(val qualityChange: Int, val range: ClosedRange<Int>): Rule(){
        override fun apply(item: Item) {
            if (item.sellIn in range) item.quality += qualityChange
        }

    }

}


