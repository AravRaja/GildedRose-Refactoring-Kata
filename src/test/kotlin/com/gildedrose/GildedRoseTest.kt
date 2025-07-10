package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test @Tag("normalItem")
    fun `normal item decreases sellIn by 1 each day`() {
        val items = listOf(Item("chocolate", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test @Tag("normalItem")
    fun `normal item decreases quality by 1 before sell by date`() {
        val items = listOf(Item("chocolate", 10, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
    }

    @Test @Tag("normalItem")
    fun `normal item decreases quality by 2 after sell by date`() {
        val items = listOf(Item("chocolate", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)
    }

    @Test @Tag("agedBrieItem")
    fun `aged brie decreases sellIn by 1 each day`() {
        val items = listOf(Item("Aged Brie", 10, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test @Tag("agedBrieItem")
    fun `aged brie increases quality by 1 before sell by date`() {
        val items = listOf(Item("Aged Brie", 1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(6, app.items[0].quality)
    }

    @Test @Tag("agedBrieItem")
    fun `aged brie increases quality by 2 after sell by date`() {
        val items = listOf(Item("Aged Brie", -1, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
    }

    @Test @Tag("agedBrieItem")
    fun `aged brie quality never exceeds fifty`() {
        val items = listOf(Item("Aged Brie", -1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass decreases sellIn by 1 each day`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass increases quality by 1 when sellIn over 10`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass increases quality by 2 when sellIn is 10 or less`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(42, app.items[0].quality)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass increases quality by 3 when sellIn is 5 or less`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass quality drops to zero after concert`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test @Tag("backstagePassItem")
    fun `backstage pass quality never exceeds fifty`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test @Tag("sulfurasItem")
    fun `sulfuras quality and sellIn do not change`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString())
    }

    @Test @Tag("conjuredItem")
    fun `conjured item decreases sellIn by 1`() {
        val items = listOf(Item("Conjured: Tomato", 10, 45))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
    }

    @Test @Tag("conjuredItem")
    fun `conjured item decreases quality by 2 before sell by`() {
        val items = listOf(Item("Conjured: Tomato", 10, 45))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(43, app.items[0].quality)
    }

    @Test @Tag("conjuredItem")
    fun `conjured item decreases quality by 4 after sell by`() {
        val items = listOf(Item("Conjured: Tomato", -1, 45))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(41, app.items[0].quality)
    }

    @Test @Tag("general")
    fun `multiple items update independently`() {
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", 10, 80),
            Item("chocolate", 10, 0)
        )
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", app.items[0].toString())
        assertEquals("chocolate, 9, 0", app.items[1].toString())
    }

    @Test @Tag("general")
    fun `item quality never becomes negative`() {
        val items = listOf(Item("chocolate", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }
}




