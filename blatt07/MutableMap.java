public class MutableMap<K,V> extends AbstractReadableMap<K,V> implements WritableMap<K,V>{
    public void put(K key,V val){
        for (int i = 0; i < entries.length; ++i)
            if (entries[i] == null || entries[i].getKey().equals(key)) {
                entries[i] = new Entry<K, V>(key, val);
                return;
            }
        this.entries=GenericArrayHelper.copyArrayWithIncreasedSize(this.entries,this.entries.length*2);
        put(key,val);
    }
}