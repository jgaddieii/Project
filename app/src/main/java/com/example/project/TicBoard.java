package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TicBoard extends View {

    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int lineWinningColor;

    private boolean winningLine = false;
    private final Paint paint = new Paint();
    private final TicLogic game;
    private int cellSize = getWidth() / 3;

    public TicBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        game = new TicLogic();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicBoard, 0, 0);

        try {
            boardColor = a.getInteger(R.styleable.TicBoard_boardColor, 0);
            XColor = a.getInteger(R.styleable.TicBoard_XColor, 0);
            OColor = a.getInteger(R.styleable.TicBoard_OColor, 0);
            lineWinningColor = a.getInteger(R.styleable.TicBoard_lineWinningColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension / 3;
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawTicBoard(canvas);
        drawMarkers(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            int row = (int)Math.ceil(y / cellSize);
            int col = (int)Math.ceil(x / cellSize);

            if(!winningLine) {
                if (game.updateTicBoard(row, col)) {
                    invalidate();
                    if(game.winner()){
                        winningLine = true;
                        invalidate();
                    }
                    if (game.getPlayer() % 2 == 0) {
                        game.setPlayer(game.getPlayer() - 1);
                    } else {
                        game.setPlayer(game.getPlayer() + 1);
                    }
                }
            }

            invalidate();

            return true;
        }
        return false;
    }

    private void drawTicBoard(Canvas canvas) {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);
        for (int col = 1; col < 3; col++) {
            canvas.drawLine(cellSize * col, 0, cellSize * col, canvas.getWidth(), paint);
        }

        for (int row = 1; row < 3; row++) {
            canvas.drawLine(0, cellSize * row, canvas.getWidth(), cellSize * row, paint);
        }
    }

    private void drawMarkers(Canvas canvas){
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if (game.getTicBoard()[row][col] != 0){
                    if (game.getTicBoard()[row][col] != 1){
                        drawX(canvas, row, col);
                    }
                    else{
                        drawO(canvas, row, col);
                    }
                }
            }
        }
    }

    private void drawX(Canvas canvas, int row, int col) {
        paint.setColor(XColor);
        canvas.drawLine((float) ((col + 1) * cellSize - cellSize * 0.2),
                        (float) (row * cellSize + cellSize * 0.2),
                        (float) (col * cellSize + cellSize * 0.2),
                        (float) ((row + 1) * cellSize - cellSize * 0.2),
                        paint);

        canvas.drawLine((float) (col * cellSize + cellSize * 0.2),
                        (float) (row * cellSize + cellSize * 0.2),
                        (float) ((col + 1) * cellSize - cellSize * 0.2),
                        (float) ((row + 1) * cellSize - cellSize * 0.2),
                        paint);
    }

    private void drawO(Canvas canvas, int row, int col) {
        paint.setColor(OColor);
        canvas.drawOval((float) (col * cellSize + cellSize * 0.2),
                        (float) (row * cellSize + cellSize * 0.2),
                        (float) ((col * cellSize + cellSize) - cellSize * 0.2),
                        (float) ((row * cellSize + cellSize) - cellSize * 0.2),
                        paint);
    }

    public void setUpGame(Button playAgain, Button home, TextView playerDisplay, String[] names){
        game.setPlayAgainBtn(playAgain);
        game.setHomeBtn(home);
        game.setPlayerDisplay(playerDisplay);

        if (!names[0].equals("") && !names[1].equals("")){
            game.setPlayerNames(names);
        }
    }

    public void playAgain(){
        game.playAgain();
        winningLine = false;
    }
}
