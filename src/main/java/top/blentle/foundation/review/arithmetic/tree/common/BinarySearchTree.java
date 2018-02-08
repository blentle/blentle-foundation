package top.blentle.foundation.review.arithmetic.tree.common;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/29 0029
 * @description : 二叉树的一个树节点
 * @since : 1.0
 */
public class BinarySearchTree {

    /**
     * 树的根节点
     */
    private TreeNode root;

    static class TreeNode {

        /**
         * 数据节点的值
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

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 插入指定的节点到树中
     * @param value  插入的节点的值
     * @return 插入成功，返回true,插入失败，返回false
     */
    public boolean add(int value) {
        TreeNode t = root;
        if(root == null) {
            root = new TreeNode(value);
            return true;
        }
        TreeNode parent = null;
        while(t != null) {
            parent = t;
            if(value < t.val)
                t = t.left;
            else if(value > t.val)
                t = t.right;
            else {
                t.val = value;
                return false;
            }
        }
        t = new TreeNode(value);
        if(value < parent.val)
            parent.left = t;
        else
            parent.right = t;
        return false;
    }

    /**
     * 删除指定的节点
     * @param value  删除的节点的值
     * @return 删除成功，返回true,删除失败，返回false
     */
    public boolean remove(int value) {
        //删除一个节点，首先要找到这个节点:我们先实现一个节点的查找
        TreeNode node = find(value);
        if(node == null)
            return false;
        //todo
        return false;
    }

    public TreeNode find(int value) {
        //从根节点开始遍历
        TreeNode node = root;
        while(node != null) {
            if(value == node.val)
                return node;
            else if(value < node.val)
                node = node.left;
            else
                node = node.right;
        }
        return null;
    }

}
