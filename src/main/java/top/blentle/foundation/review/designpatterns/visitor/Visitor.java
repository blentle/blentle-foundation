package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:33
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第四步：创建具体的访问者
 * @since: 1.0
 */
public class Visitor implements FruitVisitor {
    public void visit(Apple apple) {
        apple.doSomething();
    }

    public void visit(Banana banana) {
        banana.doSomething();
    }

    public void visit(Orange orange) {
        orange.doSomething();
    }

    public void visit(Pineapple pineapple) {
        pineapple.doSomething();
    }
}
