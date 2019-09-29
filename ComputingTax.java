// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
// Name: Petula Pascall
// Date: 09.21.2019
// Class Name: ComputingTax.java
// Assignment Number: Project 1 Tax

//Problem Description:

// "The United States federal personal income tax is calculated based on filing
// status and taxable income. There are four filing statuses: single filers,
// married filing jointly, married filing separately, and head of household.
// The tax rates vary every year. Table 3.2 shows the rates for 2009.
// If you are, say, single with a taxable income of $10,000, the first $8,350
// is taxed at 10% and the other $1,650 is taxed at 15%. So, your tax is $1,082.5.

// Assignment Description:

// You are to write a program to compute personal income tax. Your program should
// prompt the user to enter the filing status and taxable income and compute the tax.
// Enter 0 for single filers, 1 for married filing jointly, 2 for married filing
// separately, and 3 for head of household.

// Learning Notes:
// 1. Need to learn how to round to 2 decimals(i.e. Tax is: 2.3307693099999998E7. Looks weird)

// 2. Error sometimes. Doesn't like repeated digits
//    (i.e. "Enter the taxable income:
//     99999999999999999999999999999999999999999
//     Exception in thread "main" java.util.InputMismatchException:
//     For input string: "99999999999999999999999999999999999999999")

// 2. Will redo this in January 2020. Goal: Make this code shorter and better.

// *Will over comment for first assignment. Hope you don't mind....for study

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//package com.company; (from intellij IDEA ¯\_(ツ)_/¯)

import java.util.*;

public class ComputingTax {

    public static void main(String[] args) {

        // Declaration - variables/attributes

        int sampleNo = 1; // Sample Number (will display 4x like hw example)

        int fillingStatus; // Status? Are you single, married, filling separately or head of household?

        double taxableIncome; // Income to be taxed. Double: Allows for decimal values

        double taxAmt = 0; // Tax Amount



        Scanner console = new Scanner(System.in);


        while (sampleNo == 4) { //Max Sample Count(4)

            System.out.println("\r\nSample " + sampleNo); //prints out current sample w. above space

            System.out.println("Enter the filling status: "); //requires status input
            fillingStatus = console.nextInt(); // stores status input

            System.out.println("Enter the taxable income: "); //requires taxable income
            taxableIncome = console.nextInt(); // stores taxable income input



            // Checks for filling Status

            if (fillingStatus == 0) {

                taxAmt = single(taxableIncome); //stores single tax input

            } else if (fillingStatus == 1) {

                taxAmt = marriedJoint(taxableIncome); //stores joint married tax input

            } else if (fillingStatus == 2) {

                //stores separate married tax input
                taxAmt = marriedSeperate(taxableIncome); // ↑ see above line comment ↑

            } else if (fillingStatus == 3) {

                taxAmt = headOfHouse(taxableIncome); //stores head of household tax input

            }

            System.out.println("Tax is: " + taxAmt); //final tax amount is given


            //refreshes all variables to 0, then starts process again
            taxAmt = 0.0;
            fillingStatus = 0;
            taxableIncome = 0.0;

            sampleNo++; //keeps counting sample number till 4

        }
    }


    // Based on Status and Income, Will run through code to check,
    // compute and return taxed income.

    private static double single(double taxableIncome) {

        double margin = 0.1; //initial tax margin
        double taxedincome = 0; //initial taxed income


        if (taxableIncome >= 0 & taxableIncome <= 8350) { // { tax bracket 1 }

            taxedincome = taxableIncome * margin;

        } else if (taxableIncome >= 8351 & taxableIncome <= 33950) { // { tax bracket 2 }

            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (taxableIncome - 8350));


        } else if (taxableIncome >= 33951 & taxableIncome <= 82250) { // { tax bracket 3 }
            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (33950 - 8350));

