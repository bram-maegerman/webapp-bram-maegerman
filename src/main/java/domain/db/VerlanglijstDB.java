package domain.db;

import domain.model.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VerlanglijstDB {

    private int sequence = 0;
    private static final List<Item> verlanglijst = new ArrayList<>();

    public VerlanglijstDB() {
        this.voegtoe(new Item("Intel Processor", 350, 1, "Grijs"));
        this.voegtoe(new Item("Ikea Bureaustoel", 80, 1, "Zwart"));
        this.voegtoe(new Item("Bijbel", 66.6, 1, "Grijs"));
    }

    public void voegtoe(Item item){
        this.sequence++;
        item.setId(sequence);
        verlanglijst.add(item);
    }

    public List<Item> getVerlanglijst() {
        return verlanglijst;
    }

    public Item getDuurste(){
        Item duurste = verlanglijst.get(0);
        for(int i = 1; i < verlanglijst.size() - 1; i++){
            if(verlanglijst.get(i).getPrijs() > duurste.getPrijs()){
                duurste = verlanglijst.get(i);
            }
        }
        return duurste;
    }
}
