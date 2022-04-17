// Advent od Code 2021
// Day 1: Sonar Sweep
//https://adventofcode.com/2021/day/1

package com.company;

// It imports all io methods in one
//import java.io.*;

// But nice to know used methods
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Day1
{
    public void calculate()
    {
        String currentDir = System.getProperty("user.dir");
        int numberOfLines = 0;
        int sizeOfArray = 2000;

        // declares an array of integers
        int[] InputLinesInArray;
        // allocates memory for array
        InputLinesInArray = new int[sizeOfArray];

        // File path is passed as parameter
        // Note:  Double back quote is to avoid compiler interpret words like \test as \t (ie as an escape sequence)
        File file = new File (currentDir + "/src/main/java/com/company/input_Day1.txt");

        try
        {
            // Creating an object of BufferReader class
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Declaring a string variable
            String st;

            // Condition holds true till there is character in a string
            while ((st = br.readLine()) != null)
            {
                //exception handling (throw new) to prevent from array overloading
                if (numberOfLines + 1 > sizeOfArray) 
                {
                    //when exception occurs also opened buffer has to be closed
                    br.close();

                    throw new IllegalArgumentException("array InputLinesInArray overloaded, check if numberOfLines > sizeOfArray");
                }
                
                // convert string from read file line into int with error handling
                try
                {

                    //convert string to integer
                    int number = Integer.parseInt(st);

                    // save each line in array
                    InputLinesInArray[numberOfLines] = number;

                    //print current line
                    System.out.println(InputLinesInArray[numberOfLines]);

                }
                // try {} catch {} for handling exceptions if string from read file line is not numeric
                catch (NumberFormatException ex) {ex.printStackTrace();}

                numberOfLines++;
            }

            // close opened buffer reader
            br.close();

            // print the number of lines in a file
            System.out.println("Number of lines in a file: " + numberOfLines);

        }
        // try {} catch {} for handling exceptions if file doses not exists
        catch (FileNotFoundException e) { System.err.println("File does not exist"); }
        catch (IOException e) { System.err.println("File exists, but there was IOException"); }

        int increased = 0;
        int decreased = 0;
        int staysTheSame = 0;

        for (int i = 1; i < sizeOfArray; i++)
        {
            if (InputLinesInArray[i] > InputLinesInArray[i-1]) { increased++; }
            else if (InputLinesInArray[i] < InputLinesInArray[i-1]) { decreased++; }
            else  { staysTheSame++; }
        }

        System.out.println("Number of increased: " + increased);
        System.out.println("Number of decreased: " + decreased);
        System.out.println("Number of staysTheSame: " + staysTheSame);
    }
}
