import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class evSahibi {
    private final String name;
    private final String surname;
    private final Bina building;
    private List<Daire> apartmentList;

    public

    evSahibi(String name, String surname, Bina building) {
        this.name=name;
        this.surname=surname;
        this.building=building;
        apartmentList= new ArrayList<Daire>();
    }
    public void addApartment(Daire Daire) {
        apartmentList.add(Daire);
        Collections.sort(apartmentList);

    }

    public List<Daire> apartmentList() {
        return apartmentList;
    }

    public void displayInfo() {

        System.out.println("Ev sahibinin ismi:"+name+" soyismi:"+surname);


    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public Bina  building() {
        return building;
    }




}
