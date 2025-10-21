package gasBooking;

import Customers.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Booking extends GasConnection{
    public double otp = 5678, amount = 825, refund=0;
    public String dt,delDate, Status, DelMobileNo = "7890112344";
    Date dt_1;

    public Booking(String name, String street, String area, int pincode, int mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }

    public void getDates(){
        System.out.println("Enter Booking date: ");
        dt = new Scanner(System.in).nextLine();
        dt_1 = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            dt_1 = dateFormat.parse(dt);
        }catch (Exception e){
            System.out.println("The error in getDates function "+e);
        }
    }
}
