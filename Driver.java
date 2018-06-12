import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Shinya Aoi
 * 06/11/2018
 *
 */
public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        //This is a restaurant reservation driver.

        ResManager<Table, Reservation> manager = new ResManager<Table, Reservation>();
        try{
            Scanner keyboard = new Scanner(new FileInputStream("tableFile.txt"));
            while (keyboard.hasNext()){
                manager.addReservable(new Table(keyboard));
            }
        }catch(FileNotFoundException e){
            System.out.println("File was not found!");
            System.exit(0);
        }
        RestaurantReservation res1 = new RestaurantReservation(2, 4, "Shinya Aoi");
        manager.makeReservation(res1);
        RestaurantReservation res2 = new RestaurantReservation(3,  5, "Son Dang");
        manager.makeReservation(res2);

        res2 = new RestaurantReservation(5, 2, "Mazda Hutape");
        manager.makeReservation(res2);
        res2 = new RestaurantReservation(2, 1, "Miwa Tanaka");
        manager.makeReservation(res2);

        RestaurantReservation res3 = new RestaurantReservation(6, 8, "Taraji June");
        manager.makeReservation(res3);

        res2 = new RestaurantReservation(11,7,"Too many");
        manager.makeReservation(res2);
        res2 = new RestaurantReservation(9, 7, "Nate McGate");
        manager.makeReservation(res2);
        res2 = new RestaurantReservation(9, 7, "NSC");
        manager.makeReservation(res2);
        res2 = new RestaurantReservation(9, 7, "UW");
        manager.makeReservation(res2);

        System.out.println("Reservations are:");
        System.out.println(manager);

        System.out.println();

        System.out.println("Sorted reservations:");
        manager.sortReservations();
        System.out.println(manager);

        //boat reservations

        ResManager<Boat, Reservation> manager2 = new ResManager<>();

        try{
            Scanner keyboard = new Scanner(new FileInputStream("boatFile.txt"));
            while(keyboard.hasNext()){
                manager2.addReservable(new Boat(keyboard));
            }
        }catch (FileNotFoundException e){
            System.out.println("File was not found!");
            System.exit(0);
        }
        System.out.println();

        BoatReservation resBoat1 = new BoatReservation(3, "Shinya Aoi");
        resBoat1.addBoatPreference("kayak");
        resBoat1.addBoatPreference("zodiak");
        resBoat1.addBoatPreference("canoe");
        manager2.makeReservation(resBoat1);

        BoatReservation resBoat2 = new BoatReservation(5, "Derrick Thomas");
        resBoat2.addBoatPreference("speedboat");
        resBoat2.addBoatPreference("zodiak");
        resBoat2.addBoatPreference("submarine");
        manager2.makeReservation(resBoat2);
        
        System.out.println(manager2);
    }

}
