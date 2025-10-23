import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static gasSupplier.gasAgency.*;

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

    public static void checkLateDel(Delivery[] obj){
        String[] months = new String[]{"January" , "February" , "March" , "April" ,
                "May" , "June" , "July" , "August" , "September" , "October" , "November" , "December"};
        int[] month = new int[12];
        for (Delivery delivery: obj){
            if (delivery.Status.equals("0") && delivery.amount == 783.75 ){
                month[delivery.dt_2.getMonth()] += 1;
            }
        }
        System.out.println("------------------late delivery-----------------");
        for (int i=0;i<12;i++){
            if (month[i] != 0){
                System.out.println(" * In "+ months[i]+"there are "+month[i]);
            }
        }
        System.out.println("\n");
    }

    public static void numOfSingleCylinders(Delivery[] obj){
        System.out.println("-----------Single Cylinder Holders-----------");
        for (int i = 0; i < obj.length; i++){
            if (obj[i].numberOfCylinders == 1){
                System.out.println("* Customer Name: "+obj[i].name);
                System.out.println(" * Mobile No.: " + obj[i].mobile);
                System.out.println(" * Gas Connection No.: "+ (i + 101));
            }
        }
        System.out.println("\n");
    }

    public static void DeliveryDetails(Delivery[] obj){
        System.out.println("--------------Delivery Details-------------");
        System.out.println("enter the name of delivery person: ");
        dpname = new Scanner(System.in).nextLine();
        for (Delivery delivery : obj){
            if (delivery.Status.equals("D") && delivery.delPersonName.equals(dpname)){
                System.out.println("* Customer Name: "+ delivery.name);
                System.out.println(" - "+ delivery.Street+", "+delivery.area+", "+delivery.pincode);
            }
            System.out.println("\n");
        }
    }

    public static void printReport(Delivery[] obj){
        System.out.println("---------------Delivery Report-------------");
        for (int i=0;i<obj.length;i++){
            if (obj[i].Status.equals("D")){
                dcount++;
            }
            else if(obj[i].Status.equals("B")){
                bcount++;
            }
            else if (obj[i].Status.equals("C")) {
                ccount++;
            }
            else if (obj[i].Status.equals("P")) {
                pcount++;
            }else {
                System.out.println("Status invalid");
            }
            System.out.println("* Booked");
            System.out.println(" - "+bcount+" booked");
            System.out.println("* Delivered");
            System.out.println(" - "+dcount+" delivered");
            System.out.println("* Cancelled");
            System.out.println(" - "+ccount+" cancelled");
            System.out.println("* Pending");
            System.out.println(" - "+pcount+" pending");
            System.out.println("\n");
        }
    }

    public static void printInvoice(Delivery[] obj){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String invoiceDate = sdf.format(d);
        for (int i =0; i < obj.length; i++){
            if(obj[i].Status.equals("0")){
                System.out.println("------------------------------------------------");
                System.out.println("                    INVOICE                     ");
                System.out.println("------------------------------------------------");
                System.out.println("Gas Agency Code: "+ agencyCode+ "\t\t\t" + "Date of Invoice: "+invoiceDate);
                System.out.println("Gas Agency Name: "+ agencyName+"\t\t"+"Agency Phone No.:"+phNumber);
                System.out.println("Gas Connection No.: "+ (i + 101) + "\t\t\t" + "Customer Name: " + obj[i].name);
                System.out.println("Booking Date: " + sdf.format(obj[i].dt_1 + "\t\t" +" Customer Mobile No.: " + obj[i].mobile));
                System.out.println("------------------------------------------------");
                System.out.println("Amount: "+ obj[i].amount);
                System.out.println("Refund: " + obj[i].refund);
                System.out.println("Total Amount: "+ (obj[i].amount - obj[i].refund));
                System.out.println("-----------------------------------------------");
                System.out.println("Delivery Person Name: "+obj[i].delPersonName + "\t\t"+" Delivery Person Mobile No.: " + obj[i].DelMobileNo);
                System.out.println("Delivery Date: "+ sdf.format(obj[i].dt_2));
                System.out.println("-----------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}