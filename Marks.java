
//---------------------------------------
//-- Created by:     Alireza Teimoori  --
//-- Created on:     Feb 12 2019       --
//-- Created for:    Unit 1-09         --
//-- Course Code:    ICS4U             --
//-- Teacher Name:   Chris Atkinson    --
//---------------------------------------
//-- This program is awsome!It creates --
//-- a 2d array which can be as long as--
//-- the user wants, and it creates a  --
//-- table for all of the elements and --
//-- at last it calculates the average --
//----------------------------------------

// importing 
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Marks { // class

    public static Random randomNumber = new Random(); // Bring in an instance of Random
    public static Scanner scanner = new Scanner(System.in); // Bring in an instance of Scanner

    public static float Ave(int array [][]) { // Intro average finder function

        // Intro variables:
        float answer = 0;
        float sum = 0;
        float count = 0;

        for (int i = 0; i < array.length; i++) { // loop through all the 1st dim elements
            for (int j = 0; j < array[i].length; j++) { // loop through all the 2nd dim elements
                sum += array[i][j]; // add the mark to the mark pool
                count++; // keep track of how many marks there are
            }
        }
        answer = sum / count; // calculation
        return answer; // output
    }

    public static int maxer(int[] numbers) { // Intro max finder function

        int max = numbers[0]; // Intro max as the first place of the s

        for ( int count = 0; count < numbers.length; count ++){ // goes through the s
            if (numbers[count] > max){ // If the elements is larger than the current max,
                max = numbers[count]; //  it gets replaced
            }
        }

        return max; // shoots out max
    }

    public static void PrintTable(int arrPrt[][]) { // Intro table maker method ( A very simple method based on spaces and tabs)
		
		System.out.print("\t\t"); //put tabs
		
		for(int colNum = 0; colNum < arrPrt[0].length+1; colNum ++) { // for each element
            if (colNum == 0) { // Student or Assignemnt 0 does not make sense right?
                System.out.print("S\\A |\t"); // Student (vertical) - Assignment (horizontal)
            } else {
                System.out.print("A"+colNum + "  |\t"); // Start sorting the assignments and put sufficient space between them
            }
		}
		
		System.out.print("\n\t\t"); // enter and tabs again
		for(int count = 0; count < arrPrt[0].length+1; count ++) { // to draw a line for as far as the last assignment goes
			System.out.print("--------"); // each assignment needs 8 dashes
		}
		System.out.println(); // puts enter
		
		
		
		for(int arrRow = 0, rowNum = 1; arrRow < arrPrt.length; arrRow ++,rowNum++) { // for the length of the array
            
            // The following prints the student number and all the marks in one line:

            System.out.print("\tStudent " + rowNum + "   |\t"); // print student with student number
			for(int arrCol = 0; arrCol < arrPrt[arrRow].length; arrCol ++) { // for the length of the element
                if (arrPrt[arrRow][arrCol] == 100) { // to make sure the table is always in shape
                    System.out.print(arrPrt[arrRow][arrCol] + " |   "); // one space less after 100 because it has 3 digits
                } else {
                    System.out.print(arrPrt[arrRow][arrCol] + "  |   "); // print enough space to start the next number
                }
            }

            // The following prints a line below each line of data (marks):

            System.out.print("\n\t\t"); // enter and tabs again
            for(int count = 0; count < arrPrt[0].length+1; count ++) { // makes sure the dashes all long enough
                System.out.print("--------"); // for each assignment mark we need 8 dashes
            }
            System.out.println(); // enter
		}
	}
    public static void main(String[] args) {

        // Asking for and storing data:
        System.out.println("Hello and welcome to the Class Average program! \nHow many students in your class?");
        int student = scanner.nextInt();
        System.out.println("How many assignments for each?");
        int assignment = scanner.nextInt(); System.out.println("Thank you! :)");

        int [][] classArr = new int [student][assignment]; // create the array user wants
        

        for (int stu = 0; stu < classArr.length; stu++) { // for array length

            for (int assign = 0; assign < classArr[stu].length; assign++) {

                // The following makes sure a high random is being generated:
                int [] rand = new int [6]; // makes an array for 6 random numbers
                for (int i = 0; i < 6; i++) { // for the length of the array (which is 6) times
                    rand[i] = randomNumber.nextInt(100) + 1; // generates a random number
                }
                int mark = maxer(rand); // using the function I created for the previous assignment I find the largest random number

                classArr[stu][assign] = mark; // I put that in the current element
            }
        }

        // using the function I made above I print the table for my 2d array:
        PrintTable(classArr); 

        // using the average finder function i made above I print the class average:
        System.out.println("Class Average is: "+ Math.round(Ave(classArr) * 100.0) / 100.0); // I also round to 2 decimal numbers
    }
}