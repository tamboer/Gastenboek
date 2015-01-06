
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.util.Date;
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
public class GastenboekManager {

    GastenboekEntry entry = null;
    Gastenboek gastenboek = null;
    String filename = "";

    public GastenboekManager(Gastenboek gastenboek) {
        setFilename(gastenboek.gastenboekNaam);
        this.gastenboek = gastenboek;
    }

    public GastenboekEntry newEntry() {

        Scanner input = new Scanner(System.in);

        //en de boodschap
        System.out.println("*** Please write in our guestbook? ***");
        String description = input.nextLine();

        //de opsteller 
        System.out.println("*** What is your name? ***");
        String name = input.nextLine();

        //timestamp 
        Date date = new java.util.Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(new Timestamp(date.getTime()));

        // entry = 
        return new GastenboekEntry(timestamp, name, description);

    }

    public void setFilename(String filename) {
        this.filename = filename + ".dat";
    }

    public void addEntry(GastenboekEntry entry) {
        gastenboek.addEntry(entry);

    }

    public void oversichtEntriesFromFile() {
        for (GastenboekEntry entry : gastenboek.getGastenboekEntriesFromFile()) {
            System.out.println(entry.getBoodschap() + "\n");
        }
    }

    public void oversichtEntries() {

        for (GastenboekEntry entry : gastenboek.getGastenboekEntries()) {
            System.out.println("Bedankt. Jouw boodschap \"" + entry.getBoodschap() + "\" is toegevoegd aan onze gastenboek");
        }
    }

    public void addEntryToFile(GastenboekEntry entry) {

        FileOutputStream file = null;//new FileInputStream();
        BufferedOutputStream buffer = null;
        ObjectOutputStream obj = null;

        try {
            file = new FileOutputStream(this.filename);
            buffer = new BufferedOutputStream(file);
            obj = new ObjectOutputStream(file);

            obj.writeObject(entry);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (obj != null) {
                try {
                    obj.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    public void addEntryFromFile() {
        File checkfile = new File(this.filename);
        if (checkfile.exists()) {

            // populate arraylist gastenboekEntriesFromFile
            FileInputStream file = null;
            //BufferedInputStream buffer = null;
            ObjectInputStream obj = null;
            GastenboekEntry entry = null;
            try {

                file = new FileInputStream(this.filename);
                //buffer = new BufferedInputStream(file);
                obj = new ObjectInputStream(file);

                //entry = (GastenboekEntry) obj.readObject();
                entry = (GastenboekEntry) obj.readObject();
                gastenboek.populateList(entry);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (obj != null) {
                    try {
                        obj.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void save(Gastenboek gastenboek) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gastenboek);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Gastenboek load() {
        File checkfile = new File(this.filename);
        if (checkfile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.filename);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (Gastenboek) objectInputStream.readObject();
            } catch (Exception ex) {
                System.out.println(ex);
                return null;
            }
        } else {
            return new Gastenboek("new_gastenboek");
        }
    }
}
