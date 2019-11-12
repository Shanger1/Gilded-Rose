package com.gildedrose;

public class NormalItem extends Item {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void upgrade() {
        setSellIn(getSellIn() - 1);
        decreaseItemQuality();
        if(getSellIn() < 0){
            decreaseItemQuality();
        }
    }
}
