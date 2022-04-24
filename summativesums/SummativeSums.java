package com.mthree.c216.summativesums;

/*
    DogGenetics.java
    George Harland
    Last edited 24/04/2022
 */

public class SummativeSums {
    public static void main(String[] args) {

        // Define example arrays
        int[] ex1 = new int[]{ 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] ex2 = new int[]{ 999, -60, -77, 14, 160, 301 };
        int[] ex3 = new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 } ;

        // Call sum method with the 3 example arrays, printing results
        System.out.printf("%n#1 Array Sum: %d%n", sumArray(ex1));
        System.out.printf("#2 Array Sum: %d%n", sumArray(ex2));
        System.out.printf("#3 Array Sum: %d%n", sumArray(ex3));
    }

    private static int sumArray(int[] arrayToSum) {
        // Sums the given array and returns the total

        int result = 0;
        for (int i : arrayToSum) {
            result = result + i;
        }
        return result;
    }
}
