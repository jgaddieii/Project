package com.example.project;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicLogic {
    private int[][] ticBoard;
    private Button playAgainBtn;
    private Button homeBtn;
    private TextView playerDisplay;
    private String[] playerNames = {"Player 1", "Player 2"};
    private int player = 1;
    TicLogic(){
        ticBoard = new int[3][3];
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                ticBoard[row][col] = 0;
            }
        }
    }

    public boolean updateTicBoard(int row, int col){
        if (ticBoard[row - 1][col - 1] == 0){
            ticBoard[row - 1][col - 1] = player;

            if (player == 1){
                playerDisplay.setText(playerNames[1] + "'s Turn!");
            }
            else{
                playerDisplay.setText(playerNames[0] + "'s Turn!");
            }
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean winner() {
        boolean isWinner = false;

        for (int row = 0; row < 3; row++) {
            if (ticBoard[row][0] == ticBoard[row][1] && ticBoard[row][0] == ticBoard[row][2] && ticBoard[row][0] != 0) {
                isWinner = true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (ticBoard[0][col] == ticBoard[1][col] && ticBoard[2][col] == ticBoard[0][col] && ticBoard[0][col] != 0) {
                isWinner = true;
            }
        }
        if (ticBoard[0][0] == ticBoard[1][1] && ticBoard[0][0] == ticBoard[2][2] && ticBoard[0][0] != 0) {
            isWinner = true;
        }
        if (ticBoard[2][0] == ticBoard[1][1] && ticBoard[2][0] == ticBoard[0][2] && ticBoard[2][0] != 0) {
            isWinner = true;
        }
        int boardFill = 0;
        for (int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                if(ticBoard[row][col] != 0){
                    boardFill += 1;
                }
            }
        }
        if (isWinner){
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerDisplay.setText((playerNames[player - 1] + "Won!"));
            return true;
        }
        else if(boardFill == 9){
            playAgainBtn.setVisibility(View.VISIBLE);
            homeBtn.setVisibility(View.VISIBLE);
            playerDisplay.setText(("Tied"));
            return true;
        }
        else{
            return false;
        }
    }

    public void playAgain(){
        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ticBoard[row][col] = 0;
            }
        }
    }

    public void setPlayAgainBtn(Button playAgainBtn){
        this.playAgainBtn = playAgainBtn;
    }

    public void setHomeBtn(Button homeBtn){
        this.homeBtn = homeBtn;
    }

    public void setPlayerDisplay(TextView playerDisplay){
        this.playerDisplay = playerDisplay;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getTicBoard() {
        return ticBoard;
    }

    public void setPlayer(int player){
        this.player = player;
    }
    public int getPlayer(){
        return player;
    }
}
