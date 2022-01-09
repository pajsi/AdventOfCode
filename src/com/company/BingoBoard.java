package com.company;

class BingoBoard{

    int[][] board = new int[5][5];

    boolean[][] boardMarked = new boolean[5][5];

    public BingoBoard(int[][] board)
    {


    }

    public void update()
    {

    }

    public void printBoard()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.println("Board[" + i + "][" + j + "]: " + board[i][j]);
            }
        }
    }

    public void checkRows()
    {

    }
    
}
