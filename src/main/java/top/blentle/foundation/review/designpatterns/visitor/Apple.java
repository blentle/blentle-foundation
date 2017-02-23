package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:24
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第二步：创建苹果作为另一个被访问的元素类
 * @since: 1.0
 */
public class Apple extends Fruit {
    @Override
    void accept(FruitVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    void doSomething() {
        System.err.println("这是苹果");
    }
}
