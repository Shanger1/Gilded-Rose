package com.gildedrose;

public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) { super(name, sellIn, quality); }

    public void upgrade() {
        setSellIn(getSellIn() - 1);
        for(int i = 0; i < 2; i++) {
            decreaseItemQuality();
            if(getSellIn() < 0){
                decreaseItemQuality();
            }
        }
    }
}
