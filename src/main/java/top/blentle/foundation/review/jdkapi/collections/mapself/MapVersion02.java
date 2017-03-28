package top.blentle.foundation.review.jdkapi.collections.mapself;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/24 9:48
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class MapVersion02<K, V> {
    //key的集合，和value顺序标号必须一一对应
    private List<K> keys = new ArrayList<K>();
    //value的集合，和key顺寻标号必须一一对应
    private List<V> values = new ArrayList<V>();

    public V get(K key) {
        if (keys.contains(key)) {
            int index = keys.indexOf(key);
            return values.get(index);
        }
        return null;
    }

    public V put(K key, V value) {
        V oldValue = null;
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            oldValue = get(key);
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        ListIterator<K> kItor = keys.listIterator(keys.size());
        ListIterator<V> vItor = values.listIterator(values.size());
        while(kItor.hasNext())
            set.add(new Entry<K, V>(kItor.next(),vItor.next()));
        return set;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Entry))
                return false;
            Entry<K, V> me = (Entry<K, V>)obj;
            return (me.getKey() == null ? key == null : me.getKey().equals(key)) &&
                    (me.getValue() == null ? value == null : me.getValue().equals(value));
        }
    }
}
