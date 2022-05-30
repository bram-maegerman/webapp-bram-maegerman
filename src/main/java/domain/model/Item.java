package domain.model;

import domain.DomainException;

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

    public Item(){}

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public String getKleur() {
        return kleur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        if(naam.isBlank()){
            throw new DomainException("Naam mag niet enkel bestaan uit spaties.");
        }
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        if(prijs < 0){
            throw new DomainException("Prijs mag niet kleiner zijn dan 0.");
        }
        this.prijs = prijs;
    }

    public void setHoeveelheid(int hoeveelheid) {
        if(hoeveelheid < 1){
            throw new DomainException("Hoeveelheid mag niet kleiner zijn dan 1.");
        }
        this.hoeveelheid = hoeveelheid;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }
}
