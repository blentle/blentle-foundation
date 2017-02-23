package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:16
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第二步：创建香蕉作为被访问的元素类
 * @since: 1.0
 */
public class Banana extends Fruit {
    @Override
    void accept(FruitVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    void doSomething() {
        System.err.println("这是香蕉");
    }
}
