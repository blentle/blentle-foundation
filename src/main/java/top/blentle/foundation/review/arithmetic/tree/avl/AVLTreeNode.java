package top.blentle.foundation.review.arithmetic.tree.avl;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/16 0016
 * @description : AVL树节点
 * @since : 1.0
 */
public class AVLTreeNode {

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
     * 平衡因子
     */
    private int balanceFactor;

    public AVLTreeNode(int val, AVLTreeNode left, AVLTreeNode right, int balanceFactor) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.balanceFactor = balanceFactor;
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

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }
}
