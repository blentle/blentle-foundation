package top.blentle.foundation.review.arithmetic.tree.avl.m2;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/16 0016
 * @description : AVL树节点（第二种方法实现）
 * @since : 1.0
 */
public class AVLTreeNode {

    /**
     * 平衡因子：正常的平衡因子只有0,-1, 1
     * 大于
     */
    private int factor;

    /**
     * 节点值
     */
    private int val;

    /**
     * 左子节点
     */
    private AVLTreeNode left;

    /**
     * 右子节点
     */
    private AVLTreeNode right;

    /**
     * 当前节点的父节点
     */
    private AVLTreeNode parent;

    /**
     * 初始化一个节点
     *
     * @param val    节点值
     * @param parent 父节点
     */
    public AVLTreeNode(int val, AVLTreeNode parent) {
        this.val = val;
        this.parent = parent;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public AVLTreeNode getParent() {
        return parent;
    }

    public void setParent(AVLTreeNode parent) {
        this.parent = parent;
    }
}
