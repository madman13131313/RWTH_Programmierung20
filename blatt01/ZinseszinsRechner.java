public class ZinseszinsRechner {
    public static void main(String[] args) {
        double startBetrag=0;
        double zinssatz=0;
        String zielOderZeit;
        double zielBetrag=0;
        int jahr=0;
        int zeit=0;
        double currentBetrag;

        while(startBetrag <= 0) {
            startBetrag = SimpleIO.getDouble("Bitte geben Sie den Startbetrag ein.");
        }

        while(zinssatz <= 0) {
            zinssatz = SimpleIO.getDouble("Bitte geben Sie den Zinssatz als Prozentwert ein.");
        }
        
        zielOderZeit=SimpleIO.getString("Bitte waehlen Sie aus: \n Ziel : Berechnet die Zeit , bis ein gegebener Betrag angespart wurde . \n Zeit : Berechnet den Betrag , der nach einer gegebenen Zeit angespart wurde .");

        currentBetrag = startBetrag;
        if (zielOderZeit.equals("Ziel")) {
            while(zielBetrag <= startBetrag) {
                zielBetrag = SimpleIO.getDouble("Bitte geben Sie den Zielbetrag ein.");
            }
            
            while(currentBetrag < zielBetrag){
                currentBetrag= currentBetrag*(1+zinssatz/100);
                jahr +=1;
            }

            SimpleIO.output("Es dauert " + jahr + " Jahre bei einem Zinssatz von " + zinssatz + "%, um von " + startBetrag + " auf den Betrag " + zielBetrag +
            " zu sparen . Nach dieser Zeit hat man " + currentBetrag + ".");
        }
        else if (zielOderZeit.equals("Zeit")) {
            while(zeit <= 0) {
                zeit = SimpleIO.getInt("Bitte geben Sie den Zeit ein.");
            }
                for(int i=1; i<=zeit; i++) {
                    currentBetrag*=(1+zinssatz/100);
                }

                SimpleIO.output("Bei einem Zinssatz von " + zinssatz + "% und einem Startbetrag von " + startBetrag + " hat man nach " +
                zeit + " Jahren " + currentBetrag + " gespart.");    
        }
        else{ 
            SimpleIO.output("Fehler: Das ist nicht eine gütige Wahl.");
        }
    }
}
