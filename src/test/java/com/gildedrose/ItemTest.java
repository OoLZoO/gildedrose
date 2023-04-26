package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemTest {

    @Test
    public void testItemConstructor() {
        Item item = new Item("foo", 0, 0);
        assertThat(item.name, equalTo("foo"));
        assertThat(item.sellIn, equalTo(0));
        assertThat(item.quality, equalTo(0));
    }

    @Test
    public void testItemToString() {
        Item item = new Item("foo", 0, 0);
        assertThat(item.toString(), equalTo("foo, 0, 0"));
    }

    @Test
    public void testItemPublicFields() {
        Item item = new Item("foo", 0, 0);
        item.name = "bar";
        item.sellIn = 1;
        item.quality = 2;
        assertThat(item.name, equalTo("bar"));
        assertThat(item.sellIn, equalTo(1));
        assertThat(item.quality, equalTo(2));
    }

}
