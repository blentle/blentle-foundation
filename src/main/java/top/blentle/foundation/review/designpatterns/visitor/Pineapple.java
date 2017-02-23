package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/20 14:35
 * @mail: blentle.huan.ren@gmail.com
 * @description:
 * @since: 1.0
 */
public class Pineapple extends Fruit {
    @Override
    void accept(FruitVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    void doSomething() {
        System.err.println("菠萝。。。。。。");
    }
}
