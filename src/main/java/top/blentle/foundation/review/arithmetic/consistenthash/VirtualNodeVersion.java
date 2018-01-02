package top.blentle.foundation.review.arithmetic.consistenthash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/2 0002
 * @description : 带虚拟节点的一致性hash算法
 * @since : 1.0
 */
public class VirtualNodeVersion {

    private static final String[] realServerList = {"192.168.10.110:5000", "192.168.10.111:5000", "192.168.10.112:5000", "192.168.10.113:5000", "192.168.10.114:5000", "192.168.10.115:5000"};

    private static final SortedMap<Integer, String> virtualServerMap = new TreeMap<Integer, String>();

    private static int virtualNodeCount = 10;

    static {
        for (String real : realServerList) {
            for (int i = 0; i < virtualNodeCount; i++) {
                String virtualServer = real + "#Node" + (i + 1);
                virtualServerMap.put(getHash(virtualServer), virtualServer);
            }
        }
    }

    public String getServer(String fieldValue) {
        int hash = getHash(fieldValue);
        Integer key = virtualServerMap.tailMap(hash).firstKey();
        String virtual = virtualServerMap.get(key);
        System.err.println("virtual:" + virtual);
        String target = virtual.substring(0, virtual.indexOf("#"));
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
        VirtualNodeVersion version = new VirtualNodeVersion();
        String server1 = version.getServer("123456");
        String server2 = version.getServer("12345678");
        System.err.println("选取的节点是:" + server1);
        System.err.println("选取的节点是:" + server2);
    }
}
