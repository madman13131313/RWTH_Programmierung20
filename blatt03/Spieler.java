import jdk.javadoc.internal.tool.resources.javadoc;

public class Spieler {
    Karte[] kartenhand;
    String name;
    double siegesQuote;

    public String toString() {
        return (name);
    }

    public static Spieler besterSpieler(Spieler... club) {
        double max = 0;
        int best = 0;
        for (int i = 0; i < club.length; i++) {
            if (club[i].siegesQuote > max) {
                max = club[i].siegesQuote;
                best = i;
            }
        }
        return club[best];
    }

    public void kannBedienen(Karte k) {
        String meldung = "";
        for (int i = 0; i < this.kartenhand.length; i++) {
            meldung = this.kartenhand[i].bedient(k) ? this.name + " kann bedienen!"
                    : this.name + "kann nicht bedienen!";
            if (meldung.equals(this.name + " kann bedienen!")) {
                break;
            }
        }
        System.out.println(meldung);
    }

    public static void main(String... args) {
        Spieler elisabeth = new Spieler();
        Spieler klaus = new Spieler();
        Spieler helmut = new Spieler();
        Spieler erwin = new Spieler();
        elisabeth.name = "Elisabath";
        elisabeth.siegesQuote = 37.5 / 100;
        klaus.name = "Klaus";
        klaus.siegesQuote = 12.5 / 100;
        helmut.name = "helmut";
        helmut.siegesQuote = 38.75 / 100;
        erwin.name = "Erwin";
        erwin.siegesQuote = 11.25 / 100;
        Spieler best = besterSpieler(elisabeth, klaus, helmut, erwin);
        best.kartenhand = new Karte[3];
        best.kartenhand[0] = Karte.neuKarte("HERZ", "SIEBEN");
        best.kartenhand[1] = Karte.neuKarte("HERZ", "NEUN");
        best.kartenhand[2] = Karte.neuKarte("KARO", "KOENIG");
        best.kannBedienen(Karte.neuKarte("KARO", "BUBE"));
    }
}
