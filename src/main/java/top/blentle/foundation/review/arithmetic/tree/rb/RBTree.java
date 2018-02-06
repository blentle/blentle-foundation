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
     * 根据红黑树的性质，定义树节点
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
         *
         * @param val
         */
        public TreeNode(int val) {
            this.val = val;
            this.red = true;
        }

    }

    /**
     * @param value 待插入的值
     */
    public void add(int value) {
        TreeNode t = root;
        if (root == null) {
            root = new TreeNode(value);
            //根节点是黑色的
            root.red = false;
            //创建根节点后，直接返回
            return;
        }
        TreeNode parent = null;
        while (t != null) {
            //第一次parent指向root, t 也是root
            parent = t;
            if (value < t.val)
                t = t.left;
            else if (value > t.val)
                t = t.right;
            else
                t.val = value;
        }
        t = new TreeNode(value);
        //parent是上一次循环后的t
        t.parent = parent;
        if (parent != null) {
            if (t.val < parent.val)
                parent.left = t;
            else
                parent.right = t;
        }
        //添加完后 t是新的插入节点，对新插入的节点进行平衡调整
        fixAfterInsertion(t);
        //修复完后，最终的根节点的颜色是黑色
        root.red = false;
    }

    /**
     * 插入后新插入的节点进行从下向上变色，和旋转处理
     *
     * @param t
     * @solutions :
     * 1. 插在左子树上，且父节点是祖父的左子节点：
     * 父节点变黑，祖父节点变红， 右旋祖父节点
     * 2. 插在左子树上，且父节点是祖父的右子节点：
     * 右旋父节点，并把插入节点指向父节点，即原来的父节点变成了插入节点（新节点），
     * 新节点的父节点变黑 ，新节点的祖父节点变红， 左旋新节点的祖父节点 【这里参考对象变了，所以描述的比较啰嗦】
     * 3. 插在右子树上，且父节点是祖父的右子节点：
     * 父节点变黑，祖父节点变红，左旋祖父节点  (跟 2 的第二步一模一样)
     * 4. 插在右子树上，且父节点是祖父的左子节点：
     * 左旋父节点，并把插入节点指向父节点，即原来的父节点变成的插入节点（新节点）,
     * 新节点的父节点变黑 ，新节点的祖父节点变红， 右旋新节点的祖父节点 【这里参考对象变了，所以描述的比较啰嗦】
     */
    private void fixAfterInsertion(TreeNode t) {
        while (t != null && t != root && t.red && t.parent.red) {
            TreeNode parent = t.parent;
            TreeNode grand = parentOf(parent);
            TreeNode uncle = uncleOf(t);
            //叔叔是null或者是黑色, 即叔叔都是黑色
            if (uncle == null || (!uncle.red)) {
                //1.插在左子树上
                if (parent.left == t) {
                    //1.1. 父节点是祖父的左子节点:  父节点变黑，祖父节点变红， 右旋祖父节点
                    if (parent == grand.left) {
                        setColor(parent, false);
                        setColor(grand, true);
                        rotateRight(grand);
                    } else {
                        //1.2. 父节点是祖父的右子节点:
                        // 右旋父节点，并把插入节点指向父节点，即原来的父节点变成了插入节点（新节点），下面这一步就递归了。
                        // 新节点的父节点变黑 ，新节点的祖父节点变红， 左旋新节点的祖父节点
                        t = parent;
                        rotateRight(parent);
                    }
                } else {
                    //2. 插在右子树上
                    //2.1. 父节点是祖父的右子节点:  父节点变黑，祖父节点变红，左旋祖父节点
                    if (parent == grand.right) {
                        setColor(parent, false);
                        setColor(grand, true);
                        rotateLeft(grand);
                    } else {
                        //2.2. 父节点是祖父的左子节点:
                        //左旋父节点，并把插入节点指向父节点，即原来的父节点变成的插入节点（新节点）,
                        //新节点的父节点变黑 ，新节点的祖父节点变红， 右旋新节点的祖父节点
                        t = parent;
                        rotateLeft(parent);

                    }
                }
            } else {
                //叔叔是红色,直接把叔叔和父亲变成黑色，爷爷变成红色
                //父亲,叔叔变黑
                setColor(parentOf(t), false);
                setColor(uncleOf(t), false);
                //爷爷变红
                setColor(grandfatherOf(t), true);
            }
        }
    }

    /**
     * 给指定的节点上色
     *
     * @param treeNode
     * @param b        false : 黑色，true : 红色
     */
    private void setColor(TreeNode treeNode, boolean b) {
        if (treeNode != null)
            treeNode.red = b;
    }

    /**
     * 左旋
     * 基本的左旋，左旋与avl树一样
     *
     * @param node
     */
    private void rotateLeft(TreeNode node) {
        TreeNode right = node.right;
        node.right = right.left;
        if (right.left != null)
            right.left.parent = node;
        right.parent = node.parent;
        //重新给父节点的孩子赋值
        if (node.parent == null)
            root = right;
        else if (node.parent.left == node)
            node.parent.left = right;
        else
            node.parent.right = right;
        //重新给孩子的父节点赋值
        right.left = node;
        node.parent = right;
    }

    /**
     * 右旋
     * 基本的右旋， 右旋与avl树一样
     *
     * @param node
     */
    private void rotateRight(TreeNode node) {
        TreeNode left = node.left;
        node.left = left.right;
        if (left.right != null)
            left.right.parent = node;
        left.parent = node.parent;
        //重新给父节点的孩子赋值
        if (node.parent == null)
            root = left;
        else if (node.parent.left == node)
            node.parent.left = left;
        else
            node.parent.right = left;
        //重新给孩子的父节点赋值
        left.right = node;
        node.parent = left;
    }

    /**
     * 获取指定节点node 的父节点
     *
     * @param node
     * @return
     */
    private TreeNode parentOf(TreeNode node) {
        return node == null ? null : node.parent;
    }

    /**
     * 获取指定节点node的叔叔节点(父亲的兄弟)
     *
     * @param node
     * @return
     */
    private TreeNode uncleOf(TreeNode node) {
        TreeNode parent = parentOf(node);
        TreeNode left = leftOf(grandfatherOf(node));
        if (parent == left)
            return rightOf(grandfatherOf(node));
        else
            return left;
    }

    /**
     * 获取指定节点的爷爷节点
     *
     * @param node
     * @return
     */
    private TreeNode grandfatherOf(TreeNode node) {
        return parentOf(parentOf(node));
    }

    /**
     * 获取指定节点的左子节点
     *
     * @param node
     * @return
     */
    private TreeNode leftOf(TreeNode node) {
        return node == null ? null : node.left;
    }

    /**
     * 获取指定节点node的右子节点
     *
     * @param node
     * @return
     */
    private TreeNode rightOf(TreeNode node) {
        return node == null ? null : node.right;
    }


    /**
     * 断点测试一下
     * @param args
     */
    public static void main(String[] args) {
        RBTree obj = new RBTree();
        obj.add(4);
        obj.add(2);
        obj.add(1);
        obj.add(5);
        obj.add(6);
        obj.add(10);
        obj.add(8);
        System.err.println(obj.root);
    }
    //嗯，画出图来，好使
}
