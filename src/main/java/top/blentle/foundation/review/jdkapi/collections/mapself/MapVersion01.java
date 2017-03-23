package top.blentle.foundation.review.jdkapi.collections.mapself;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/23 13:52
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class MapVersion01<K,V> {
    //存储每一个键值对的数组
    private Object[][] pairs;
    //最后一个元素的序号
    private int index;

    public MapVersion01(int capacity) {
        this.pairs = new Object[capacity][2];
    }

    /**
     * 插入的方法
     * @param key
     * @param value
     */
    public void  put(K key, V value) {
        if(index >= pairs.length)
            throw new IndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    /**
     * 查找方法
     * @param key
     * @return
     */
    public V get(K key) {
        for(int i = 0 ; i < index ; i++) {
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < index ; i ++) {
            sb.append(pairs[i][0]).toString();
            sb.append(" : ");
            sb.append(pairs[i][1].toString());
            if(i < index - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MapVersion01<Integer,String> map = new MapVersion01<Integer,String>(10);
        map.put(1,"111");
        map.put(2,"222");
        map.put(3,"333");
        map.put(4,"444");
        map.put(5,"555");
        map.put(6,"666");
        System.err.println(map);
    }
}
