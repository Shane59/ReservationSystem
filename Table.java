import java.util.Scanner;
/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class represents table and extends ReservableItem class.
 */
public class Table extends ReservableItem {
    private int numOfSeats;

    /**
     * Constructor that takes a file and calls the super class.
     * This sets the number of seats of a table.
     * @param fileIn
     */
    public Table(Scanner fileIn) {
        super(new Scanner(fileIn.next()));
        numOfSeats = fileIn.nextInt();
    }

    /**
     * Getter to get number of seats of a table.
     * @return numOfSeats.
     */
    public int getNumOfSeats(){
        return numOfSeats;
    }

    /**
     * Overriding the getFitnessValue to calculate a fitness value.
     * @param res which is Reservation class.
     * @return fitnessValue.
     */
    @Override
    public int getFitnessValue(Reservation res){
        double fitnessVal = -1.0;
        if(super.getReservations()[res.getTime()]==null){
            RestaurantReservation that = (RestaurantReservation) res;
            fitnessVal = (double)that.getNumOfSeatsNeeded()/getNumOfSeats()*100;
            if(fitnessVal>100){
                fitnessVal = -1;
            }
        }
        return (int)fitnessVal;
    }
}
