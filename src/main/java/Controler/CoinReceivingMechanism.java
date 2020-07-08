package Controler;

import Model.TicketObject;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinReceivingMechanism {

    private static double total;

    public static double getTotal() {
        return total;
    }

    public static void setTotal(double newTotal) {
        total = newTotal;
    }

    public static void coinReceivingMechanism() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> allCoinsUserEntered = new ArrayList<>();

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

        double totalSumOfAllCoins = sumOfUserCoins(allCoinsUserEntered);

        setTotal(totalSumOfAllCoins);

        try {
            setTimeRecipeIsCreated();

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void setTimeRecipeIsCreated() throws ParseException {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        String dayleTicketEndTimeAndDate = FOMATTER.format(date);

        TicketObject.setDateAndTimeTicketCreated(dayleTicketEndTimeAndDate);
    }

    private static double sumOfUserCoins(ArrayList<Double> coinsList) {

        double totalAmount = 0;

        for (int i = 0; i < coinsList.size(); i++) {
            totalAmount += coinsList.get(i);
        }
        return totalAmount;
    }
}
