package com.gildedrose;

import java.util.HashMap;

import com.gildedrose.strategy.AgedBrieUpdateStrategy;
import com.gildedrose.strategy.BackstagePassesUpdateStrategy;
import com.gildedrose.strategy.ConjuredItemUpdateStrategy;
import com.gildedrose.strategy.StandardItemUpdateStrategy;
import com.gildedrose.strategy.SulfurasUpdateStrategy;

class GildedRose {
    Item[] items;
    HashMap<String, ItemUpdateStrategy> strategies;

    public GildedRose(Item[] items) {
        this.items = items;
        this.strategies = new HashMap<>();
        this.strategies.put("Aged Brie", new AgedBrieUpdateStrategy());
        this.strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdateStrategy());
        this.strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdateStrategy());
        this.strategies.put("default", new StandardItemUpdateStrategy());
        this.strategies.put("Conjured Mana Cake", new ConjuredItemUpdateStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            getItemUpdateStrategy(item).update(item);
            //     // "Aged Brie"가 아니고 "Backstage passes to a TAFKAL80ETC concert"가 아닌 경우
            //     // "Sulfuras"도 아니라면
            //     // 시간이 지남에 따라 품질 1 감소 (품질이 양수인 경우)
            //     if (!item.name.equals("Aged Brie")
            //         && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            //         if (item.quality > 0) {
            //             if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            //                 item.quality -= 1;
            //             }
            //         }
            //     } else {
            //         // "Aged Brie" 또는 "Backstage passes to a TAFKAL80ETC concert"인 경우
            //         // 시간이 지남에 따라 품질 1 증가 (품질이 50 미만인 경우)
            //         if (item.quality < 50) {
            //             item.quality += 1;
            //
            //             // "Backstage passes to a TAFKAL80ETC concert"인 경우
            //             // 판매 기한이 6~10일 남았을 경우 품질이 2씩 증가 (품질이 50 미만인 경우)
            //             // 판매일이 0~5일 남았을 경우 품질이 3씩 증가 (품질이 50 미만인 경우)
            //             if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            //                 if (item.sellIn < 11) {
            //                     if (item.quality < 50) {
            //                         item.quality += 1;
            //                     }
            //                 }
            //
            //                 if (item.sellIn < 6) {
            //                     if (item.quality < 50) {
            //                         item.quality += 1;
            //                     }
            //                 }
            //             }
            //         }
            //     }
            //     // "Sulfuras, Hand of Ragnaros"가 아닌 경우
            //     // 판매 기한이 1 감소
            //     if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            //         item.sellIn -= 1;
            //     }
            //
            //     // 판매 기한이 지난 경우
            //     // "Aged Brie"가 아니고 "Backstage passes to a TAFKAL80ETC concert"도 아닌 경우
            //     // "Sulfuras, Hand of Ragnaros"가 아니고 품질이 양수면 품질 1 감소
            //     // "Backstage passes to a TAFKAL80ETC concert"인 경우 품질 0으로 변경
            //     // "Aged Brie"면서 품질이 50 미만이면 품질 1 증가
            //     if (item.sellIn < 0) {
            //         if (!item.name.equals("Aged Brie")) {
            //             if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            //                 if (item.quality > 0) {
            //                     if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            //                         item.quality -= 1;
            //                     }
            //                 }
            //             } else {
            //                 item.quality = item.quality - item.quality;
            //             }
            //         } else {
            //             if (item.quality < 50) {
            //                 item.quality = item.quality + 1;
            //             }
            //         }
            //     }
        }
    }

    private ItemUpdateStrategy getItemUpdateStrategy(Item item) {
        return strategies.getOrDefault(item.name, strategies.get("default"));
    }
}
