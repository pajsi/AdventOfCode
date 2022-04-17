// Advent od Code 2021
// Day 3: Binary Diagnostic
//https://adventofcode.com/2021/day/3

package com.company;

// It imports all io methods in one
//import java.io.*;

// But nice to know used methods
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3
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
        int numberOfLines = 0;
        int sizeOfArray = 1000;

        // File path is passed as parameter
        // Note:  Double back quote is to avoid compiler interpret words like \test as \t (ie as an escape sequence)
        File file = new File(currentDir + "/src/main/java/com/company/input_Day3.txt");

        try
        {
            // Creating an object of BufferReader class
            BufferedReader br = new BufferedReader(new FileReader(file));

            //Declaring a string variable
            String st;

            //declare of two dimensional array of booleans
            boolean[][] twoD_arr = new boolean[sizeOfArray][12];

            //
            int[] mostCommonValue = new int[12];
            boolean[] mostCommonValueInBool = new boolean[12];

            //
            int currFirstDim = 0;


            
            // Condition holds true till there is character in a string and string is a number
            while ((st = br.readLine()) != null)
            {                
                    // chceck if readed line is a number, if not dont add string line to array and continue
                    if(isNumeric(st))
                    {
                        for(int j = 0; j < 12; j++)
                        {
                            //
                            twoD_arr[currFirstDim][j] = convertToBoolean(st.substring(j, j + 1));

                            // print the values to check if we read correct
                            if(twoD_arr[currFirstDim][j]) {System.out.print("1"); mostCommonValue[j]++;}
                            if(!twoD_arr[currFirstDim][j]) {System.out.print("0"); mostCommonValue[j]--;}
                        }
                    }

                    System.out.print("\n");
                    currFirstDim++;
                

                numberOfLines++;
            }

            // close opened buffer reader
            br.close();

            // print the number of lines in a file
            System.out.println("Number of lines in a file: " + numberOfLines);

            // print specific line using array to check if data is right
            System.out.print("twoD_arr[2][k]: " + twoD_arr[2][0] +" "+  twoD_arr[2][1] +" "+ twoD_arr[2][2] +" "+ twoD_arr[2][3] +" "+ twoD_arr[2][4] +" "+ twoD_arr[2][5] +" "+ twoD_arr[2][6] +" "+ twoD_arr[2][7] +" "+ twoD_arr[2][8] +" "+ twoD_arr[2][9] +" "+ twoD_arr[2][10] +" "+ twoD_arr[2][11]+"\n");

            String gammaRateString = "";
            int gammaRate = 0;

            String epsilonRateString = "";
            int epsilonRate = 0;

            for(int p = 0; p < 12; p++)
            {
                if(mostCommonValue[p] >= 0) {mostCommonValueInBool[p] = true; gammaRateString = gammaRateString + "1"; epsilonRateString = epsilonRateString + "0";}
                if(mostCommonValue[p] < 0) {mostCommonValueInBool[p] = false; gammaRateString = gammaRateString + "0"; epsilonRateString = epsilonRateString + "1";}
            }

            System.out.println("gammaRateString: " + gammaRateString);
            System.out.println("epsilonRateString: " + epsilonRateString);

            gammaRate = Integer.parseInt(gammaRateString,2);
            epsilonRate = Integer.parseInt(epsilonRateString,2);

            System.out.println("gammaRate: " + gammaRate);
            System.out.println("epsilonRate: " + epsilonRate);

            int powerConsumption = gammaRate * epsilonRate;
            System.out.println("Power Consumption: " + powerConsumption);
        }
        // try {} catch {} for handling exceptions if file doses not exists
        catch (FileNotFoundException e) { System.err.println("File does not exist"); }
        catch (IOException e) { System.err.println("File exists, but there was IOException"); }
    }
}