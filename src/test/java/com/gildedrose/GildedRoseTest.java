package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {
    @Test
    public void foo() {
        assertThat("foo", equalTo("foo"));
    }

    @Test
    public void updateQualityChangesAgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(1));
    }

    @Test
    public void updateQualityChangesElixirOfTheMongoose() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(6));
    }

    @Test
    public void updateQualityChangesSulfurasHandOfRagnaros() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(80));
    }

    @Test
    public void updateQualityChangesBackstagePassesToATAFKAL80ETCConcert() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(50));
    }

    @Test
    public void updateWhenQualityIsLessThan50AndNameIsBackstagePasses() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 2, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(43));
    }

    @Test
    public void updateWhenSellinIsBelow0AndNameIsNotAgedBriefAndNameIsNotBackstageAndQualityAbove0AndNameIsNotSulfuras() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", -1, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(5));
    }

    @Test
    public void updateWhenSellInBelowZeroNameIsNotAgeBrieOrBackstagePassesOrSulfurasAndQualityIsBelowZero() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, -7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(0));
    }

    @Test
    public void updateWhenSellInBelowZeroNameIsAgeBrieAndQualityIsLessThan50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, -7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(-5));
    }
}
