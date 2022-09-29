package hu.petrik;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public void like(){
        this.likeok += 1;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatum = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = String.format("%s - %d - %s", this.szerzo, this.likeok, this.letrejott.format(formatum));
        if (this.szerkesztve.isAfter(this.letrejott)){
            return  String.format(s + "\nSzerkesztve: %s\n%s", this.szerkesztve.format(formatum), this.tartalom);
        }else {
            return  String.format(s +"\n%s", this.tartalom);
        }
    }
}
