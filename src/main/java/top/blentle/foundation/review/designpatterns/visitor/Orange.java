package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:26
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第二步：创建橘子作为另一个被访问的元素类
 * @since: 1.0
 */
public class Orange extends Fruit {
    @Override
    void accept(FruitVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    void doSomething() {
        System.err.println("这是橘子.....");
    }
}
