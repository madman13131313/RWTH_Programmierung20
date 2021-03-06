/**
 * 
 * Klasse BoolleanStringHelpers, welche dazu dient, Strings in boolean-Arrays umzuwandeln und umgekehrt.
 * 
 * @author LinyueXue & Yejun Tang
 * 
 */
public class BooleanStringHelpers{
    /**
     * Strings in boolean-Arrays umwandeln
     * 
     * @param s der uebergebene String
     * @param c das uebergebene Zeichen
     * @return ein boolean-Array, fuer jede Position i des Arrays gilt: 
     * Der i-te Eintrag im zurueckgegebenen Array soll genau dann true sein,
     * wenn das i-te Zeichen im uebergebenen String gleich dem uebergebenen Zeichen ist.
     */
    public static boolean[] parse(String s, char c){
        boolean[] result=new boolean[s.length()];
        for (int i =0; i<s.length();i++){
            if (s.charAt(i)==c){
                result[i]=true;
            }
            else{
                result[i]=false;
            }
        }
        return result;
    }
    
    /**
     * boolean_Arrays in Strings umwandeln
     * 
     * @param c1 das erster uebergebene Zeichen
     * @param c2 das zweiter uebergebene Zeichen
     * @param b das uebergebene boolean-Array
     * @return ein String,fuer jede Position i des uegebenen Arrays gilt: Ist der i-te Eintrag des uebergebenen Arrays true, 
     * so steht an der i-ten Stelle des zurueckgegebenen Strings das Zeichen, welches als erster char-Wert uebergeben wurde.
     * Ist der i-te Eintrag des uebergebenen Arrays false, 
     * so steht an der i-ten Stelle des zurueckgegebenen Strings das Zeichen, welches als zweiter char-Wert uebergeben wurde.
     */
    public static String stringify(char c1, char c2,boolean...b){
        StringBuilder builder = new StringBuilder("");
        for (boolean i:b){
            if (i){
                builder.append(c1);
            }
            else{
                builder.append(c2);
            }
        }
        return builder.toString();
    }
}