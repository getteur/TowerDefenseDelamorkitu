package com.techies.towerdefensedelamorkitu.app.util;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by elyassbenhdech on 29/05/2014.
 */
public class TowerDefenseDelamorkituSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private TowerDefenseDelamorkituThread thread;
    private static final String TAG = TowerDefenseDelamorkituSurfaceView.class.getSimpleName();

    public TowerDefenseDelamorkituSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);

        // create the game loop thread
        thread = new TowerDefenseDelamorkituThread(getHolder(), this);

        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // try again shutting down the thread
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    }
}
