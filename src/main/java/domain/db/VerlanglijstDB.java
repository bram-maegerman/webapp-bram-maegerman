package domain.db;

import domain.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerlanglijstDB {

    private int sequence = 0;
    private static final List<Item> verlanglijst = new ArrayList<>();

    public VerlanglijstDB(){
        this.voegtoe(new Item("Intel Processor", 350, 1, "Grijs"));
        this.voegtoe(new Item("Ikea Bureaustoel", 80, 1, "Zwart"));
        this.voegtoe(new Item("Bijbel", 66.6, 1, "Grijs"));
    }

    public void voegtoe(Item item){
        this.sequence++;
        item.setId(sequence);
        verlanglijst.add(item);
    }

    public void voegtoe(Item item, int id){
        item.setId(id);
        verlanglijst.add(item);
        verlanglijst.sort(new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Integer.compare(i1.getId(), i2.getId());
            }
        });
    }

    public boolean pasAan(int id, Item item){
        if(this.searchById(id) != null){
            int i = verlanglijst.indexOf(this.searchById(id));
            verlanglijst.get(i).setNaam(item.getNaam());
            verlanglijst.get(i).setPrijs(item.getPrijs());
            verlanglijst.get(i).setHoeveelheid(item.getHoeveelheid());
            verlanglijst.get(i).setKleur(item.getKleur());
            return true;
        }
        return false;
    }

    public boolean verwijder(int id){
        for(Item i: verlanglijst){
            if(id == i.getId()){
                verlanglijst.remove(i);
                return true;
            }
        }
        return false;
    }

    public Item zoekItem(String naam){
        for(Item i: verlanglijst){
            if(naam.equals(i.getNaam())){
                return i;
            }
        }
        return null;
    }

    public Item searchById(int id){
        for(Item i: verlanglijst){
            if(id == i.getId()){
                return i;
            }
        }
        return null;
    }

    public List<Item> getVerlanglijst() {
        return verlanglijst;
    }

    public Item getDuurste(){
        Item duurste = verlanglijst.get(0);
        for(int i = 1; i < verlanglijst.size(); i++){
            if(verlanglijst.get(i).getPrijs() > duurste.getPrijs()){
                duurste = verlanglijst.get(i);
            }
        }
        return duurste;
    }

    public Item findClosest(String str, List<Item> items, int i, boolean gevonden){
        List<Item> closeItems = new ArrayList<>();
        if(str.length() >= i + 1){
            for (Item item : items) {
                if (item.getNaam().charAt(i) == str.charAt(i)) {
                    closeItems.add(item);
                }
            }
        }
        else{
            return items.get(0);
        }

        if(closeItems.size() == 1){
            return closeItems.get(0);
        }
        else if(closeItems.size() > 1){
            return this.findClosest(str, closeItems, i + 1, true);
        }
        else if(gevonden){
            return items.get(0);
        }
        return null;
    }
}
