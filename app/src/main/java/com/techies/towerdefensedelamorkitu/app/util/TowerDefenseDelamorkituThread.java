package com.techies.towerdefensedelamorkitu.app.util;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.util.ArrayList;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class TowerDefenseDelamorkituThread extends Thread{
    private static final String TAG = TowerDefenseDelamorkituSurfaceView.class.getSimpleName();

    private SurfaceHolder surfaceHolder;
    private TowerDefenseDelamorkituSurfaceView _superGameSurfaceView;

    private int _screenHeight = 0;
    private int _screenWidth = 0;
    private long _lastGeneration = 0;
    private int _minTime = 2000;
    private int _maxTime = 5000;

    private boolean running;
    private final static int 	MAX_FPS = 50;
    private final static int	MAX_FRAME_SKIPS = 5;
    private final static int	FRAME_PERIOD = 1000 / MAX_FPS;




    public TowerDefenseDelamorkituThread(SurfaceHolder surfaceHolder, TowerDefenseDelamorkituSurfaceView gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this._superGameSurfaceView = gamePanel;

    }

    private void init(){
        this._screenHeight = this._superGameSurfaceView.getHeight();
        this._screenWidth = this._superGameSurfaceView.getWidth();
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
        }
    }

    public void setRunning(boolean running) {

        this.running = running;
    }
}
