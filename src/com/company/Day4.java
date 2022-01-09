// Advent od Code 2021
// Day 4: Giant Squid
//https://adventofcode.com/2021/day/4

package com.company;

// It imports all io methods in one
//import java.io.*;

// But nice to know used methods
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    Boolean convertToBoolean(String s)
    {
        if(s == null) 
        {
            throw new IllegalArgumentException("sring cannot be null when converting to boolean"); 
        }

        switch(s)
        {
            case "1": return true;
            case "0": return false;
            default: throw new IllegalArgumentException("string has to be 0 or 1");
        }

    }

    public void calculate()
    {
        String currentDir = System.getProperty("user.dir");
        int numberOfLines = 1;

        // File path is passed as parameter
        // Note:  Double back quote is to avoid compiler interpret words like \test as \t (ie as an escape sequence)
        File file = new File(currentDir + "\\src\\com\\company\\input_Day4.txt");

        try
        {
            // Creating an object of BufferReader class
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Declaring a string variable
            String st;

            //declare of two dimensional array of booleans
            int[][] bufferBoard = new int[5][5];
            String stringToInt;

            int[] drawnNumbers = new int[1000];
            String[] drawNumbersInString = new String[1000];

            int firstDimOfBufferBoard = 0;

            int boardnumber = 0;
            BingoBoard[] arrayOfBingoBoards = new BingoBoard[1000];
            
            // Condition holds true till there is character in a string
            while ((st = br.readLine()) != null)
            {    
                if(numberOfLines == 1) //extract Draw Numbers from the first line
                    {         
                    for(int k = 1, i = 0, j = 0; i < st.length(); k++, i = j + 1)   
                        {
                            j = st.indexOf(",", i);
                            if(j == -1) {j = st.length();} // -1 means no more commas so we're done
                            drawNumbersInString[j] = st.substring(i, j); //extract draw Number from the line
                            if(isNumeric(drawNumbersInString[j]) == true) { drawnNumbers[j] = Integer.parseInt(drawNumbersInString[j]);}
                            System.out.println("Draw Number nr:" + k + " is " + drawnNumbers[j]);
                            if(j == st.length()) {break;}
                        }   
                    }

                if (st.isBlank() == true && numberOfLines > 1)  
                    {
                        arrayOfBingoBoards[boardnumber] = new BingoBoard(bufferBoard);
                        firstDimOfBufferBoard = 0;
                        boardnumber++;

                    }

                if(numberOfLines > 1 && st.isBlank() == false)// extract Boards and save it as object Bingo Boards
                    {
            
                    for(int k = 0, i = 0, j = 0; i < st.length(); k++, i = j + 1)   
                        {
                            j = st.indexOf(" ", i);
                            if(j == -1) {j = st.length();} // -1 means no more spaces so j = last index so we can read the last number in line
                            if(i == j) {i++; j=j+2;} // if i == j means there is two spaces before single digit so we have to agjust i and j
                            stringToInt = st.substring(i, j); //extract draw Number from the line
                            if(isNumeric(stringToInt) == true) { bufferBoard[firstDimOfBufferBoard][k] = Integer.parseInt(stringToInt);}
                            System.out.println("bufferBoard["+firstDimOfBufferBoard+"]["+k+"] is " + bufferBoard[firstDimOfBufferBoard][k]);
                            if(j == st.length()) {break;}
                        }
                       
                    firstDimOfBufferBoard++;
                    System.out.println("\nNowa linia.\n");
                    }
                    
                numberOfLines++;
            }

            arrayOfBingoBoards[0].printBoard();


            // close opened buffer reader
            br.close();

            // print the number of lines in a file
            System.out.println("Number of lines in a file: " + numberOfLines);
        }
        // try {} catch {} for handling exceptions if file doses not exists
        catch (FileNotFoundException e) { System.err.println("File does not exist"); }
        catch (IOException e) { System.err.println("File exists, but there was IOException"); }
    }
}