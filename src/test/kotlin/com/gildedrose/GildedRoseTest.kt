package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun testNormalItemUpdate() {
        val items = listOf(Item("chocolate", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("chocolate, 9, 1", app.items[0].toString())
    }
    @Test
    fun testNormalItemQualityUpdateAfterSellBy() {
        val items = listOf(Item("chocolate", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("chocolate, -2, 3", app.items[0].toString())
    }
    @Test
    fun testNonNegativeQuality() {
        val items = listOf(Item("chocolate", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("chocolate, 9, 0", app.items[0].toString())
    }

    @Test
    fun testAgedBrieUpdate() {
        val items = listOf(Item("Aged Brie", 10, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie, 9, 6", app.items[0].toString())
    }
    @Test
    fun testAgedBrieUpdateAfterSellBy() {
        val items = listOf(Item("Aged Brie", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie, -2, 7", app.items[0].toString())
    }
    @Test
    fun testAgedBrieUpdateMaxFiftyQuality() {
        val items = listOf(Item("Aged Brie", -1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Aged Brie, -2, 50", app.items[0].toString())
    }
    @Test
    fun testSulfurasConstant() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        println(app.items[0].toString())
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString())
    }



}


