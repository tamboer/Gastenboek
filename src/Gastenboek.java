
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Willem
 */
public class Gastenboek implements Serializable {

    private static final long serialVersionUID = 1L;
    String gastenboekNaam = "";
    private List<GastenboekEntry> gastenboekEntries = new ArrayList<>();

    public Gastenboek(String gastenboekNaam) {
        this.gastenboekNaam = gastenboekNaam;
    }

    public void addEntry(GastenboekEntry entry) {
        gastenboekEntries.add(entry);
    }

    public List<GastenboekEntry> getGastenboekEntries() {
        return gastenboekEntries;
    }

}
