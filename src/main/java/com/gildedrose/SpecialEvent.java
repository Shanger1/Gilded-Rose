package com.gildedrose;

public class SpecialEvent extends Item {

    public SpecialEvent(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void upgrade() {
        setSellIn(getSellIn() - 1);
        increaseItemQuality();
        if(getSellIn() < 10){
            increaseItemQuality();
        }
        if(getSellIn() < 5){
            increaseItemQuality();
        }
        if(getSellIn() < 0){
            setQuality(0);
        }
    }
}
