import java.util.Set;
import java.util.HashSet;
public class Launcher{
    public static void putEntries(WritableMap<String,Integer> map){
        map.put("sizeInMB",42);
        map.put("version",4);
        map.put("yearOfRelease",2015);
    }
    
    public static void printEntries(ReadableMap<String,Integer> map){
        Set<String> s=map.keysAsSet();
        for(String i:s){
            try{
                System.out.println(i+": "+map.getOrThrow(i).toString());
            }
            catch(UnknownKeyException e){
                System.out.println("Error.");
            }
        }
    }
    
    public static void main (String[] args){
        MutableMap<String,Integer> map = new MutableMap<String,Integer>();
        putEntries(map);
        printEntries(map);
        ImmutableMap<String,Integer> immMap = map.asImmutableMap();
        Launcher.printEntries(immMap);
    }
}
