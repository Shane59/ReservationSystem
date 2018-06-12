import java.util.Scanner;
/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class extends the ReservableItem class.
 */
public class Boat extends ReservableItem {

    /**
     * Constructor that calls the super class.
     * @param file that is provided by the main drive.
     */
    public Boat(Scanner file){
        super(file);
    }

    /**
     * Overriding the getFitnessValue.
     * @param res that is an object of Reservation class.
     * @return fitnessValue
     */
    @Override
    public int getFitnessValue(Reservation res) {
        int fitnessVal = 100;
        BoatReservation that = (BoatReservation) res;
        if(super.getReservations()[res.getTime()]==null){
            for (int i = 0; i < that.getPreferences().size(); i++) {
                if(that.getPreferences().get(i).equals(this.getId())){
                    fitnessVal = 100-i;
                    return fitnessVal;
                }
                else{
                    fitnessVal = -1;
                }
            }
        }
        else{
            fitnessVal = -1;
        }
        return fitnessVal;
    }
}
