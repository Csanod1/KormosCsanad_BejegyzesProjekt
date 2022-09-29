package hu.petrik;


import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static hu.petrik.Bejegyzes.*;

public class Main {
    public static List<Bejegyzes> bejegyzesLista = new ArrayList<>();
    public static List<Bejegyzes> atrendezettBejegyzesLista = new ArrayList<>();
    public static void main(String[] args) {
        Bejegyzes elsoBejegyzes = new Bejegyzes("Kormi Aladár", "Volt egyszer Hool nem volt");
        Bejegyzes masodikBejegyzes = new Bejegyzes("Volti Ferenc", "De minden megváltozott mikor a tűz népe támadást indított");
        bejegyzesLista.add(elsoBejegyzes);
        bejegyzesLista.add(masodikBejegyzes);
        Feladat2b();

        try {
            Beolvasas("bejegyzesek.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Feladat2d();



        System.out.println(bejegyzesLista);
        Feladat3a();
        Feladat3b();
        Feladat3c();
       // Feladat3d();
       // try {
       //     kiIras("bejegyzesek.csv");
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }

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
                System.out.printf("Kérem írja be a szöveget amelyre a(z) %d. elem szerzőjét szeretné beáálitani\n", (i+1));
                sc.nextLine();
                System.out.printf("Kérem írja be a szöveget amelyre a(z) %d. elem tartalmát szeretné beáálitani\n", (i+1));
                sc.nextLine();
            }
        }

    }
    public static void Beolvasas(String fajlNev) throws IOException {
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
    public static void Feladat2d(){
        int likeSzam = bejegyzesLista.size()*20;
        for (int i = likeSzam; i > 0; i--) {
            bejegyzesLista.get((int)(Math.random()*bejegyzesLista.size())).like();
        }
    }
    public static void Feladat2e(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem Írja be a szöveget amelyre cserélni szeretni a második bejegyzés tartalmát");
        String s = sc.nextLine();
        bejegyzesLista.get(1).setTartalom(s);
    }
    public static void Feladat3a(){
        int legnagyobbLikeszam = bejegyzesLista.get(0).getLikeok();
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            if (legnagyobbLikeszam < bejegyzesLista.get(i).getLikeok()){
                legnagyobbLikeszam = bejegyzesLista.get(i).getLikeok();
            }
        }
        System.out.println("Legtöbb like: " + legnagyobbLikeszam);
    }
    public static void Feladat3b(){
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            if (35 < bejegyzesLista.get(i).getLikeok()){
                System.out.println(bejegyzesLista.get(i).toString());
            }
        }
    }
    public static void Feladat3c(){
        int kevesebbMintLikeSzamlalo = 0;
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            if (15 > bejegyzesLista.get(i).getLikeok()){
                kevesebbMintLikeSzamlalo++;
            }
        }
        System.out.printf("%d db olyan bejegyzés van amely 15nél kevesebb likeot kapott\n", kevesebbMintLikeSzamlalo);
    }
    public static void Feladat3d(){
        String indexLista = "";

    }
    public static void kiIras(String fajlNev) throws IOException {
        FileWriter fw = new FileWriter(fajlNev);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            bw.write(bejegyzesLista.toString());
        }
        bw.close();
        fw.close();
    }


}
