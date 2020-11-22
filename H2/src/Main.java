class Firma {
    int k=0;
    int max=100;
    Pracownik [] tabPracownikow;
    Firma (){
        tabPracownikow=new Pracownik[max];
    }
    public void przyjmijNowegoPracownika(Pracownik p){
        if(k<max){
            tabPracownikow[k++]=p;
        }
    }

}


abstract class Pracownik{
    String nazwisko;
    double czesc_etatu;
    public Pracownik(String n,double cz_et){
        nazwisko=n;
        czesc_etatu=cz_et;
    }

    abstract double placa();
}


class Robotnik extends Pracownik{
    int limitGodzin=40;
    int liczbaGodzin;
    double stawkaGodzinowa;
    public Robotnik(String n,double cz_et,int liczba_godzin,double stawka_godzinowa){
        super(n,cz_et);
        liczbaGodzin=liczba_godzin;
        stawkaGodzinowa=stawka_godzinowa;
        limitGodzin=(int)czesc_etatu*limitGodzin;
    }

    public double placa(){
        double suma;
        if(liczbaGodzin>=limitGodzin){
            suma =(liczbaGodzin-limitGodzin)*stawkaGodzinowa*1.5 + limitGodzin*stawkaGodzinowa;
        }
        else{
            suma = liczbaGodzin*stawkaGodzinowa;
        }
        return suma;
    }
}


class NieRobotnik extends Pracownik{
    double placa_podst =1350.0;
    int liczbaGodzin;
    int procentPremii;
    public NieRobotnik(String n,double cz_et,int liczba_godzin, int procent_premii){
        super(n,cz_et);
        liczbaGodzin=liczba_godzin;
        procentPremii=procent_premii;
    }

    public double placa(){
        return placa_podst*czesc_etatu+procentPremii*0.01*placa_podst;
    }
}


public class Main {


    public static void main(String[] args) {

        Firma f = new Firma();
        f.przyjmijNowegoPracownika(new Robotnik("Kowalski",0.5,40,25.6));
        System.out.println(f.tabPracownikow[0].nazwisko+f.tabPracownikow[0].placa());
        f.przyjmijNowegoPracownika(new NieRobotnik("Nowak",0.5,40,70));
        System.out.println(f.tabPracownikow[1].nazwisko+f.tabPracownikow[1].placa());
    }
}
