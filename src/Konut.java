public abstract class Konut {
     protected String address;

    Konut(String address) {
        this.address=address;

    }
    public String address()
    {
        return this.address;
    }

     abstract public void displayInfo();

}
