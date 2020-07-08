import Database.GetParkingPricingInDB;
import Database.SetParkingPricingInDB;
import View.ParkingMachineMenu;

public class Main {

    public static void main(String[] args) {

        if (GetParkingPricingInDB.getHourlyPrice() == 0 || GetParkingPricingInDB.getDaylePrice() == 0) {
            SetParkingPricingInDB.initializeParkingPrices(1, 5);
        }

        while (ParkingMachineMenu.showMenu())
            ParkingMachineMenu.showMenu();
    }
}
