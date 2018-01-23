package top.blentle.foundation.review.arithmetic.tree.rb;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/23 0023
 * @description : 红黑树的实现
 * @since : 1.0
 */
public class RBTree {

    /**
     * 红黑树的根节点
     */
    private TreeNode root;

    /**
     * 树节点对象
     */
    static class TreeNode {
        /**
         * 节点的值
         */
        private int val;

        /**
         * 左子节点
         */
        private TreeNode left;

        /**
         * 右子节点
         */
        private TreeNode right;

        /**
         * 父亲节点
         */
        private TreeNode parent;

        /**
         * 是否红色节点
         */
        private boolean red;

        /**
         * 默认插入的节点是红色的
         * @param val
         */
        public TreeNode(int val) {
            this.val = val;
            this.red = true;
        }

    }

    /**
     * 左旋
     * 基本的左旋，左旋与avl树一样
     * @param node
     */
    private void rotateLeft(TreeNode node) {
        TreeNode right = node.right;
        node.right = right.left;
        if(right.left !=  null)
            right.left.parent = node;
        right.parent = node.parent;
        if(node.parent == null) {
            root = node;
        } else if(node.parent.left == node) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
        }
        right.left = node;
        node.parent = right;
    }

    /**
     * 右旋
     * 基本的右旋， 右旋与avl树一样
     * @param node
     */
    private void rotateRight(TreeNode node) {
        TreeNode left = node.left;
        node.left = left.right;
        
    }

}
