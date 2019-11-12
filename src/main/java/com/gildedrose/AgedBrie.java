package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) { super(name, sellIn, quality); }

    public void upgrade() {
        setSellIn(getSellIn() - 1);
        increaseItemQuality();
        if(getSellIn() < 0){
            increaseItemQuality();
        }
    }
}
