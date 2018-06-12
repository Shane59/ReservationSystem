import java.util.ArrayList;
/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class extends the Reservation class.
 * One instance variable that has customers preferences of boats.
 */
public class BoatReservation extends Reservation {
    ArrayList<String> preferences = new ArrayList<>();

    /**
     * Constructor that takes timeSlots and customerName.
     * Calls super class.
     * @param timeSlots
     * @param customerName
     */
    public BoatReservation(int timeSlots, String customerName) {
        super(customerName, timeSlots);
    }

    /**
     * This method adds a preference of customer's boat.
     * @param boatName
     */
    public void addBoatPreference(String boatName){
        preferences.add(boatName);
    }

    /**
     * This methods returns the ArrayList of customer's preference list.
     * @return preferences
     */
    public ArrayList<String> getPreferences(){
        return preferences;
    }
}
