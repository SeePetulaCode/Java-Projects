// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
// Name: Petula Pascall
// Date: 10.12.2019
// Class Name: SMC 2019 Fall - CS 55 (1793) - Java Programming (O)
// Class Name in file: Craps.java
// Assignment Name: CrapsGameProject

// Assignment Description:

//
// Write a Complete program for the following specification:One of the most popular games of chance
// is a dice game known as “craps,” which is played in casinos and back alleys throughout the world.
// The rules of the game are straightforward:A player rolls two dice.  Each die has six faces.
// These faces contain 1, 2,3,4,5, and 6 spots.  After the dice have come to rest, the sum of the
// spots on the two upward faces is calculated.  If the sum is 7 or 11 on the first throw, the player
// wins.  If the sum is 2, 3, or 12 on the first throw (called “craps”), the player loses (i.e., the
// “house” wins).  If the sum is 4, 5,6,8,9, or 10 on the first throw, then that sum becomes the
// player’s “points.”  To win, you must continue rolling the dice until you “make your points.”
// The player loses by rolling a 7 before making the points.


// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.company;

import java.util.Scanner;

public class Craps {

    public static void main(String[] args) {

        String rollDice; // Variable for Roll Dice Loop
        int counter = 0; // Variable for number of times played
        int d1 = (int)(Math.random()*(6))+1;  // Variable for first Dice Roll
        int d2 = (int)(Math.random()*(6))+1;  // Variable for second Dice Roll
        int toss_sum = (d2+d1); // Variable for sum of both Dice tossed
        int points = 0;  // Variable for each points to add from dice sum
        int pointsTotal = 0; // Variable for each points to add from dice sum

        // Each Dice result then Sum of Dice
        System.out.println("Dice 1 =====>>>"+d1);
        System.out.println("Dice 2 =====>>>"+d2);
        System.out.println("Sum =====>>>"+toss_sum);

        // If 7 or 11 on first try --- You Win!!
        if (toss_sum == 7 || toss_sum == 11 && counter == 0) {
            System.out.println("You rolled a "+toss_sum+"! You Win!");

        // If 2,3 or 12  on first try --- You Lose!! The house Wins!
        } else if (toss_sum == 2 || toss_sum == 3 || toss_sum == 12 && counter == 0){
            System.out.println("You rolled a "+toss_sum+"! CRAPS! You LOSE! The House WINS!");

            
        // Anything else? You get a chance to toss, add those points every time you roll the dice
        } else {

            //System.out.println("Counter = "+counter);
            //System.out.println("You rolled a "+toss_sum);
            points = +toss_sum;

            do {

            Scanner scan = new Scanner(System.in);

            
            System.out.print("Roll again? (Y/N):");
            rollDice = scan.next();

            if ( rollDice.equals("n") || rollDice.equals("N"))
                {
                    System.out.println("Thanks for Playing.");
                    break;

                }

            d1 = (int)(Math.random()*(5))+1;
            d2 = (int)(Math.random()*(5))+1;
            toss_sum = (d2+d1);

            points = points+toss_sum;
            pointsTotal = (pointsTotal + points);

             if (toss_sum == 7 && counter == 0) {

                 System.out.println("You rolled a " + toss_sum + "! CRAPS! You LOSE! The House WINS!");
                 break;

             }
              counter = counter+1;


            System.out.println("You rolled a "+toss_sum+"! Your points total are "+points);
            // System.out.println("Counter = "+counter);

            }

            while (rollDice.equals("y") || rollDice.equals("Y")) ; //Loop if "Y/y"

            System.out.println("Bye Bye!");

        }


    }
}
