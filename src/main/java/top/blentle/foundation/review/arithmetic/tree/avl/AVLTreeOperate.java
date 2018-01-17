package top.blentle.foundation.review.arithmetic.tree.avl;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/16 0016
 * @description : 对AVL树的操作
 * @since : 1.0
 */
public class AVLTreeOperate {
    /**
     * 左树比右树高1
     */
    private static final int LH = 1;

    /**
     * 左树与右树同高
     */
    private static final int EH = 0;

    /**
     * 右树比左树高1
     */
    private static final int RH = -1;

    /**
     * @param t   以t为根节点的树
     * @param val 要插入的值
     * @return 新的根节点
     */
    public AVLTreeNode add(AVLTreeNode t, int val) {
        boolean taller = false;
        if (t == null) {
            //原来的树是空树，插入新节点，返回新节点
            t = new AVLTreeNode(val, null, null, EH);
            //原来没有节点，现在有了一个新节点，树当然算是长高了。
            taller = true;
            return t;
        }
        insert(t, val, taller);
        return t;
    }

    /**
     * @param t      原来的平衡二叉树
     * @param val    插入的值
     * @param taller 树是否长高了
     * @return boolean ,树是否长高了
     */
    private boolean insert(AVLTreeNode t, int val, boolean taller) {
        if (t == null) {
            //原来的树是空树，插入新节点，返回新节点
            t = new AVLTreeNode(val, null, null, EH);
            //原来没有节点，现在有了一个新节点，树当然算是长高了。
            taller = true;
            return true;
        }

        //1.插入值与根节点值相等
        if (val == t.getVal())
            //插入的值和根节点值相等，do nothing
            return false;

        //2.插入值比根节点值小
        if (val < t.getVal()) {
            //从左子树开始
            if (!insert(t.getLeft(), val, taller))
                return false;
            //长高了
            switch (t.getBalanceFactor()) {
                case LH:
                    leftBalance(t);
                    taller = false;
                    break;
                case EH:
                    t.setLeft(new AVLTreeNode(val, null, null, LH));
                    taller = true;
                    break;
                case RH:
                    t.setBalanceFactor(EH);
                    taller = false;
                    break;
            }
        }

        //3.插入值比根节点大
        if (val > t.getVal()) {
            //从右子树开始
            if (!insert(t.getRight(), val, taller))
                return false;
            //长高了
            switch (t.getBalanceFactor()) {
                case RH:
                    rightBalance(t);
                    taller = false;
                    break;
                case EH:
                    t.setRight(new AVLTreeNode(val, null, null, RH));
                    taller = true;
                    break;
                case LH:
                    t.setBalanceFactor(EH);
                    taller = false;
                    break;
            }
        }
        return true;
    }

    /**
     * 都没有处理父节点
     * 右旋
     *
     * @param tree 待旋转的节点
     */
    private void rightRotate(AVLTreeNode tree) {
        //拷贝源节点的左节点
        AVLTreeNode node = tree.getLeft();
        tree.setLeft(node.getRight());
        node.setRight(tree);
        tree = node;
    }

    /**
     * 都没有处理父节点
     * 左旋
     *
     * @param tree 待旋转的节点
     */
    private void leftRotate(AVLTreeNode tree) {
        AVLTreeNode node = tree.getRight();
        tree.setRight(node.getLeft());
        node.setLeft(tree);
        tree = node;
    }

    /**
     * 完成左平衡:(以tree为根节点的树左重右轻)
     * 旋转操作后tree指向新的节点
     */
    private void leftBalance(AVLTreeNode tree) {
        AVLTreeNode left = tree.getLeft();
        //左子树的平衡因子:
        switch (left.getBalanceFactor()) {
            case LH:
                //旋转后原树的平衡因子
                tree.setBalanceFactor(EH);
                left.setBalanceFactor(EH);
                //右旋
                rightRotate(tree);
                break;
            case RH:
                //新增节点在t的左子树的右子树上
                AVLTreeNode s = left.getRight();
                //调整平衡因子
                switch (s.getBalanceFactor()) {
                    case LH:
                        tree.setBalanceFactor(RH);
                        left.setBalanceFactor(EH);
                        break;
                    case EH:
                        tree.setBalanceFactor(EH);
                        left.setBalanceFactor(RH);
                        break;
                    case RH:
                        tree.setBalanceFactor(EH);
                        left.setBalanceFactor(LH);
                        break;
                }
                //最终根节点的左右平衡
                s.setBalanceFactor(EH);
                //左旋:
                leftRotate(left);
                //根节点右旋
                rightRotate(tree);
                break;
        }
    }

    /**
     * 完成右平衡:(以tree为根节点的树左轻右重)
     * 旋转操作后tree指向新的节点
     */
    private void rightBalance(AVLTreeNode tree) {
        AVLTreeNode right = tree.getRight();
        switch (right.getBalanceFactor()) {
            case RH:
                //右右类型:
                tree.setBalanceFactor(EH);
                right.setBalanceFactor(EH);
                leftRotate(tree);
                break;
            case LH:
                AVLTreeNode s = right.getLeft();
                switch (s.getBalanceFactor()) {
                    case LH:
                        tree.setBalanceFactor(EH);
                        right.setBalanceFactor(RH);
                    case EH:
                        tree.setBalanceFactor(EH);
                        right.setBalanceFactor(EH);
                        break;
                    case RH:
                        tree.setBalanceFactor(LH);
                        right.setBalanceFactor(EH);
                        break;
                }
                rightRotate(right);
                leftRotate(tree);
                s.setBalanceFactor(EH);
                break;
        }
    }

    private static void inOrder(AVLTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.err.println(node.getVal());
            inOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        AVLTreeOperate operation = new AVLTreeOperate();
        AVLTreeNode node = null;
        int[] a = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        for (int b : a) {
            node = operation.add(node, b);
        }
        //遍历node
        inOrder(node);
    }

}
