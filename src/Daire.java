import java.lang.Comparable;

 public class Daire extends Konut implements Comparable <Daire>{


    private int apartmentNo;
    private int floorNo;
    private boolean isRent;
    Daire(String address , int floorNo, int apartmentNo) {
        super(address);
        this.floorNo=floorNo;
        this.apartmentNo=apartmentNo;
        isRent=true;

    }


    public int compareTo(Daire otherDaire) {

        // Daire numarasına göre karşılaştırma yapıldı.
        int aptNoComparison = Integer.compare(this.apartmentNo, otherDaire.apartmentNo);
        return aptNoComparison;
    }
    public boolean isRent() {
        return isRent;
    }

    public void setIsRent() {
        this.isRent=false;
    }


    public int  apartmentNo() {return apartmentNo;}

    @Override
    public void displayInfo() {
        System.out.println("Binanın ismi:"+address+" kat:"+floorNo+" daire numarası:"+apartmentNo);
    }
}
