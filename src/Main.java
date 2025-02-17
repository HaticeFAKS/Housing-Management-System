import java.util.*; // scanner, ArrayList, collections sort ve lisler için eklendi.


import static java.lang.System.out;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Bina> buildingList = new ArrayList<>();
    static ArrayList<evSahibi> homeOwnerList = new ArrayList<>();
    static ArrayList<Kiraci> renterList = new ArrayList<>();
    static char selection = '\0';
    static char choice = '\0';
    static String name = "\0";
    static String surname = "\0";
    static String renterName = "\0";
    static String renterSurname = "\0";
    static int Floor = 0;
    static int apartmentNo = 0;

    public static void main(String[] args) {


        out.println("Konut Yönetim Sistemine Hoş Geldiniz!");
        do {
            out.println("----------------------------------- ");
            out.println("1-Bina ekleme");
            out.println("2-Daire ekleme");
            out.println("3-Bir evi kiralama");
            out.println("4-Sistemdeki daireleri görüntüleme");
            out.println("----------------------------------");
            out.print("Lütfen yapmak istediğiniz işlemi giriniz:");


            selection = scanner.next().charAt(0);

            switch (selection) {
                case '1':
                    binaEkleme();
                    break;

                case '2':
                    daireEkleme();
                    break;
                case'3':
                    evKiralama();
                    break;

                case '4':
                    goruntuleme();
                    break;

                default:
                    System.out.println("Geçersiz bir giriş yaptınız!");
                    break;

                    }

                    System.out.println("Yapmak istediğiniz bir işlem var mı?");
                    System.out.print("Evet ise E veya e değilse h veya H giriniz:");

                    choice = scanner.next().charAt(0);

                    while (choice != 'E' && choice != 'e' && choice != 'H' && choice != 'h') {
                        System.out.println("Geçersiz bir giriş yaptınız!");
                        System.out.print("Lütfen tekrar giriniz:");

                        choice = scanner.next().charAt(0);
                    }

            } while (choice == 'E' || choice == 'e') ;

          scanner = null;
          buildingList = null;
          homeOwnerList = null;
          renterList = null;
          selection = '\0';
          choice = '\0';
          name = "\0";
          surname = "\0";
          renterName = "\0";
          renterSurname = "\0";
          Floor = 0;
          apartmentNo = 0;
        }

        public static void binaEkleme() {
            out.print("Lütfen binanın ismini giriniz:");
            name = scanner.next();
            for (Bina bina : buildingList) {

                if (bina.address().equals(name)) { //Bina önceden eklenmişse döndürür
                    out.println("Böyle bir bina zaten var!");
                    return;
                }
            }
            out.print("Lütfen Binanın kat sayısını giriniz:");
            Floor = scanner.nextInt();

            buildingList.add((new Bina(name, Floor)));
            out.println("Bina başarıyla eklendi!");

        }

        public static void daireEkleme() {
            if (buildingList.isEmpty()) {

                out.println("Lütfen sisteme bina ekledikten sonra daire ekleyiniz!");
                return;
            }

            out.print("Lütfen ekleyeceğiniz dairenin bina ismini giriniz:");
            name = scanner.next();
            name=name.toLowerCase();


            for (Bina building : buildingList) {
                if (building.address().equals(name)) { //bina  bulunursa aşağıdaki işlemler yapılır
                    out.print("Lütfen kaçıncı katta olduğunu giriniz:");
                    Floor = scanner.nextInt();
                    if (Floor>building.numberOfFloors()) {
                        out.println("Geçersiz kat sayısı girdiniz!");
                        return;

                    }
                    else {
                        out.print("Lütfen daire numarasını giriniz:");
                        apartmentNo = scanner.nextInt();

                        if(apartmentNo!=((2*Floor)+1) && apartmentNo!=((2*Floor)+2)) { //daire kısıtlaması vardır.
                            out.println("Geçersiz bir daire numarası girdiniz.");
                            out.println("Bu katta sadece "+((2*Floor)+1)+" ve "+((2*Floor)+2)+" numaralı daireler bulunabilir.");
                            return;
                        }

                            for(evSahibi homeOwner: homeOwnerList) {
                                for (Daire Daire : homeOwner.apartmentList()) {
                                    if(name.equals(Daire.address()) && apartmentNo==Daire.apartmentNo()) {
                                        out.println("Böyle bir daire zaten var!");
                                        return;
                                    }

                                }
                            }
                        Daire newDaire=new Daire(name,Floor,apartmentNo);
                            out.print("Lütfen daire sahibinin ismini giriniz:");
                            name = scanner.next();
                            name=name.toLowerCase();

                            out.print("Lütfen daire sahibinin soyismini giriniz:");
                            surname = scanner.next();
                            surname=surname.toLowerCase();
                            for(evSahibi homeOwner: homeOwnerList) {
                                if (name.equals(homeOwner.getName()) && surname.equals(homeOwner.getSurname())) {
                                    if(building==homeOwner.building() ) {
                                        out.println("Ev sahibi bulundu!");//ev sahibi zaten varsa ekler.
                                        homeOwner.addApartment(newDaire);
                                        out.println("Yeni daireniz başarıyla eklendi! Hayırlı olsun!");
                                        return;
                                    } else {//bina ismi farklıysa hata verir. Çünkü sadece aynı binadan alabilir.
                                        out.println("sadece aynı binadan ev alabilirsiniz! Üzgünüz.");
                                        return;
                                    }
                                }
                            }
                            out.println("Yeni ev sahibi kaydı oluşturuluyor."); //ev sahibi yoksa  oluşturup ekler.
                            evSahibi homeOwner=new evSahibi(name,surname,building);
                            homeOwner.addApartment(newDaire);
                            homeOwnerList.add(homeOwner);
                            out.println("Yeni daireniz başarıyla eklendi! Hayırlı olsun!");
                            return;
                        }
                    }
                }

            out.println("Geçersiz bir bina ismi girdiniz!");
        }


        public static void  evKiralama() {
            if(homeOwnerList.isEmpty()) {
                out.println("Sisteme daire eklemediniz! Lütfen ekledikten sonra deneyiniz.");
                return;
            }
            out.print("Lütfen kiracnın ismini giriniz:");
            renterName = scanner.next();
            renterName = renterName.toLowerCase();
            out.print("Lütfen kiracının soyismini giriniz:");
            renterSurname = scanner.next();
            renterSurname = renterSurname.toLowerCase();
            for(Kiraci renter: renterList) {
                if(renterName.equals(renter.getName()) && renterSurname.equals(renter.getSurname())) {
                    out.println("Bu kiracı var!");
                    return;
                }
            }
            out.println("Kiralanabilir dairelerin bilgileri ektedir:");
            for(evSahibi homeOwner: homeOwnerList) {
                for (Daire apartment : homeOwner.apartmentList()) {
                    if (apartment.isRent()) {
                        homeOwner.displayInfo();
                        apartment.displayInfo();
                        out.println("\n");
                    }
                }
            }
            out.print("Lütfen kiralamak istediğiniz dairenin bina ismini giriniz:");
            name=scanner.next();
            name=name.toLowerCase();
            out.print("daire numarasını giriniz:");
            apartmentNo=scanner.nextInt();
            for(evSahibi homeOwner: homeOwnerList) {
                for (Daire apartment : homeOwner.apartmentList()) {
                    if ( name.equals(homeOwner.building().address) && apartmentNo==apartment.apartmentNo() && apartment.isRent()) {
                        apartment.setIsRent();
                        renterList.add(new Kiraci(renterName,renterSurname,homeOwner));
                        out.println("Başarıyla kiralama işlemi gerçekleşti!");
                        return;
                    }
                }
            }
            out.print("Geçersiz bir değer girdiniz!");
        }


        public static void goruntuleme() {
            if(homeOwnerList.isEmpty()) {
                out.println("\nSisteme kayıt eklenmedi!");
                return;

            }
            for (evSahibi owner:homeOwnerList) {
                owner.displayInfo();
                for (Daire apartment: owner.apartmentList()) {
                    apartment.displayInfo();
                    if(!apartment.isRent()) {
                        out.print("Kiralandı.Kiracının adı:");
                        for(Kiraci renter: renterList) {
                            if(owner==renter.getEvSahibi()) {
                                renter.displayInfo();
                            }
                        }
                    }else{
                        out.print("kiralanmadı");

                    }
                    out.println("\n");
                }
            }

        }
    }
