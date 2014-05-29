package com.techies.towerdefensedelamorkitu.app.util;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.techies.towerdefensedelamorkitu.app.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class TowerDefenseDelamorkituThread extends Thread{
    private static final String TAG = TowerDefenseDelamorkituSurfaceView.class.getSimpleName();

    private SurfaceHolder surfaceHolder;
    private TowerDefenseDelamorkituSurfaceView _superGameSurfaceView;

    private int _mapX = 0;
    private int _mapY = 0;
    private int _itemX = 20;
    private int _itemY = 20;
    private int _screenHeight = 0;
    private int _screenWidth = 0;
    private long _lastGeneration = 0;
    private int _minTime = 2000;
    private int _maxTime = 5000;

    private boolean running;
    private final static int 	MAX_FPS = 50;
    private final static int	MAX_FRAME_SKIPS = 5;
    private final static int	FRAME_PERIOD = 1000 / MAX_FPS;

    private MapManager _mapManager;
    private Renderer _renderer;

    private Item[][] _map;
    private List<Item> _items;




    public TowerDefenseDelamorkituThread(SurfaceHolder surfaceHolder, TowerDefenseDelamorkituSurfaceView gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this._superGameSurfaceView = gamePanel;

    }

    private void init(){
        this._screenHeight = this._superGameSurfaceView.getHeight();
        this._screenWidth = this._superGameSurfaceView.getWidth();
        this._mapX = _screenWidth / _itemX;
        this._mapY = _screenHeight / _itemY;
        _mapManager = MapManager.getInstance();
        _map = new Item[_mapX][_mapY];
        _renderer = new Renderer();
    }


    @Override
    public void run() {
        Canvas canvas;

        long beginTime;
        long timeDiff;
        int sleepTime = 0;
        int framesSkipped;

        init();
        while (running) {
            canvas = null;
            _renderer.display(_items);
            _items = _mapManager.getItemList(_map, _items);
        }
    }

    public void setRunning(boolean running) {

        this.running = running;
    }
}
