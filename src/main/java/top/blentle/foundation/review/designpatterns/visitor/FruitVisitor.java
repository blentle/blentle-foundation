package top.blentle.foundation.review.designpatterns.visitor;

/**
 * @author: blentle
 * @group: rd
 * @createdate: 2017/2/17 10:12
 * @mail: blentle.huan.ren@gmail.com
 * @description: 第三步：创建抽象的访问者
 * @since: 1.0
 */
public interface FruitVisitor {
    //访问苹果
    void visit(Apple apple);
    //访问香蕉
    void visit(Banana banana);
    //访问橘子
    void visit(Orange orange);
    //访问菠萝
    void visit(Pineapple pineapple);
}
