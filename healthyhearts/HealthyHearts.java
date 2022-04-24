package com.mthree.c216.healthyhearts;

import java.util.Scanner;

/*
    HealthyHearts.java
    George Harland
    Last edited 24/04/2022
 */

public class HealthyHearts {
    public static void main(String[] args) {

        Scanner heartScanner = new Scanner(System.in);

        // Ask user for their age
        System.out.println("What is your age?");
        String userAge = heartScanner.nextLine();
        int numAge = Integer.parseInt(userAge);

        // Calculations
        int max_hr = 220 - numAge;
        double low_hr = max_hr * 0.5;
        double high_hr = max_hr * 0.85;

        // Output heart-rate report
        System.out.printf("%nPersonal heart rate report: ");
        System.out.printf("%n----------------------------%n%n");
        System.out.printf("Your maximum heart rate should be %d beats per minute. %n", max_hr);
        System.out.printf("Your target heart rate is between %d and %d beats per minute. %n", Math.round(low_hr), Math.round(high_hr));
    }
}
