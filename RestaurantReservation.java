/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class extends Reservation class and
 * represents the restaurant's reservation.
 */
public class RestaurantReservation extends Reservation {
    private int numOfSeatsNeeded;

    /**
     * Constructor that takes three parameters.
     * @param numOfSeatsNeeded
     * @param timeSlots
     * @param customerName
     */
    public RestaurantReservation(int numOfSeatsNeeded, int timeSlots, String customerName) {
        super(customerName, timeSlots);
        setNumOfSeatsNeeded(numOfSeatsNeeded);
    }

    /**
     * Getter to get number of seats needed by a customer.
     * @return
     */
    public int getNumOfSeatsNeeded(){
        return numOfSeatsNeeded;
    }

    /**
     * Setter to set number of seats needed by a customer.
     * @param numOfSeatsNeeded
     */
    public void setNumOfSeatsNeeded(int numOfSeatsNeeded){
        this.numOfSeatsNeeded = numOfSeatsNeeded;
    }
}
