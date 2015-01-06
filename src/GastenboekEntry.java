
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Willem
 */
public class GastenboekEntry implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Timestamp tijdstip = null;
    private String schrijverNaam = "";
    private String boodschap = "";
    
    public GastenboekEntry(Timestamp tijdstip, String schrijverNaam, String boodschap) {
        setTijdstip(tijdstip);
        setSchrijverNaam(schrijverNaam);
        setBoodschap(boodschap);
    }
    
    public Timestamp getTijdstip() {
        return tijdstip;
    }
    
    public void setTijdstip(Timestamp tijdstip) {
        this.tijdstip = tijdstip;
    }
    
    public String getSchrijverNaam() {
        return schrijverNaam;
    }
    
    public void setSchrijverNaam(String schrijverNaam) {
        this.schrijverNaam = schrijverNaam;
    }
    
    public String getBoodschap() {
        return boodschap;
    }
    
    public void setBoodschap(String boodschap) {
        this.boodschap = boodschap;
    }
    
}
