package domain;

import java.util.ArrayList;
import java.util.List;

public class VerlanglijstDB {

    private int sequence = 0;
    private final List<Item> verlanglijst = new ArrayList<>();

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
}
