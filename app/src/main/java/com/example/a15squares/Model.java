package com.example.a15squares;

public class Model {

    //Grid size
    public int numSquares = 3;
    public int seed = (numSquares-1) * (numSquares-1);

    //Board values
    public int [][] board = new int[numSquares-1][numSquares-1];
    public int [] solution = new int[seed];

    //Test whether two squares were selected
    public boolean isBlank = false;
    public boolean isNextTo = false;
    public boolean resetTouched = true;

    public double blankX = numSquares-2;
    public double blankY = numSquares-2;

    public double squareX = 0;
    public double squareY = 0;

    public float touchX = 0;
    public float touchY = 0;



}
