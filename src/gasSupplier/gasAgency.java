package gasSupplier;

public interface gasAgency {
    public String agencyName = "Bharat Gas";
    public int agencyCode = 1234;
    public int phNumber = 875555;

    default void agencyDesplay(){
        System.out.println("The agency name is "+agencyName);
        System.out.println("The agency Code is "+agencyCode);
        System.out.println("The agency phone Number is "+phNumber);
    }
}
