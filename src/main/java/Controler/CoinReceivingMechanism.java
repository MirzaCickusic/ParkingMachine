package Controler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CoinReceivingMechanism {

    public static void coinReceivingMechanism() {

        Scanner scanner = new Scanner(System.in);
        List<Double> allCoinsUserEntered = new ArrayList<>();

        System.out.println("\nEnter number/s here: ");

        while (true) {

            double coinInput = scanner.nextDouble();

            if (coinInput == 0) {
                break;
            }

            if (coinInput == 1) {
                coinInput = 0.50;
                allCoinsUserEntered.add(coinInput);
            } else if (coinInput == 2) {
                coinInput = 1;
                allCoinsUserEntered.add(coinInput);
            } else if (coinInput == 3) {
                coinInput = 2;
                allCoinsUserEntered.add(coinInput);
            } else {
                System.out.println("Number not in range");
            }
        }

        /**
         * if (valueOfCoin != 0.5 || valueOfCoin != 1 || valueOfCoin != 2) {
         *             System.out.println("Coins added");
         *             return true;
         *         } else {
         *             System.out.println("Try again");
         *             return false;
         *         }
         */

    }
}
