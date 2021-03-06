/**
 * 
 * Klasse SeasonalCalendar, welche Informationen zur Verfuegbarkeit bestimmter Produkte enthaelt 
 * und diese in einen gut lesbaren String umwandeln kann.
 * 
 * @author LinyueXue & Yejun Tang
 * 
 */
public class SeasonalCalendar{
    
    /**
     * Attribut alleProdukte, enthaelt alle Produkte, ueber die der Saisonkalender Informationen enthalten soll.
     */
    private Product[] alleProdukte;
    
    /**
     * Konstruktor, der der Saisonkalender mit Parameter alleProdukte initialisiert.
     * 
     * @param p alle Produkte
     */
    public SeasonalCalendar(Product[] p){
        this.alleProdukte=new Product[p.length];
        for(int i=0;i<p.length;i++){
            this.alleProdukte[i]=p[i];
        }
    }
    
    /**
     * 
     * unter allen im Attribut gespeicherten Produkten den laengsten Produktnamen aussuchen,und die Laenge zurueckgeben
     * 
     * @return die Laenge des laengsten Produktsnames
     */
    public int getLongestProductName(){
        int max=0;
        for(Product x : this.alleProdukte){
            if (x.getName().length()>max){
                max=x.getName().length();
            }
        }
        return max;
    }
    
    /**
     * 
     * Diese Methode pad, welche einen String-Parameter, einen int-Parameter sowie einen char-Parameter erhaelt 
     * und den String-Parameter, etwas modifiziert, wieder zurueckgibt. 
     * Falls naemlich der String-Parameter kuerzer ist als der uebergebene int-Parameter, 
     * so wird an den Rueckgabewert solange der uebergebene char-Parameter angehaengt, 
     * bis dieser die Laenge des uebergebenen int-Parameters hat.
     * 
     * @param n der uebergebene String
     * @param l die uebergebene Zahl
     * @param x das uebergebene Zeichnen
     * return der modifizierte String
     */
    public String pad(String n, int l, char x){
        StringBuilder s= new StringBuilder(n);
        while (s.length()<l){
            s.append(x);
        }
        return s.toString();
    }
    
    /**
     * 
     * Eine Methode zurueckgibt einen String, der eine gut lesbare Repraesentation des Saisonkalenders enthalten soll.
     * 
     * @return eine Tabelle des Saisonkalenders von allen Produkten
     */
    public String stringify(){
        int longest=this.getLongestProductName();
        StringBuilder s=new StringBuilder();
        StringBuilder space=new StringBuilder();
        for (int i=1; i<=longest+2; i++){
            space.append(" ");
        }
        s.append(space.toString() + "JFMAMJJASOND"+System.lineSeparator());
        for (Product p: this.alleProdukte){
            s.append(this.pad(p.getName() + ":", longest+2,' ') + p.stringifyIsRegional() + 
            System.lineSeparator() + space.toString() + 
            p.stringifyIsImported() + System.lineSeparator());
        }
        return s.toString();
    }
}