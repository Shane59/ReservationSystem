/*
 * Shinya Aoi
 * Reservation System
 * 06/01/2018
 */

/**
 * This class represents a reservation if it is successful.
 */
public class Reservation implements Comparable<Reservation>, Cloneable{

    private String resourceId;
    private String customer;
    private int numOfSeatsNeeded;
    private int time;

    /**
     * Constructor that takes customerName and timeSlot.
     * @param customerName
     * @param timeSlot
     */
    public Reservation(String customerName, int timeSlot){
        customer = customerName;
        time = timeSlot;
    }

    /**
     * Overriding the clone method from Cloneable.
     * @return the clone of the object.
     * @throws CloneNotSupportedException
     */
    @Override
    public Reservation clone() throws CloneNotSupportedException {
        return (Reservation) super.clone();
    }

    /**
     * Returns customer name.
     * @return
     */
    public String getCustomer(){
        return customer;
    }

    /**
     * Returns the timeSlot that customer want.
     * @return
     */
    public int getTime(){
        return time;
    }

    /**
     * Returns the numberOfSeatsNeeded by the customer.
     * @return
     */
    public int getNumOfSeatsNeeded(){
        return numOfSeatsNeeded;
    }

    /**
     * Returns the resourceID which is customers name or the boat's name.
     * @return
     */
    public String getResourceId(){
        return resourceId;
    }

    /**
     * Overriding the toString method to print out the reservation.
     * @return retVal.
     */
    @Override
    public String toString(){
        String retVal = "";
        if(numOfSeatsNeeded==0 && getResourceId()==null){
            retVal += "Reservation name: "+customer+" Time: "+time+"\n";
        }
        else if(numOfSeatsNeeded==0){
            retVal += "Reservation name: "+customer+" Time: "+time+" ID: "+getResourceId()+"\n";
        }
        else {
            retVal += "Reservation name: " + customer + " Time: " + time + " ID: " + getResourceId() + " Customer seats: " + getNumOfSeatsNeeded();
        }
        return retVal;
    }

    /**
     * Setter to set a resource id.
     * @param id
     */
    public void setResourceId(String id){
        resourceId = id;
    }

    /**
     * Overriding the compareTo method to compare customers' name.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Reservation o) {
        if(this.customer.compareTo(o.customer)<0){
            return -1;
        }
        else if(this.customer.compareTo(o.customer)>0){
            return 1;
        }
        return 0;
    }
}
