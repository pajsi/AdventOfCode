package com.company;

class BingoBoard
{
    private int[][] board = new int[5][5];

    private boolean[][] boardMarked = new boolean[5][5];

    public BingoBoard(int[][] board)
    {
        this.board = board;

        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                boardMarked[i][j] = false;
            }
        }
    }

    public void updateBoard(int number)
    {
        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                if(board[i][j] == number)
                {
                    boardMarked[i][j] = true;
                }

            }
        }
    }

    public void printBoard()
    {
        System.out.println("      "+board[0][0] +" "+ board[0][1]+" "+ board[0][2] +" "+ board[0][3] +" "+ board[0][4]);
        System.out.println("      "+board[1][0] +" "+ board[1][1]+" "+ board[1][2] +" "+ board[1][3] +" "+ board[1][4]);
        System.out.println("      "+board[2][0] +" "+ board[2][1]+" "+ board[2][2] +" "+ board[2][3] +" "+ board[2][4]);
        System.out.println("      "+board[3][0] +" "+ board[3][1]+" "+ board[3][2] +" "+ board[3][3] +" "+ board[3][4]);
        System.out.println("      "+board[4][0] +" "+ board[4][1]+" "+ board[4][2] +" "+ board[4][3] +" "+ board[4][4]);    
    }

    public boolean checkIfWin()
    {
        if(boardMarked[0][0] && boardMarked[0][1] && boardMarked[0][2] && boardMarked[0][3] && boardMarked[0][4]) {return true;}
        if(boardMarked[1][0] && boardMarked[1][1] && boardMarked[1][2] && boardMarked[1][3] && boardMarked[1][4]) {return true;}
        if(boardMarked[2][0] && boardMarked[2][1] && boardMarked[2][2] && boardMarked[2][3] && boardMarked[2][4]) {return true;}
        if(boardMarked[3][0] && boardMarked[3][1] && boardMarked[3][2] && boardMarked[3][3] && boardMarked[3][4]) {return true;}
        if(boardMarked[4][0] && boardMarked[4][1] && boardMarked[4][2] && boardMarked[4][3] && boardMarked[4][4]) {return true;}

        if(boardMarked[0][0] && boardMarked[1][0] && boardMarked[2][0] && boardMarked[3][0] && boardMarked[4][0]) {return true;}
        if(boardMarked[0][1] && boardMarked[1][1] && boardMarked[2][1] && boardMarked[3][1] && boardMarked[4][1]) {return true;}
        if(boardMarked[0][2] && boardMarked[1][2] && boardMarked[2][2] && boardMarked[3][2] && boardMarked[4][2]) {return true;}
        if(boardMarked[0][3] && boardMarked[1][3] && boardMarked[2][3] && boardMarked[3][3] && boardMarked[4][3]) {return true;}
        if(boardMarked[0][4] && boardMarked[1][4] && boardMarked[2][4] && boardMarked[3][4] && boardMarked[4][4]) {return true;}

        else return false;
    }

    public int getWinningScore(int numberThatWasJustCalled)
    {
        int finalScore = 0;
        int sumOfAllUnmarkedNumbers = 0;
             
        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                if(!boardMarked[i][j])
                {
                    sumOfAllUnmarkedNumbers = sumOfAllUnmarkedNumbers + board[i][j];
                }
            }
        }

        finalScore = sumOfAllUnmarkedNumbers * numberThatWasJustCalled;
        return finalScore;
    }
}
