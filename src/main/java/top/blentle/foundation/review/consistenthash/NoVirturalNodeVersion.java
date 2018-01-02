package top.blentle.foundation.review.consistenthash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/2 0002
 * @description :
 * @since : 1.0
 */
public class NoVirturalNodeVersion {

    private static final String[] serverList = {"192.168.10.110:1000", "192.168.10.111:1000", "192.168.10.112:1000", "192.168.10.113:1000"};


    /**
     * key 是hash值，value是服务器ip和端口
     */
    private static SortedMap<Integer, String> serverMap = new TreeMap<Integer, String>();


    /**
     * 初始化
     */
    static {
        for (String server : serverList) {
            int hash = getHash(server);
            System.out.println("[" + server + "]加入集合中, 其Hash值为" + hash);
            serverMap.put(hash, server);
        }
    }

    public String getServer(String fieldValue) {
        int hash = getHash(fieldValue);
        Integer key = serverMap.tailMap(hash).firstKey();
        String target = serverMap.get(key);
        return target;
    }

    private static int getHash(String server) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < server.length(); i++)
            hash = (hash ^ server.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        NoVirturalNodeVersion version = new NoVirturalNodeVersion();
        String server1 = version.getServer("123456");
        String server2 = version.getServer("12345678");
        System.err.println("选取的节点是:" + server1);
        System.err.println("选取的节点是:" + server2);
    }

}
