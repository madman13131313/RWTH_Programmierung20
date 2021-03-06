public class Karte {
    Farbe farbe;
    Wert wert;
    public String toString(){
        return (farbe.toString() + wert.toString());
    }
    public static Karte neueKarte(Farbe f, Wert w){
        Karte neu=new Karte();
        neu.farbe=f;
        neu.wert=w;
        return neu;
    }
    public static Karte neuKarte(String f, String w){
        return neueKarte(Farbe.valueOf(f), Wert.valueOf(w));        
    }

    public static int kombinationen(){
        Farbe[] farben = Farbe.values();
        Wert[] werten = Wert.values();
        return (farben.length*werten.length);
    }

    public static Karte[] skatblatt(){
        Karte[] karten=new Karte[kombinationen()];
        int n=0;
        int m=0;
        for (int i =0; i<kombinationen();i++){
            if (m<Wert.values().length){
                karten[i]=neueKarte(Farbe.values()[n],Wert.values()[m]);
                m++;
            }
            else{
                n++;
                m=0;
                karten[i]=neueKarte(Farbe.values()[n],Wert.values()[m]);
                m++;
            }
        }
        return karten;
    }

    public boolean bedient(Karte other){
        boolean bedient;
        if (this.farbe==other.farbe||this.wert==other.wert||this.wert==Wert.BUBE){
            bedient=true;
        }
        else {
            bedient=false;
        }
        return bedient;
    }
    public boolean bedienbar(Karte...karten){
        boolean bedienbar = false;
        for (int i =0; i<karten.length; i++){
            if (this.bedient(karten[i])){
                bedienbar=true;
            }
        }
        return bedienbar;
    }

    public static void druckeEinbahnBedienungen(){
        for (int i =0; i<skatblatt().length; i++){
            for (int j =0; j<skatblatt().length; j++){
                if (skatblatt()[i]!=skatblatt()[j] && skatblatt()[i].bedient(skatblatt()[j])&& !skatblatt()[j].bedient(skatblatt()[i])){
                    System.out.println(skatblatt()[i] + " bedient " + skatblatt()[j] + ", aber " + skatblatt()[j] + " nicht " + skatblatt()[i] + ".");
                }
            }
        }
    }

}
