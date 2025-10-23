package gasBooking;

import Customers.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection{
    public double otp = 5678, amount = 825, refund=0;
    public String dt,delDate, Status, DelMobileNo = "7890112344";
    Date dt_1;
    Date dt_2;

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


        System.out.println("Enter Delivery Date: ");
        delDate = new Scanner(System.in).nextLine();
        try {
            dt_2 = dateFormat.parse(delDate);
        }catch (Exception e){
            System.out.println("Error Parsing in dt_2"+e);
        }


        try{
            long difference = dt_2.getTime() - dt_1.getTime();

            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

            if (newDifference > 7){
                Status = "P";
            }
        }catch (Exception e){
            System.out.println("Error while finding difference: "+e);
        }
    }
    public void validate(){
//        get the difference between two dates
        long elapsedrs = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedrs, TimeUnit.MILLISECONDS);

        System.out.println("Difference between two dates is "+diff);

        if (numberOfCylinders == 1){
            if (diff < 30 ){
                System.out.println("Booking can not be done");
                Status = "C";
            }else {
                Status ="B";
                lastDate = dt_1;
            }
        }else if (numberOfCylinders == 2){
            if (diff < 50){
                System.out.println("Booking can not be done");
                Status = "C";
            }else {
                Status = "B";
                lastDate = dt_1;
            }
        }
    }
}
