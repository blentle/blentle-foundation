package top.blentle.foundation.review.designpatterns.strategy;

import java.util.Collection;
import java.util.Map;

/**
 * 集合工具类
 * @author  blentle
 * @desc 简化集合非空判断
 */
public class CollectionUtils {

	public static <T> boolean isEmpty(Collection<T> c) {
		return c == null || c.isEmpty();
	}

	public static <K, V> boolean isEmpty(Map<K, V> m) {
		return m == null || m.isEmpty();
	}

	public static String join(Collection<String> c, String split) {
		StringBuffer strBuf = new StringBuffer();
		if (c != null) {
			int i = 1;
			int size = c.size();
			for (String s : c) {
				strBuf.append(s);
				if (i < size)
					strBuf.append(split);
				i++;
			}
		}
		return strBuf.toString();
	}
}
