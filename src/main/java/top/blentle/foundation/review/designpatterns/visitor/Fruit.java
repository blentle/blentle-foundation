package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:17
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第一步，创建抽象的元素类:水果抽象类，被哪个访问者所访问
 * @since: 1.0
 */
public abstract class Fruit {
    abstract void accept(FruitVisitor visitor);
    abstract void doSomething();
}
