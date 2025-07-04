package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    @Tag("normalItem")
    fun testNormalItemSellInUpdate() {
        val items = listOf(Item("chocolate", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }
    @Test
    @Tag("normalItem")
    fun testNormalItemQualityUpdate() {
        val items = listOf(Item("chocolate", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
    }
    @Test
    @Tag("normalItem")
    fun testNormalItemQualityUpdateAfterSellBy() {
        val items = listOf(Item("chocolate", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3,app.items[0].quality)
    }

    @Test
    @Tag("agedBrieItem")
    fun testAgedBrieSellInUpdate() {
        val items = listOf(Item("Aged Brie", 10, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    @Tag("agedBrieItem")
    fun testAgedBrieQualityUpdate() {
        val items = listOf(Item("Aged Brie", 1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test
    @Tag("agedBrieItem")
    fun testAgedBrieQualityUpdateAfterSellBy() {
        val items = listOf(Item("Aged Brie", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
    }
    @Test
    @Tag("agedBrieItem")
    fun testAgedBrieQualityUpdateMaxFifty() {
        val items = listOf(Item("Aged Brie", -1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }
    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassSellInUpdate() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
    }

    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassQualityUpdate() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
    }
    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassQualityUpdateTenOrLessSellin() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }
    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassQualityUpdateFiveOrLessSellin() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
    }
    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassQualityUpdateAfterSellBy() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
    @Test
    @Tag("backstagePassItem")
    fun testBackstagePassQualityUpdateMaxFifty() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    @Tag("sulfurasItem")
    fun testSulfurasConstant() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString())
    }

    @Test
    @Tag("conjuredItem")
    fun testConjuredSellInUpdate() {
        val items = listOf(Item("Conjured: Tomato", 10, 45))
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals(9, app.items[0].sellIn)
    }
    @Test
    @Tag("conjuredItem")
    fun testConjuredQualityUpdate() {
        val items = listOf(Item("Conjured: Tomato", 10, 45))
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals(43, app.items[0].quality)
    }
    @Test
    @Tag("conjuredItem")
    fun testConjuredQualityUpdateAfterSellBy() {
        val items = listOf(Item("Conjured: Tomato", -1, 45))
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals(41, app.items[0].quality)
    }
    @Test
    @Tag("general")
    fun multipleItems() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80), Item("chocolate", 10, 0) )
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString())
        assertEquals("chocolate, 9, 0", app.items[1].toString())
    }
    @Test
    @Tag("general")
    fun testNonNegativeQuality() {
        val items = listOf(Item("chocolate", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }





}


