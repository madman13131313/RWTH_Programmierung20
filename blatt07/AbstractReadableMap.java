import java.util.Set;
import java.util.HashSet;
public abstract class AbstractReadableMap <K,V>implements ReadableMap<K,V>{
    protected Entry<K,V>[] entries;
    
    public AbstractReadableMap(Entry<K,V>[] initial){
        this.entries=GenericArrayHelper.copyArray(initial);
    }
    
    public AbstractReadableMap(){
        this.entries=GenericArrayHelper.newEntryArrayOfSize(10);
    }
    
    public V getOrThrow(K k) throws UnknownKeyException{
        for (Entry<K,V> i:this.entries){
            if (i.getKey().equals(k) && i!=null){
                return i.getVal();
            }
        }
        throw new UnknownKeyException();
    }
    
    public ImmutableMap<K,V> asImmutableMap(){
        return new ImmutableMap<K,V>(this.entries);
    }
    
    public Set<K> keysAsSet(){
        Set<K> x=new HashSet<K>();
        for(Entry<K,V> i:this.entries){
            if (i!=null){
                x.add(i.getKey());
            }
        }
        return x;
    }
    
}
