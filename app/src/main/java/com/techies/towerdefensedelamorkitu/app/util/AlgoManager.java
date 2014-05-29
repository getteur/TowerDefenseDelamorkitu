package com.techies.towerdefensedelamorkitu.app.util;

import com.techies.towerdefensedelamorkitu.app.model.Item;
import com.techies.towerdefensedelamorkitu.app.model.ItemType;

import java.util.List;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class AlgoManager {

    public static void updateItemList(Item[][] map, List<Item> items){
        //update the item List
        if(items == null || items.size() < 1){
            return;
        }
        for(Item item:items){
            if(item == null){
                continue;
            }
            Item exit = findExit(items);
            // Find the best way to the exit.
        }
    }

    private static Item findExit(List<Item> items){
        for(Item item:items){
            if(ItemType.Exit.equals(item.getType())){
                return item;
            }
        }
        throw new IllegalStateException("No exit for the enemies !");
    }

    private void  TEMP(Item[][] itemsMap){
        for(int a=0; a < itemsMap.length; a++){
            Item[] itemsLine = itemsMap[a];
            for(int b=0; b < itemsLine.length; b++){
                Item currentItem ;
            }
        }
    }

}