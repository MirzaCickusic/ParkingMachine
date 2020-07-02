import Controler.CoinReceivingMechanism;
import Database.StoringTicketsToDB;

import java.util.Date;

public class Main {


    public static void main(String[] args) {

        Date date = new Date();

        System.out.println("Current date and time is: " + date.toString());

        System.out.println("--------------------------------");
        System.out.println("Welcome to parking machine! These are our prices: \n- 1.00 € for hour of parking \n- 2.00" +
                " € for two hour of parking \n- 5.00 € for a full 24h ticket");

        System.out.println("\nPlease pick a coins for entering in machine (0 would stop the input proces):");
        System.out.println("\n 1. 0.50 € \n 2. 1.00 € \n 3. 2.00 €");


        CoinReceivingMechanism.coinReceivingMechanism();

        StoringTicketsToDB.addCustomer();

    }
}
