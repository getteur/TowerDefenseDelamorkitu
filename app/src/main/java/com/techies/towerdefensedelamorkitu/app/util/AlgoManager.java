package com.techies.towerdefensedelamorkitu.app.util;

import com.techies.towerdefensedelamorkitu.app.model.Item;
import com.techies.towerdefensedelamorkitu.app.model.ItemType;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class AlgoManager {

    private Map<Item, Boolean> visited = new HashMap<Item, Boolean>();

    private Map<Item, Item> previous = new HashMap<Item, Item>();

    public static void updateItemList(Item[][] map, List<Item> items){
        //update the item List
        if(items == null || items.size() < 1){
            return;
        }
        Item exit = findExitItem(items);

        for(Item item:items){
            if(item == null){
                continue;
            }
            if(!hasToMoveItem(item)){
                continue;
            }
            // Find the best way to the exit.
        }
    }

    private static boolean hasToMoveItem(Item item){
        if(ItemType.Entry.equals(item.getType())){
            return false;
        }
        if(ItemType.Exit.equals(item.getType())){
            return false;
        }
        if(ItemType.Blank.equals(item.getType())){
            return false;
        }
        if(ItemType.MapLimit.equals(item.getType())){
            return false;
        }
        return true;
    }

    private static Item findExitItem(List<Item> items){
        for(Item item:items){
            if(ItemType.Exit.equals(item.getType())){
                return item;
            }
        }
        throw new IllegalStateException("No exit for the enemies !");
    }


    public List getDirections(Item start, Item finish, Item[][] itemsMap){
        List<Item> directions = new LinkedList<Item>();
        Queue<Item> q = new LinkedList<Item>();
        Item current = start;
        q.add(current);
        visited.put(current, true);
        while(!q.isEmpty()){
            current = q.remove();
            if (current.equals(finish)){
                break;
            }else{
                for(Item item : getNeighbors(current, itemsMap)){
                    if(!visited.containsKey(item)){
                        q.add(item);
                        visited.put(item, true);
                        previous.put(item, current);
                    }
                }
            }
        }
        if (!current.equals(finish)){
            System.out.println("can't reach destination");
        }
        for(Item item = finish; item != null; item = previous.get(item)) {
            directions.add(item);
        }

        Collections.reverse(directions);
        return directions;
    }

    private List<Item> getNeighbors(Item item, Item[][] itemsMap) {
        List<Item> neighbors = new LinkedList<Item>();
        int x = item.getX();
        int y = item.getY();
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (a == 1 && b == 1) {
                    // The initial item itself.
                    continue;
                }
                int neighborX = x - 1 + b;
                int neighborY = y - 1 + a;
                if (neighborX < 0 || neighborX >= itemsMap[0].length) {
                    // Out of bound.
                    continue;
                }
                if (neighborY < 0 || neighborY >= itemsMap.length) {
                    // Out of bound.
                    continue;
                }
                if (isValidNeighbor(itemsMap[neighborX][neighborY])) {
                    neighbors.add(itemsMap[neighborX][neighborY]);
                }
            }
        }
        return neighbors;
    }

    /**
     * Indique s'il le voisin est un espace vide, sur lequel l'item peut aller.
     */
    private boolean isValidNeighbor(Item item){
        if(ItemType.Blank.equals(item.getType())){
            return true;
        }
        if(ItemType.Unit.equals(item.getType())){
            return true;
        }
        return false;
    }

}