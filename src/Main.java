abstract class Figura{
    public abstract double pole();
    public abstract double obwod();
}

class Kolo extends Figura{
    double r;
    Kolo(double r){
        super();
        this.r=r;
    }

    public double pole() {
        return 3.14*r*r;
    }
    public double obwod(){
        return 2*3.14*r;
    }
}

class Prostokot extends Figura{
    double a,b;
    public Prostokot(double bok1,double bok2){
        super();
        a=bok1;
        b=bok2;
    }

    public double pole() {
        return a*b;
    }

    public double obwod() {
        return 2*(a+b);
    }
}

class Kwadrat extends Prostokot{
    public Kwadrat(double bok){
        super(bok,bok);
    }
}

class FiguraZlozona extends Figura{
    Figura [] fz;
    FiguraZlozona(Figura [] figz){
        fz=new Figura[figz.length];
        for(int i=0;i<fz.length;i++){
            fz[i]=figz[i];
        }
    }
    public void dopiszFigure(Figura f){
        Figura []temp = new Figura[fz.length+1];
        for(int i=0;i<fz.length;i++){
            temp[i]=fz[i];
        }
        temp[fz.length]=f;
        fz=temp;
    }

    public double pole() {
        double s=0.0;
        for(Figura f:fz)
        {
            s+=f.pole();
        }
        return s;
    }

    public double obwod(){
        double s=0.0;
        for(Figura f:fz)
        {
            s+=f.obwod();
        }
        return s;
    }
}

abstract class Zlecenie{
    public abstract double kosztCiecia();
    public abstract double kosztMaterialu();
}

class ZlecenieFigury extends Zlecenie{
    Figura f;
    double cena_za_material =1.7;
    double cena_za_ciecie = 0.8;

    ZlecenieFigury(Figura fig) {
        f = fig;
    }

    public double kosztCiecia() {

        return cena_za_ciecie* f.obwod();
    }

    public double kosztMaterialu() {
        return cena_za_material*f.pole();
    }
}

class ZlecenieFiguryZlozonej extends Zlecenie{
    FiguraZlozona f;
    double cena_za_material =1.7;
    double cena_za_ciecie = 0.8;
    ZlecenieFiguryZlozonej(Figura []t){
        f=new FiguraZlozona(t);
    }

    public void dopiszZlecenieFigury(Figura f){
        this.f.dopiszFigure(f);
    }

    public double kosztCiecia() {
        return cena_za_ciecie*f.obwod();

    }

    public double kosztMaterialu() {
        return cena_za_material*f.pole();
    }
}

public class Main {

    public static void main(String[] args) {
        Kwadrat kw1= new Kwadrat(10);
        Kolo kol1 = new Kolo(3);
        Prostokot porst1 = new Prostokot(5,10);
        ZlecenieFigury z1 = new ZlecenieFigury(new Prostokot(7,8));
        FiguraZlozona fz = new FiguraZlozona(new Figura[]{kw1, kol1});
        ZlecenieFiguryZlozonej z2 = new ZlecenieFiguryZlozonej(fz.fz);
        ZlecenieFiguryZlozonej z3 = new ZlecenieFiguryZlozonej(new Figura[]{new Kolo(10),new Kwadrat(10)});
        System.out.println("koszt materiału z1 = "+z1.kosztMaterialu());
        System.out.println("koszt ciecia z1 = "+z1.kosztCiecia());
        System.out.println("koszt materialu z2 = "+z2.kosztMaterialu());
        System.out.println("koszt materialu zlecenia figury zlozonej = "+z3.kosztMaterialu());
        System.out.println("koszt ciecia zlecenia figury zlozonej = "+z3.kosztCiecia());
        z3.dopiszZlecenieFigury(kw1);
        System.out.println("koszt materialu zlecenia figury zlozonej po dodaniu figury = "+z3.kosztMaterialu());
        System.out.println("koszt ciecia zlecenia figury zlozonej po dodaniu figury = "+z3.kosztCiecia());
    }
}
