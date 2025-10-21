package Customers;

import gasSupplier.gasAgency;

public class Customer implements gasAgency{
    public String name;
    public String Street;
    public String area;
    public int pincode;
    public int mobile;

    public Customer(String name, String street, String area, int pincode, int mobile) {
        this.name = name;
        Street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobile = mobile;
    }

}
