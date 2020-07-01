import Controler.CoinReceivingMechanism;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Date date = new Date();

        System.out.println("Current date and time is: " + date.toString());

        System.out.println("--------------------------------");
        System.out.println("Welcome to parking machine! These are our prices: \n- 1.00 € for hour of parking \n- 2.00" +
                " € for two hour of parking \n- 5.00 € for a full day ticket (expiring in midnight)");

        System.out.println("\nPlease pick a coins for entering in machine (0 would stop the input proces):");
        System.out.println("\n 1. 0.50 € \n 2. 1.00 € \n 3. 2.00 €");

        CoinReceivingMechanism.coinReceivingMechanism();

    }
}
