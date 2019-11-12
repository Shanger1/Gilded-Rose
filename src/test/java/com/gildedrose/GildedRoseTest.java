package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

    private Item[] items;

    @Before
    public void init_list(){
        items = new Item[] {
                new NormalItem("Elixir of the Mongoose", 0, 0),
                new NormalItem("Elixir of the Mongoose", 1, 5),
                new AgedBrie("Aged Brie", 5, 5),
                new Item("Sulfuras, Hand of Ragnaros", 5, 5),
                new SpecialEvent("Backstage passes to a TAFKAL80ETC concert", 11, 3)
        };
    }

    @Test
    public void test_quality_never_negative() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    public void test_quality_never_more_than_50() {
        Item[] allItems = new Item[] {
                new AgedBrie("Aged Brie", 5, 50), //
                new NormalItem("Elixir of the Mongoose", 5, 50), //
                new SpecialEvent("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new ConjuredItem("Conjured Mana Cake", 5, 50) };
        GildedRose app = new GildedRose(allItems);
        app.updateQuality();
        assertTrue(app.items[0].quality <= 50);
        assertTrue(app.items[1].quality <= 50);
        assertTrue(app.items[2].quality <= 50);
        assertTrue(app.items[3].quality <= 50);
    }

    @Test
    public void test_quality_downgrade_and_twice_as_fast_downgrade(){
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[1].quality);
        app.updateQuality();
        assertEquals(2, app.items[1].quality);
    }

    @Test
    public void test_aged_brie_quality_increase() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[2].quality);
        app.updateQuality();
        assertEquals(7, app.items[2].quality);
    }

    @Test
    public void test_sulfuras() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[3].quality);
        app.updateQuality();
        assertEquals(5, app.items[3].quality);
    }

    @Test
    public void test_special_event() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[4].quality);
        app.updateQuality();
        assertEquals(6, app.items[4].quality);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(17, app.items[4].quality);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[4].quality);
    }

}
