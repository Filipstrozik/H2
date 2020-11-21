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
    ZlecenieFigury(Figura fig) {
        f = fig;
    }

    public double kosztCiecia() {

        return 1.0* f.obwod();
    }


    public double kosztMaterialu() {
        return 1.0*f.pole();
    }
}

class ZlecenieFiguryZlozonej extends Zlecenie{
    FiguraZlozona f;
    ZlecenieFiguryZlozonej(Figura [] t){
        f=new FiguraZlozona(t);
    }


    @Override
    public double kosztCiecia() {
        return f.obwod();

    }

    @Override
    public double kosztMaterialu() {
        return f.pole();
    }
}

public class Main {

    public static void main(String[] args) {
        Kwadrat kw1= new Kwadrat(10);
        Kolo Kol1 = new Kolo(3);
        Prostokot Porst1 = new Prostokot(5,10);
        ZlecenieFigury z1 = new ZlecenieFigury(new Prostokot(7,8));
        FiguraZlozona fz = new FiguraZlozona(new Figura[]{kw1, Kol1});
        ZlecenieFiguryZlozonej z2 = new ZlecenieFiguryZlozonej(fz.fz);
        ZlecenieFiguryZlozonej z3 = new ZlecenieFiguryZlozonej(new Figura[]{new Kolo(10),new Kwadrat(10)});
        System.out.println(z1.kosztMaterialu());
        System.out.println(z2.kosztMaterialu());
        System.out.println(z3.kosztMaterialu());
        System.out.println("UDALO SIEEE z kompa do laptopa ");
    }
}
