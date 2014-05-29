package com.techies.towerdefensedelamorkitu.app.util;

import com.techies.towerdefensedelamorkitu.app.model.Item;

import java.util.List;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class MapManager {

    private static MapManager _instance = null;
    private List<Item> _itemList = null;

    private int _mapX = 0;
    private int _mapY = 0;

    private MapManager(){

    }

    public static MapManager getInstance(){
        if (_instance == null)
            _instance = new MapManager();
        return _instance;
    }

    public Item[][]  InitMap(int x, int y){
        _mapX = x;
        _mapY = y;
        return null;
    }

    public List<Item> getItemList(Item[][] map, List<Item> items){
        // compute new items position

        //add Items if needed
        return _itemList;
    }


}
