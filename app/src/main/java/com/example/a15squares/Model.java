package com.example.a15squares;

public class Model {
    public int numSquares = 5; // Initializes the grid to 4 squares
    public int seed = (numSquares-1) * (numSquares-1); // Grid size
    public int [][] board = new int[numSquares-1][numSquares-1]; // Board values

    // Test whether the two squares are valid selections
    public boolean isBlank = false;
    public boolean isNextTo = false;

    public boolean resetTouched = true; // Reset button pressed

    // Location of blank square
    public double blankX = numSquares-2;
    public double blankY = numSquares-2;

    // Location of other valid square selected
    public double squareX = 0;
    public double squareY = 0;

    // Location of just touched
    public float touchX = 0;
    public float touchY = 0;



}
