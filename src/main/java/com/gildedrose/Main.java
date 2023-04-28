package com.gildedrose;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example of running Gilded Rose");

        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

        GildedRose app = new GildedRose(items);

        System.out.println("Day 1 ======================");
        for (Item item : items) {
            System.out.println("item = " + item);
        }

        System.out.println("Day 2 ======================");
        app.updateAllItems();
        for (Item item : items) {
            System.out.println("item = " + item);
        }

        System.out.println("Day 3 ======================");
        app.updateAllItems();
        for (Item item : items) {
            System.out.println("item = " + item);
        }
    }
}
