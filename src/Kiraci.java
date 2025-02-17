import static java.lang.System.out;

public class Kiraci {
    private String name;
    private String surname;
    private evSahibi evSahibi;
    Kiraci(String name, String surname, evSahibi evSahibi) {
        this.name=name;
        this.surname=surname;
        this.evSahibi= evSahibi;
    }
    public void displayInfo() {
        out.print(this.name+" soyadı:"+this.surname);
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public evSahibi getEvSahibi() {
        return evSahibi;
    }
}
