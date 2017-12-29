package top.blentle.foundation.review.arithmetic.tree;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/29 0029
 * @description : 二叉树的一个树节点
 * @since : 1.0
 */
public class TreeNode<T extends Comparable<? super T>> {

    /**
     * 节点上的数据
     */
    private T data;

    /**
     * 右子节点
     */
    private TreeNode<T> left;

    /**
     * 左子节点
     */
    private TreeNode<T> right;

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * @param t    插入的数据
     * @param root 原树的根节点
     * @return 插入后的根节点
     */
    public TreeNode<T> insert(T t, TreeNode<T> root) {
        //返回新的二叉树的跟节点
        if (root == null) {
            return new TreeNode<T>(t, null, null);
        }
        int result = t.compareTo(root.data);
        if(result  < 0)
            root.left = insert(t,root.left);
        else if(result > 0)
            root.right = insert(t,root.right);
        return root;

    }


}
