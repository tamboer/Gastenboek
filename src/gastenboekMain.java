
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
        Gastenboek vdabGastenboek = new Gastenboek("vdab-gastenboek");
        GastenboekManager vdabGastenboekManager = new GastenboekManager(vdabGastenboek);

        System.out.println("press 1 to write in our Guestbook or press 2 to read our guestbook");
        int choice = input.nextInt();

        if (choice == 1) {
            //lkjlkj
            GastenboekEntry entry = vdabGastenboekManager.newEntry();
            vdabGastenboekManager.addEntry(entry);
            vdabGastenboekManager.addEntryToFile(entry);
            vdabGastenboekManager.oversichtEntries();
        } else {
            vdabGastenboekManager.addEntryFromFile();
            vdabGastenboekManager.oversichtEntriesFromFile();
        }
    }

}
