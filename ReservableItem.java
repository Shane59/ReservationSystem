import java.util.Scanner;
/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class holds the customer's name as ID in the RestaurantReservation and
 * Boats name in BoatReservation. Add reservation when it is successfully made.
 */
public abstract class ReservableItem {
    private String id;
    private Reservation[] reservations = new Reservation[10];

    /**
     * No-argument constructor.
     */
    public ReservableItem(){}

    /**
     * This class reads the file and set the ID.
     * @param fileIn
     */
    public ReservableItem(Scanner fileIn){
        id = fileIn.nextLine();
    }

    /**
     * Returns the ID.
     * @return id
     */
    public String getId(){
        return id;
    }

    /**
     * Abstract method. This is to get a fitnessValue.
     * @param res
     * @return fitnessValue
     */
    public abstract int getFitnessValue(Reservation res);

    /**
     * This methods to return the reservations that have been made.
     * @return
     */
    public Reservation[] getReservations(){
        return reservations;
    }
}
