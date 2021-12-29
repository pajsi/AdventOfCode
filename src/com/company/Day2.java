// Advent od Code 2021
// Day 2: Dive!
//https://adventofcode.com/2021/day/2

package com.company;

// It imports all io methods in one
//import java.io.*;

// But nice to know used methods
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2
{
    public void calculate()
    {
        String currentDir = System.getProperty("user.dir");
        int numberOfLines = 0;
        int sizeOfArray = 1000;

        // declares an array of integers
        String[] InputLinesInArray;
        // allocates memory for array
        InputLinesInArray = new String[sizeOfArray];

        // File path is passed as parameter
        // Note:  Double back quote is to avoid compiler interpret words like \test as \t (ie as an escape sequence)
        File file = new File(currentDir + "\\src\\com\\company\\input_Day2.txt");

        try
        {
            // Creating an object of BufferReader class
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Declaring a string variable
            String st;

            // Condition holds true till there is character in a string
            while ((st = br.readLine()) != null)
            {
                // save each line in array
                InputLinesInArray[numberOfLines] = st;

                //print current line
                System.out.println(InputLinesInArray[numberOfLines]);

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


    }
}
