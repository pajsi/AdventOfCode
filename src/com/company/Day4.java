// Advent od Code 2021
// Day 4: Giant Squid
//https://adventofcode.com/2021/day/4

package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4
{
    //declare function to chceck if string is numeric
    Boolean isNumeric(String strNum)
    {
        try 
        {
            double d = Double.parseDouble(strNum);
        } 
        catch (Exception e) {System.out.println("Exception: " + e); return false;}
        return true;
    }

    public void calculate()
    {
        String currentDir = System.getProperty("user.dir");
        File fileInputData = new File(currentDir + "\\src\\com\\company\\input_Day4.txt");

        List<Integer> listOfDrawnNumbers = new ArrayList<Integer>();

        List<BingoBoard> listOfBingoBoards = new ArrayList<BingoBoard>();

        try
        {
            // Creating an object of BufferReader class
            BufferedReader bufferForReadingLine = new BufferedReader(new FileReader(fileInputData));

            int lineNumber = 1;

            // Declaring a string variable for reading each line
            String actualLineContent;

            // Declare of two dimensional array list
            ArrayList<int[][]> listOfBufferBoards = new ArrayList<int[][]>();

            // create first blank Buffer Bingo Board
            listOfBufferBoards.add(new int[5][5]);

            String stringToInt;
            int firstDimOfBufferBoard = 0;
            int boardnumber = 0;
            
            System.out.println("");

            // Condition holds true till there is character in a string
            while ((actualLineContent = bufferForReadingLine.readLine()) != null)
            {    
                if(lineNumber == 1) //extract Draw Numbers from the first line
                    {         
                    for(int k = 0, i = 0, j = 0; i < actualLineContent.length(); k++, i = j + 1)   
                        {
                            j = actualLineContent.indexOf(",", i);
                            if(j == -1) {j = actualLineContent.length();} // -1 means no more commas so we're done
                            if(isNumeric(actualLineContent.substring(i, j)) == true) {listOfDrawnNumbers.add(Integer.parseInt(actualLineContent.substring(i, j)));} //extract Draw Number from the line and ,if numeric, save to list of drawNumbers
                            System.out.println("Draw Number nr:" + k + " is " + listOfDrawnNumbers.get(k));
                            if(j == actualLineContent.length()) {break;}
                        }   
                    } 

                if (actualLineContent.isBlank() == true && lineNumber > 2)  // if there is a blank line in a file it means our bufferBoard is full and we can create next bingo board object
                    {
                        System.out.println("");

                        // create a new object of BingoBoard using 
                        BingoBoard bufferBingoBoard = new BingoBoard(listOfBufferBoards.get(listOfBufferBoards.size()-1));
                        listOfBingoBoards.add(bufferBingoBoard);

                        System.out.println("        Board["+boardnumber+"]");
                        listOfBingoBoards.get(listOfBingoBoards.size()-1).printBoard();

                        firstDimOfBufferBoard = 0;
                        boardnumber++;

                        // create new blank Buffer Bingo Board to wchich readed lines will be saved
                        listOfBufferBoards.add(new int[5][5]);
                    }

                if(lineNumber > 1 && actualLineContent.isBlank() == false)// extract Boards
                    {
                        
                    for(int k = 0, i = 0, j = 0; i < actualLineContent.length(); k++, i = j + 1)   
                        {
                            j = actualLineContent.indexOf(" ", i);
                            if(j == -1) {j = actualLineContent.length();} // -1 means no more spaces so j = last index so we can read the last number in line
                            if(i == j) {i++; j=j+2;} // if i == j means there is two spaces before single digit so we have to agjust i and j
                            stringToInt = actualLineContent.substring(i, j); //extract Number from the line
                            if(isNumeric(stringToInt) == true) { listOfBufferBoards.get(listOfBufferBoards.size()-1)[firstDimOfBufferBoard][k] = Integer.parseInt(stringToInt);} // save Number to the next place
                            if(j == actualLineContent.length()) {break;}
                        }
                       
                    firstDimOfBufferBoard++;
                    }
                    
                lineNumber++;
            }

            //to save last board as an object 
            System.out.println("");
            BingoBoard bufferBingoBoard = new BingoBoard(listOfBufferBoards.get(listOfBufferBoards.size()-1));
            listOfBingoBoards.add(bufferBingoBoard);
            System.out.println("        Board["+boardnumber+"]");
            listOfBingoBoards.get(listOfBingoBoards.size()-1).printBoard();

            // close opened buffer reader
            bufferForReadingLine.close();

            System.out.println("");
            System.out.println("Number of lines in a file: " + lineNumber);
            System.out.println("");
        }
        // try {} catch {} for handling exceptions if file doses not exists
        catch (FileNotFoundException e) { System.err.println("File does not exist"); }
        catch (IOException e) { System.err.println("File exists, but there was IOException"); }


        outer: for(int i = 0; i < listOfDrawnNumbers.size(); i++) 
            {
                for(int j = 0; j < listOfBingoBoards.size(); j++)
                    {
                        listOfBingoBoards.get(j).updateBoard(listOfDrawnNumbers.get(i));

                        if(listOfBingoBoards.get(j).checkIfWin() == true)
                            {
                                System.out.println("We have a winner!");
                                System.out.println("Board["+j+"] after Drawn Number nr: "+i+", that is number "+listOfDrawnNumbers.get(i));
                                System.out.println("");
                                System.out.println("Winning score: " + listOfBingoBoards.get(j).getWinningScore(listOfDrawnNumbers.get(i)));
                                System.out.println("");
                                break outer;
                            }
                        
                    }
            } 

    }
}