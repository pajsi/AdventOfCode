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
    //declare function to chceck if string is numeric
    public Boolean isNumeric(String strNum)
    {
        if(strNum == null) {return false;}
        try {double d = Double.parseDouble(strNum);} catch (NumberFormatException nfe) {return false;}
        return true;

    }

    public void calculate()
    {
        String currentDir = System.getProperty("user.dir");
        int numberOfLines = 0;
        int sizeOfArray = 1000;

        int depth = 0;
        int horPos = 0;

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

                // Separate input string to substring and number
                for (int i = 0, j = 0; i < InputLinesInArray[numberOfLines].length(); i = j + 1)
                    {
                        j = InputLinesInArray[numberOfLines].indexOf(" ", i); //find the next space
                        if (j == -1) {break;} // -1 means no more spaces so we're done
                        String direction = InputLinesInArray[numberOfLines].substring(i, j); //extract directtion which we eill be moving
                        String valueString = InputLinesInArray[numberOfLines].substring(j + 1, InputLinesInArray[numberOfLines].length()); //extract value
                        int valueInt;

                        //System.out.println(direction);
                        //System.out.println(value);

                        if (isNumeric(valueString) == true) {valueInt = Integer.parseInt(valueString);}
                        else {valueInt = 0;}

                        if(direction.equals("up")) {depth = depth - valueInt;}
                        if(direction.equals("down")) {depth = depth + valueInt;}
                        if(direction.equals("forward")) {horPos = horPos + valueInt;}
                    }

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

        System.out.println("Depth: " + depth);
        System.out.println("Horizontal Position: " + horPos);
        System.out.println("Final Position: " + horPos*depth);

    }
}
