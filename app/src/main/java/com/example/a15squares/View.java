package com.example.a15squares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.Random;

public class View extends SurfaceView{

    Paint squares = new Paint();
    Paint border = new Paint();
    Paint number = new Paint();

    private Model model = new Model();
    public Model getModel() {
        return model;
    }
    public int [] array = new int[model.seed];



    public View(Context context, AttributeSet attrs) {
        super(context,attrs);
        setWillNotDraw(false);

        squares.setColor(0xFFFDD1D2);
        squares.setStyle(Paint.Style.FILL);
        border.setColor(Color.BLACK);
        border.setStyle(Paint.Style.FILL);
        number.setColor(Color.BLACK);

        setBackgroundColor(Color.WHITE);

    }

    public void resetBoard() {

        //Random array
        Random rand = new Random();

        for (int i = 1; i < model.seed; i++) {
            array[i-1] = i;
        }
        array[model.seed-1] = 0;

        //Shuffle
        for (int i = 0; i < model.seed-1; i++) {
            int randIndex = rand.nextInt(model.seed-1);
            //Switches the value with a random index
            int temp = array[i];
            array[i] = array[randIndex];
            array[randIndex] = temp;
        }

        int count = 0;
        for (int row = 0; row < model.numSquares-1; row++) {
            for ( int col = 0; col < model.numSquares-1; col++) {
                model.board[row][col] = array[count];
                count++;
            }
        }

    }

    public void onDraw(Canvas canvas) {

        float borderWidth = 10.0f;
        float numSquares = model.numSquares;
        float backWidth = canvas.getWidth();
        float backHeight = canvas.getWidth();
        float squareSize = (canvas.getWidth()-(borderWidth*numSquares))/(numSquares-1);
        number.setTextSize(300/numSquares);

        //Draws the background
        canvas.drawRect(0, 0, backWidth, backHeight, border);

        //Draws the squares
        for (int i = 1; i < numSquares; i++) {
            for (int j = 1; j < numSquares; j++) {
                canvas.drawRect(borderWidth*i + squareSize*(i-1), borderWidth*j + squareSize*(j-1),
                        borderWidth*i + squareSize*i, borderWidth*j + squareSize*j, squares);
            }
        }

        //Reset the board
        resetBoard();

        //Draws the numbers
        for (int i = 1; i < numSquares; i++) {
            for (int j = 1; j < numSquares; j++) {
                if (i != numSquares-1 || j != numSquares-1) {
                    canvas.drawText(String.valueOf(model.board[i-1][j-1]), borderWidth * i + squareSize / numSquares + squareSize * (i - 1),
                            borderWidth * j + squareSize * 2 / 3 + squareSize * (j - 1), number);
                }
            }
        }


    }
}
