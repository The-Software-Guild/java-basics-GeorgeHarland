package com.mthree.c216.doggenetics;

import java.util.Random;
import java.util.Scanner;

/*
    DogGenetics.java
    George Harland
    Last edited 24/04/2022
 */

public class DogGenetics {
    public static void main(String[] args) {

        Scanner dogScanner = new Scanner(System.in);
        Random random = new Random();

        int[] dogBreed = new int[5];
        int total = 0;
        int bound = 100;

        // Ask user name of dog
        System.out.println("What is your dog's name? ");
        String dogName = dogScanner.nextLine();

        // Assign random % to 4 dog breeds
        for(int i=0; i<4; i++) {
            total = random.nextInt(bound);
            dogBreed[i] = total;
            bound = bound-total;
        }

        // Last dog breed adds up to 100
        dogBreed[4] = bound;

        // Output fake DNA report
        System.out.printf("%n%nReport on %s's background: ", dogName);
        System.out.printf("%n----------------------------%n%n");
        System.out.printf("%d%% Leopard%n", dogBreed[0]);
        System.out.printf("%d%% Bat%n", dogBreed[1]);
        System.out.printf("%d%% Otter%n", dogBreed[2]);
        System.out.printf("%d%% Tasmanian Devil%n", dogBreed[3]);
        System.out.printf("%d%% Eagle%n", dogBreed[4]);
        System.out.printf("%nUnbelievable! That's definitely not a dog!%n");
    }
}
