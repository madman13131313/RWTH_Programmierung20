/**
 * 
 * Klasse Product, welche die Verfuegbarkeit eines bestimmten Produkts repraesentiert.
 * 
 * @author LinyueXue & Yejun Tang
 * 
 */
public class Product extends BooleanStringHelpers{
    /**
     * Name des Produkts
     */
    private String name;
    
    /**
     * Attribut regionalVerfuegbar, speichert als boolean-Array, ob das Produkt in jeden Monat als Regionalware verfuegbar
     */
    private boolean[] regionalVerfuegbar;
    /**
     * Attribut importVerfuegbar, speichert als boolean-Array, ob das Produkt in jeden Monat als Importware verfuegbar
     */
    private boolean[] importVerfuegbar;
    
    /**
     * Konstruktor, der neues Produkt mit uebergebenen Parameter name, 
     * regionalVerfuegbar(boolean-Array) und importVerfuegbar(boolean-Array) initialisiert.
     * 
     * @param n Name des neuen Produkts
     * @param r boolean-Array, ob das Produkt in jeden Monat als Regionalware verfuegbar
     * @param i boolean-Array, ob das Produkt in jeden Monat als Importware verfuegbar
     */
    public Product(String n, boolean[] r,  boolean[] i){
        this.name=n;
        this.regionalVerfuegbar=r;
        this.importVerfuegbar=i;
    }
    
    /**
     * Konstruktor, der neues Produkt mit uebergebenen Parameter name, 
     * regionalVerfuegbar(String) und importVerfuegbar(String) initialisiert.
     * 
     * @param n Name des neuen Produkts
     * @param r String, ob das Produkt in jeden Monat als Regionalware verfuegbar
     * @param i String, ob das Produkt in jeden Monat als Importware verfuegbar
     */
    public Product(String n, String r, String i){
        if (r.length()==12||i.length()==12){
            this.name=n;
            this.regionalVerfuegbar=BooleanStringHelpers.parse(r,'1');
            this.importVerfuegbar=BooleanStringHelpers.parse(i, '1');
        }
        else{
            System.out.println("Invalid Input");
        }
    }
    
    /**
     * Name auslesen.
     * 
     * @return Name des Produkts
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Diese Methode zurueckgibt, der ein R für die Monate enthaelt, 
     * in denen das Produkt als Regionalware verfuegbar ist und ein Leerzeichen fuer alle anderen Monate.
     * 
     * @return ein String mit R und Leerzeichen, zeigt Regionalverfuegbarkeit des Produkts in jeden Monate.
     */
    public String stringifyIsRegional(){
        return BooleanStringHelpers.stringify('R',' ',this.regionalVerfuegbar);
    }
    
    /**
     * Diese Methode zurueckgibt, der ein I fuer die Monate enthaelt, 
     * in denen das Produkt als Importware verfuegbar ist und ein Leerzeichen für alle anderen Monate.
     * 
     * @return ein String mit I und Leerzeichen, zeigt Importverfuegbarkeit des Produkts in jeden Monate.
     */
    public String stringifyIsImported(){
        return BooleanStringHelpers.stringify('I',' ',this.importVerfuegbar);
    }
}