package top.blentle.foundation.review.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/3/17 9:03
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public abstract class Data {

    private static final List<Integer> data = new ArrayList<Integer>();


    static {
        data.addAll(Arrays.asList(12,45,458,90,87,5789,23,45,789,13,897,33456,405,768,907,876,100,78,333,597,980));
    }

    protected static List<Integer> getData() {
        return data;
    }
}
