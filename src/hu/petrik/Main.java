package hu.petrik;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static void Feladat2b(){
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
    public static void Bejegyzesek(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && !sor.equals("")) {
            String[] adatok = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(adatok[0], adatok[1]);
            bejegyzesLista.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }


}
