import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.util.*;

public class Main {
    static int count;
    static int bcount = 0 ,ccount = 0, dcount = 0, pcount = 0;
    static String dpname;

    public static void cylinderCount(Delivery[] obj){
    String[] months = new String[]{"January" , "February" , "March" , "April" ,
    "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};

        for(Delivery delivery: obj){
            count = 0;
            System.out.println("In the month of "+ (months[delivery.dt_2.getMonth()]) + " : ");
            System.out.println(" * In "+ delivery.area);
            if (delivery.Status.equals("D")){
                count += delivery.numberOfCylinders;
            }

            System.out.println(" - " + count+ "cylinders delivered");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        System.out.println("Hey Dear!");
    }
}