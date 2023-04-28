package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private final List<String> specialItems = Arrays.asList("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros");

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAllItems() {
        for (Item item : items)
            updateItemProperties(item);
    }

    private void updateItemProperties(Item item) {
        if (!specialItems.contains(item.name)) {
            decreaseQualityWhenPositive(item);
        } else if (item.quality < 50) {
            increaseQuality(item);
            updateBackstagePassesItem(item);
        }

        decreaseSellInForNonSulfuras(item);

        if (item.sellIn < 0)
            handleCaseForSellInBelowZero(item);
    }

    private void handleCaseForSellInBelowZero(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decreaseQualityWhenPositive(item);
            } else
                item.quality = 0;
        } else
            increaseWhenQualityIsLessThanFifty(item);
    }

    private void updateBackstagePassesItem(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11)
                increaseWhenQualityIsLessThanFifty(item);

            if (item.sellIn < 6)
                increaseWhenQualityIsLessThanFifty(item);
        }
    }

    private void increaseWhenQualityIsLessThanFifty(Item item) {
        if (item.quality < 50)
            increaseQuality(item);
    }

    private void decreaseSellInForNonSulfuras(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseSellIn(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityWhenPositive(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}