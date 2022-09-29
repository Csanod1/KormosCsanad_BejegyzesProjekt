package hu.petrik;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Bejegyzes> bejegyzesLista = new ArrayList<>();
    public static void main(String[] args) {
        Bejegyzes elsoBejegyzes = new Bejegyzes("Kormi Aladár", "Volt egyszer Hool nem volt");
        Bejegyzes masodikBejegyzes = new Bejegyzes("Volti Ferenc", "De minden megváltozott mikor a tűz népe támadást indított");
        bejegyzesLista.add(elsoBejegyzes);
        bejegyzesLista.add(masodikBejegyzes);
    }

    public void Feladat2b(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem adja meg hány db bejegyzést szeretne hozzáadni:");
        double bekertDarabszam = sc.nextDouble();
        double leKerekitettDarabszam = Math.floor(bekertDarabszam);
        if (bekertDarabszam > leKerekitettDarabszam){
            System.err.println("Nem természetes számot adott meg");
        }else{
            for (int i = 0; i < bekertDarabszam; i++) {
                bejegyzesLista.add(new Bejegyzes("Szerző" + (i+1),"Tartalom"+ (i+1)));
            }
        }

    }
}
