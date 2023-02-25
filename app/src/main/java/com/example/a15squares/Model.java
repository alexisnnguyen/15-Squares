package com.example.a15squares;

public class Model {

    //Test whether two squares were selected
    public boolean touch = false;
    public boolean touch2 = false;

    //Stores value of the squares
    public int square1 = 0;
    public int square2 = 0;

    //Grid size
    public int numSquares = 5;
    public int seed = (numSquares-1) * (numSquares-1);

    //Board values
    public int [][] board = new int[numSquares-1][numSquares-1];

}
