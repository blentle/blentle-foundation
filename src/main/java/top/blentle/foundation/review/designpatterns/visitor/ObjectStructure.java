package top.blentle.foundation.review.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:36
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第五步:创建对象结构类
 * @since: 1.0
 */
public class ObjectStructure {
    public static List<Fruit> getFruitList() {
        List<Fruit> list = new ArrayList<Fruit>();
        Random random = new Random();
        for(int i =0 ; i < 10 ; i++) {
            int a = random.nextInt(100);
            if(a < 30) {
                list.add(new Apple());
            }
            if(a >= 30 && a < 60) {
                list.add(new Banana());
            }
            if(a >= 60 ) {
                list.add(new Orange());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Fruit> list = getFruitList();
        for(Fruit f : list) {
            f.accept(new Visitor());
        }
    }
}
