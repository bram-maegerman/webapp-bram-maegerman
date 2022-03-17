package domain.model;

public class Item {

    private int id;
    private String naam;
    private double prijs;
    private int hoeveelheid;
    private String kleur;

    public Item(String naam, double prijs, int hoeveelheid, String kleur) {
        this.naam = naam;
        this.prijs = prijs;
        this.hoeveelheid = hoeveelheid;
        this.kleur = kleur;
    }

    public void pasAan(){

    }

    public void verwijder(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
