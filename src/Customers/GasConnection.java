package Customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer{
    public int numberOfCylinders;
    String date;

    static int connectionNumber = 100;
    {
        connectionNumber +=1;
    }
    public Date lastDate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, int pincode, int mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile);
        this.numberOfCylinders = numberOfCylinders;
    }

    public void getLastdate(){
        System.out.println("Enter the last Date ");
        date = new Scanner(System.in).nextLine();
        try{
            lastDate = dateFormat.parse(date);
        }catch (Exception e){
            System.out.println("error in getLastDate"+e);
        }
    }
}
