// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
// Name: Petula Pascall
// Date: 09.28.2019
// Class Name: SMC 2019 Fall - CS 55 (1793) - Java Programming (O)
// Class Name in file: Calculator.java
// Assignment Number: Programming Project 1

// Assignment Description:

// You learned that computers follow instructions faithfully and they never get tired of
// repeating the same thing over and over. You plan to write a simple program Calculator.java
// to see for yourself.

// After bragging a bit, the program asks the user to enter 2 numbers. After receiving and
// storing those it asks the user to enter one of the operations +, -, *, or /. The program
// then performs that operation on the two numbers and displays the output to the user (if
// the user enters an operation different from the four operations above, the program notifies
// the user that it does not know that operation). It then brags some more and asks the user if
// they want to play again. If the user enters Y or y, the game starts over. Otherwise the program
// prints Bye bye and terminates.


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

import java.util.*;
import java.text.DecimalFormat;

public class Calculator {


    public static void main(String[] args) {


        String playgame; // Variable for Play Again Loop

        do //Play Again Loop
        {


            Scanner scan = new Scanner(System.in); //Set up environment for inputs

            System.out.println("Hi, I am really good at math! Put me to the test.");
            System.out.print("Please enter two numbers and then press Enter: ");

            float n1 = scan.nextFloat(); // First number input in float format
            float n2 = scan.nextFloat(); // Second number input in float format

            System.out.print("Please enter one of the operations +, -, * or / and press Enter: ");
            String operation = scan.next(); // Operation input in string format


            if (operation.equals("+")) {
                DecimalFormat df = new DecimalFormat("#.##"); //Get rid of trailing Zeros!
                System.out.println(df.format(n1) + " + " + df.format(n2) + " = " + df.format(n1 + n2));
                System.out.println("I'm great at addition!");
            } else if (operation.equals("-")) {

                DecimalFormat df = new DecimalFormat("#.##"); //Get rid of trailing Zeros!
                System.out.println(df.format(n1) + " - " + df.format(n2) + " = " + df.format(n1 - n2));
                System.out.println("I'm great at subtraction!");
            } else if (operation.equals("/")) {
                DecimalFormat df = new DecimalFormat("#.##"); //Get rid of trailing Zeros!

                System.out.println(df.format(n1) + " / " + df.format(n2) + " = " + df.format(n1 / n2));
                System.out.println("I'm great at division!");
            } else if (operation.equals("*")) {
                DecimalFormat df = new DecimalFormat("#.##");//Get rid of trailing Zeros!

                System.out.println(df.format(n1) + " * " + df.format(n2) + " = " + df.format(n1 * n2));
                System.out.println("I'm great at multiplication!");
            } else {

                System.out.println("I can compute really well, but what you entered is not one of the operations I know ...");

            }


            System.out.print("Play again (Y/N)?:");
            playgame = scan.next();
            //String playgame = scan.next().toUpperCase();
        } while (playgame.equals("y") || playgame.equals("Y")); //Loop if "Y/y"


        System.out.println("Bye Bye!");


    }
}

