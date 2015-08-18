package topcoder;

//SRM 553 div 2
public class PlatypusDuckAndBeaver {

    public int minimumAnimals(int webbedFeet, int duckBills, int beaverTails) {
        int numOfDucks;
        int numOfPlatypuses;
        int numOfBeavers;

        numOfPlatypuses = (2 * duckBills + 4 * beaverTails - webbedFeet) / 2;
        numOfDucks = duckBills - numOfPlatypuses;
        numOfBeavers = beaverTails - numOfPlatypuses;

        return numOfDucks + numOfPlatypuses + numOfBeavers;
    }

}