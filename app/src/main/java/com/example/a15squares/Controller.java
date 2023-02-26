package com.example.a15squares;

import android.view.MotionEvent;
import android.widget.SeekBar;


public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, android.view.View.OnTouchListener{

    private View initView;
    private Model initModel;

    public Controller(View view) {
        initView = view;
        initModel = view.getModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        initModel.numSquares = i + 3;
        initModel.seed = (initModel.numSquares-1) * (initModel.numSquares-1);
        initModel.board = new int[initModel.numSquares-1][initModel.numSquares-1];
        initModel.resetTouched = true;
        initView.invalidate();
    }
    public void onStartTrackingTouch(SeekBar seekBar) {}
    public void onStopTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onClick(android.view.View view) {
        initModel.resetTouched = true;
        initView.invalidate();
        //initModel.resetTouched = false;
    }
    @Override
    public boolean onTouch(android.view.View view, MotionEvent motionEvent) {

        //Determines the touch on the grid
        initModel.touchX = (float) Math.floor((motionEvent.getX()/view.getWidth()) * (initModel.numSquares-1));
        initModel.touchY = (float) Math.floor((motionEvent.getY()/view.getHeight()) * (initModel.numSquares-1));

        //Determines blank or not
        if (initModel.touchX == initModel.blankX && initModel.touchY == initModel.blankY) {
            initModel.isBlank = true;
        } else if (initModel.touchX == initModel.blankX || initModel.touchY == initModel.blankY) {
            if (initModel.touchX == initModel.blankX+1 || initModel.touchX == initModel.blankX-1) {
                initModel.isNextTo = true;
                initModel.squareX = initModel.touchX;
                initModel.squareY = initModel.touchY;
            } else if (initModel.touchY == initModel.blankY+1 || initModel.touchY == initModel.blankY-1) {
                initModel.isNextTo = true;
                initModel.squareX = initModel.touchX;
                initModel.squareY = initModel.touchY;
            }
        } else {
            initModel.isBlank = false;
            initModel.isNextTo = false;
        }

        initView.invalidate();
        return false;
    }
}
