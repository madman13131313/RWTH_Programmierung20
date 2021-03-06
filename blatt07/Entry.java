public class Entry<K,V>{
    private K key;
    private V val;
    
    public Entry(K k,V v){
        this.key=k;
        this.val=v;
    }
    
    public K getKey(){
        return this.key;
    }
    
    public V getVal(){
        return this.val;
    }
   
}
