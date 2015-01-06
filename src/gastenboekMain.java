
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Willem
 */
public class gastenboekMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        GastenboekManager vdabGastenboekManager = new GastenboekManager();
        Gastenboek vdabGastenboek;// = new Gastenboek("vdab-gastenboek");

        System.out.println("press 1 to write in our Guestbook or press 2 to read our guestbook");

        switch (input.nextInt()) {
            case 1:
                GastenboekEntry entry = vdabGastenboekManager.newEntry();
                vdabGastenboek = vdabGastenboekManager.load();
                vdabGastenboek.addEntry(entry);
                vdabGastenboekManager.save(vdabGastenboek);
                //vdabGastenboekManager.oversichtEntries();
                break;
            case 2:
                vdabGastenboek = vdabGastenboekManager.load();

                List<GastenboekEntry> entries = vdabGastenboek.getGastenboekEntries();
                Collections.reverse(entries);
                for (GastenboekEntry entryLn : entries) {
                    System.out.println(entryLn.getTijdstip() + ":" + entryLn.getSchrijverNaam() + ":" + entryLn.getBoodschap());
                }
                break;
        }
    }

}
