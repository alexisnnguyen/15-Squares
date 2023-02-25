package com.example.a15squares;

import android.widget.Button;
import android.widget.SeekBar;

public class Controller implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{

    private View initView;
    private Model initModel;

    public Controller(View view) {
        initView = view;
        initModel = view.getModel();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        initModel.numSquares = i + 5;
        initModel.seed = (initModel.numSquares-1) * (initModel.numSquares-1);
        initModel.board = new int[initModel.numSquares-1][initModel.numSquares-1];
        initView.invalidate();
    }
    public void onStartTrackingTouch(SeekBar seekBar) {}
    public void onStopTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onClick(android.view.View view) {
        initView.invalidate();
    }

}
