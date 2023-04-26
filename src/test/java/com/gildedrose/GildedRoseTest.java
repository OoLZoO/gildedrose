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

    @Test
    public void updateWhenItemIsElixirOfTheMongooseAndQualityIsMoreThanZero() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(6));
    }

    @Test
    public void updateWhenItemIsElixirOfTheMongooseAndQualityIsLessThanZero() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 5, -7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(-7));
    }

    @Test
    public void updateWhenItemIsElixirOfTheMongooseAndQualityIsZero() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(0));
    }

    @Test
    public void boundaryTestWhenSellInIs11AndNameIsBackstagePassesAndQualityIsLessThan50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(41));
        assertThat(items[1].quality, equalTo(42));
        assertThat(items[2].quality, equalTo(41));
    }

    @Test
    public void boundaryTestWhenSellInIs6AndNameIsBackstagePassesAndQualityIsLessThan50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 40)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(43));
        assertThat(items[1].quality, equalTo(42));
        assertThat(items[2].quality, equalTo(42));
    }

    @Test
    public void boundaryTestWhenSellInIsBelow0AndNameIsNotAgedOrBackstageAndQualityIsGreaterThan0() {
        Item[] items = new Item[] {
                new Item("Elixir of the Mongoose", -1, -1),
                new Item("Elixir of the Mongoose", -2, 0),
                new Item("Elixir of the Mongoose", -3, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(-1));
        assertThat(items[1].quality, equalTo(0));
        assertThat(items[2].quality, equalTo(0));
    }

    @Test
    public void boundaryTestWhenSellInIsBelow0AndNameIsAgedBrieAndQualityIsLessThan50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, 49),
                new Item("Aged Brie", -1, 50),
                new Item("Aged Brie", -1, 51)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(items[0].quality, equalTo(50));
        assertThat(items[1].quality, equalTo(50));
        assertThat(items[2].quality, equalTo(51));
    }


}
