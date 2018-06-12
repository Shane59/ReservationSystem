import java.util.ArrayList;
/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class is to manage a reservation. reservableItem holds
 * the items that are reservable. Reservation holds that reservations
 * that are made successfully.
 * @param <itemType> which extends ReservableItem class.
 * @param <resType> which extends Reservation class.
 */
public class ResManager <itemType extends ReservableItem, resType extends Reservation>  {
    private ArrayList<itemType> reservableItems = new ArrayList<>();
    private ArrayList<resType> reservation = new ArrayList<>();

    /**
     * no-argument constructor
     */
    public ResManager(){

    }

    /**
     * This method adds a reservable item to the reservableItem array.
     * @param item which is reservableItem class.
     */
    public void addReservable(itemType item){
        reservableItems.add(item);
    }

    /**
     * This method tries to makes a reservation. If it is made successfully,
     * the reservation will be added to the reservation array and
     * returns the reservation. If not, it will return null.
     * @param trialRes which is the reservation class.
     * @return the reservation if it is success.
     * @throws CloneNotSupportedException
     */
    public Reservation makeReservation(resType trialRes) throws CloneNotSupportedException {
        if (trialRes==null){
            System.out.println("Reservation is not valid!");
            return null;
        }
        //Finding a fitness value
        int fitnessVal;
        int minFitnessVal = -1;
        int index = 0;
        Reservation copyRes = trialRes.clone();
        for (int i = 0; i < reservableItems.size(); i++) {
            fitnessVal = reservableItems.get(i).getFitnessValue(copyRes);
            if (fitnessVal>minFitnessVal) {
                minFitnessVal = fitnessVal;
                index = i;
            }
        }
        if(minFitnessVal == -1){
            System.out.print("Unsuccessful reservation: "+copyRes.toString());
            return null;
        }
        copyRes.setResourceId(reservableItems.get(index).getId());
        reservation.add((resType) copyRes);
        reservableItems.get(index).getReservations()[copyRes.getTime()] = copyRes;
        return copyRes;
    }

    /**
     * Using bubble sort to sort the reservation by customer name.
     */
    public void sortReservations(){
        for (int i = 0; i < reservation.size(); i++) {
            for (int j = 0; j < reservation.size()-1; j++) {
                if(reservation.get(j).compareTo(reservation.get(j+1))>0){
                    resType temp = reservation.get(j);
                    reservation.set(j, reservation.get(j+1));
                    reservation.set(j+1, temp);
                }
            }
        }
    }

    /**
     * Overriding the toString. This prints out the reservations as String.
     * @return the string of reservations.
     */
    @Override
    public String toString(){
        String retVal = "";
        for (int i = 0; i < reservation.size(); i++) {
            if (reservation.get(i).getNumOfSeatsNeeded()==0){
                retVal += "Reservation name: " + reservation.get(i).getCustomer() + " Time: " +
                        reservation.get(i).getTime() + " ID: " + reservation.get(i).getResourceId()+"\n";
            }
            else {
                retVal += "Reservation name: " + reservation.get(i).getCustomer() + " Time: " +
                        reservation.get(i).getTime() + " ID: " + reservation.get(i).getResourceId() +
                        " Customer seats: " + reservation.get(i).getNumOfSeatsNeeded() + "\n";
            }
        }
        return retVal;
    }
}
