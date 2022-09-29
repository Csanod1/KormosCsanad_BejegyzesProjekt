package hu.petrik;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Bejegyzes> bejegyzesLista = new ArrayList<>();
    public static void main(String[] args) {
        Bejegyzes elsoBejegyzes = new Bejegyzes("Kormi Aladár", "Volt egyszer Hool nem volt");
        Bejegyzes masodikBejegyzes = new Bejegyzes("Volti Ferenc", "De minden megváltozott mikor a tűz népe támadást indított");
        bejegyzesLista.add(elsoBejegyzes);
        bejegyzesLista.add(masodikBejegyzes);
    }
}