            taxedincome = taxedincome + (0.25 * (taxableIncome - 33950));

        } else if (taxableIncome >= 82251 & taxableIncome <= 171550) { //// { tax bracket 4 }
            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (33950 - 8350));

            taxedincome = taxedincome + (0.25 * (82250 - 33950));

            taxedincome = taxedincome + (0.28 * (taxableIncome - 82250));

        } else if (taxableIncome >= 171551 & taxableIncome <= 372950) { // { tax bracket 5 }
            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (33950 - 8350));

            taxedincome = taxedincome + (0.25 * (82250 - 33950));

            taxedincome = taxedincome + (0.28 * (171550 - 82250));

            taxedincome = taxedincome + (0.33 * (taxableIncome - 171550));

        } else if (taxableIncome > 372950) { // { tax bracket 6 }

            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (33950 - 8350));

            taxedincome = taxedincome + (0.25 * (82250 - 33950));

            taxedincome = taxedincome + (0.28 * (171550 - 82250));

            taxedincome = taxedincome + (0.33 * (379250 - 171550));

            taxedincome = taxedincome + (0.35 * (taxableIncome - 372950));

        }
        return taxedincome; //Gives final Taxed Income for Single Person
    }

    private static double marriedJoint(double taxableIncome) {

        double margin = 0.1; //initial tax margin
        double taxedincome = 0; //initial taxed income

        if (taxableIncome >= 0 & taxableIncome <= 16700) { // { tax bracket 1 }


            taxedincome = taxableIncome * margin;


        } else if (taxableIncome >= 16701 & taxableIncome <= 67900) {// { tax bracket 2 }

            taxedincome = margin * 16700;

            taxedincome = taxedincome + (0.15 * (taxableIncome - 16700));


        } else if (taxableIncome >= 67901 & taxableIncome <= 137050) {// { tax bracket 3 }
            taxedincome = margin * 16700;

            taxedincome = taxedincome + (0.15 * (67900 - 16700));

            taxedincome = taxedincome + (0.25 * (taxableIncome - 67900));

        } else if (taxableIncome >= 137051 & taxableIncome <= 208850) {// { tax bracket 4 }

            taxedincome = margin * 16700;

            taxedincome = taxedincome + (0.15 * (67900 - 16700));

            taxedincome = taxedincome + (0.25 * (137050 - 67900));

            taxedincome = taxedincome + (0.28 * (taxableIncome - 137050));

        } else if (taxableIncome >= 208851 & taxableIncome <= 372950) {// { tax bracket 5 }
            taxedincome = margin * 16700;

            taxedincome = taxedincome + (0.15 * (67900 - 16700));

            taxedincome = taxedincome + (0.25 * (137050 - 67900));

            taxedincome = taxedincome + (0.28 * (208850 - 137050));

            taxedincome = taxedincome + (0.33 * (taxableIncome - 208850));

        } else if (taxableIncome > 372950) {// { tax bracket 6 }

            taxedincome = margin * 16700;

            taxedincome = taxedincome + (0.15 * (67900 - 16700));

            taxedincome = taxedincome + (0.25 * (137050 - 67900));

            taxedincome = taxedincome + (0.28 * (208850 - 137050));

            taxedincome = taxedincome + (0.33 * (300339 - 208850));

            taxedincome = taxedincome + (0.35 * (taxableIncome - 372950));


        }
        return taxedincome;//Gives final Taxed Income for Joint Married Couple
    }

    private static double marriedSeperate(double taxableIncome) {

        double margin = 0.1; //initial tax margin
        double taxedincome = 0; //initial taxed income

        if (taxableIncome >= 0 & taxableIncome <= 8350) {// { tax bracket 1 }


            taxedincome = taxableIncome * margin;

        } else if (taxableIncome >= 8351 & taxableIncome <= 33950) {// { tax bracket 2 }

            taxedincome = margin * 8350;

            taxedincome = taxedincome + (0.15 * (taxableIncome - 8350));

        } else if (taxableIncome >= 33951 & taxableIncome <= 68525) {// { tax bracket 3 }
            taxedincome = margin * 8350;
            taxedincome = taxedincome + (0.15 * (33950 - 8350));
            taxedincome = taxedincome + (0.25 * (taxableIncome - 33950));

        } else if (taxableIncome >= 68526 & taxableIncome <= 104425) {// { tax bracket 4 }
            taxedincome = margin * 8350;
            taxedincome = taxedincome + (0.15 * (33950 - 8350));
            taxedincome = taxedincome + (0.25 * (68525 - 33950));
            taxedincome = taxedincome + (0.28 * (taxableIncome - 68525));


        } else if (taxableIncome >= 104426 & taxableIncome <= 186475) {// { tax bracket 5 }
            taxedincome = margin * 8350;
            taxedincome = taxedincome + (0.15 * (33950 - 8350));
            taxedincome = taxedincome + (0.25 * (68525 - 33950));
            taxedincome = taxedincome + (0.28 * (104425 - 68525));
            taxedincome = taxedincome + (0.33 * (taxableIncome - 104425));

        } else if (taxableIncome > 186475) {// { tax bracket 6 }
            taxedincome = margin * 8350;
            taxedincome = taxedincome + (0.15 * (33950 - 8350));
            taxedincome = taxedincome + (0.25 * (68525 - 33950));
            taxedincome = taxedincome + (0.28 * (104425 - 68525));
            taxedincome = taxedincome + (0.33 * (186475 - 104425));
            taxedincome = taxedincome + (0.35 * (taxableIncome - 186475));


        }
        return taxedincome;//Gives final Taxed Income for Separate Married Couple
    }

    private static double headOfHouse(double taxableIncome) {

        double margin = 0.1; //initial tax margin
        double taxedincome = 0; //initial taxed income

        if (taxableIncome >= 0 & taxableIncome <= 11950) {// { tax bracket 1 }


            taxedincome = taxableIncome * margin;

        } else if (taxableIncome >= 11951 & taxableIncome <= 45500) {// { tax bracket 2 }

            taxedincome = margin * 11950;
            taxedincome = taxedincome + (0.15 * (taxableIncome - 11950));

        } else if (taxableIncome >= 45501 & taxableIncome <= 117450) {// { tax bracket 3 }
            taxedincome = margin * 11950;
            taxedincome = taxedincome + (0.15 * (45500 - 11950));
            taxedincome = taxedincome + (0.25 * (taxableIncome - 45500));

        } else if (taxableIncome >= 117451 & taxableIncome <= 190200) {// { tax bracket 4 }
            taxedincome = margin * 11950;
            taxedincome = taxedincome + (0.15 * (45500 - 11950));
            taxedincome = taxedincome + (0.25 * (117450 - 45500));
            taxedincome = taxedincome + (0.28 * (taxableIncome - 117450));

        } else if (taxableIncome >= 190201 & taxableIncome <= 372950) {//// { tax bracket 5 }
            taxedincome = margin * 11950;
            taxedincome = taxedincome + (0.15 * (45500 - 11950));
            taxedincome = taxedincome + (0.25 * (117450 - 45500));
            taxedincome = taxedincome + (0.28 * (190200 - 117450));
            taxedincome = taxedincome + (0.33 * (taxableIncome - 190200));

        } else if (taxableIncome > 372950) {// { tax bracket 6 }
            taxedincome = margin * 11950;
            taxedincome = taxedincome + (0.15 * (45500 - 11950));
            taxedincome = taxedincome + (0.25 * (117450 - 45500));
            taxedincome = taxedincome+ (0.28 * (190200 - 117450));
            taxedincome = taxedincome + (0.33 * (372950 - 190200));
            taxedincome = taxedincome + (0.35 * (taxableIncome - 372950));
        }
        return taxedincome;//Gives final Taxed Income for Head of Household

    }

}
