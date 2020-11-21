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
    ZlecenieFigury();

    public double kosztCiecia() {
        return ;
    }


    public double kosztMaterialu() {
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {
	Kwadrat kw1= new Kwadrat(10);
	Kolo Kol1 = new Kolo(3);
    }
}
