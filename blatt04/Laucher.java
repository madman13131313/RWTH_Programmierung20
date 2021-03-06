/**
 * 
 * Klasse Laucher, den Saisonkalender in Aufgabe3 mithilfe der zuvor erstellten Klassen erzeugen und ausgeben
 * 
 * @author LinyueXue & Yejun Tang
 * 
 */
public class Laucher{
    /**
     * Erzeugung und Ausgabe vom Saisonkalendar in Aufgabe3
     *
     * @param args Ein Array von Befehlszeilenargumenten fuer die Anwendung
     */
    public static void main(String...args){
        Product apfel =new Product("Apfel","111111001111","111111111111");
        Product banane =new Product("Banane","000000000000","111111111111");
        Product erdbeere =new Product("Erdbeere","000011100000","000110000000");
        Product blumenkohl =new Product("Blumenkohl","000001111100","111100000011");
        Product feldsalat =new Product("Feldsalat","100011001111","111100001111");
        Product zwiebel =new Product("Zwiebel","111110011111","001111100000");
        Product[] allProducts =new Product[] {apfel, banane, erdbeere, blumenkohl, feldsalat, zwiebel};
        
        SeasonalCalendar seasonalCalendar1 = new SeasonalCalendar(allProducts);
        System.out.println(seasonalCalendar1.stringify());
    }
}