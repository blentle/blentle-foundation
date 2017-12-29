package top.blentle.foundation.review.arithmetic.tree;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/12/29 0029
 * @description :
 * @since : 1.0
 */
public class TreeNode<T> {

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


}
