

public class Bina extends Konut{

    private int numberOfFloors=0;



    Bina(String name, int numberOfFloors) {
        super(name);
        this.numberOfFloors=numberOfFloors;
    }

    public int numberOfFloors() {
        return this.numberOfFloors;
    }

    @Override
    public void displayInfo() {
           System.out.println("Kat sayısı:"+numberOfFloors);
    }
}
