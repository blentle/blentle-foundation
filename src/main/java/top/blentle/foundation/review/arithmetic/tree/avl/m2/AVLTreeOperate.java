package top.blentle.foundation.review.arithmetic.tree.avl.m2;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/16 0016
 * @description : 对AVL树的操作
 * @since : 1.0
 */
public class AVLTreeOperate {

    /**
     * 树的根节点
     */
    private AVLTreeNode root;

    public AVLTreeNode add(int val) {
        return insert(root, val);
    }

    public AVLTreeNode insert(AVLTreeNode node, int val) {
        if (node == null)
            root = new AVLTreeNode(val, null);
        int value = root.getVal();
        if (val == value) {
            //do nothing
        } else if (val < value) {
            //查找左节点继续插入
            AVLTreeNode newNode = insert(root.getLeft(), val);
            newNode.setParent(root);
            root.setLeft(newNode);
            if (height(root.getLeft()) - height(root.getRight()) == 2) {
                if (val < root.getLeft().getVal()) {
                    //旋转一次:
                    root = rotateRight(root);
                } else {
                    //旋转两次
                    root = rotateLeftThenRight(root);
                }
            }
        } else {
            //查找右节点继续插入
            AVLTreeNode newNode = insert(root.getRight(), val);
            newNode.setParent(root);
            root.setRight(newNode);
            if (height(root.getLeft()) - height(root.getRight()) == -2) {
                if (val > root.getLeft().getVal()) {
                    //旋转一次:
                    root = rotateLeft(root);
                } else {
                    //旋转两次
                    root = rotateRightThenLeft(root);
                }
            }
        }
        return root;
    }

    /**
     * 先左旋根节点的左子节点，再右旋根节点
     *
     * @param tree
     * @return
     */
    private AVLTreeNode rotateLeftThenRight(AVLTreeNode tree) {
        AVLTreeNode left = tree.getLeft();
        rotateLeft(left);
        return rotateRight(tree);
    }

    /**
     * 先左旋根节点的左子节点，再右旋根节点
     *
     * @param tree
     * @return
     */
    private AVLTreeNode rotateRightThenLeft(AVLTreeNode tree) {
        AVLTreeNode right = tree.getRight();
        rotateRight(right);
        return rotateLeft(tree);
    }

    /**
     * 左旋
     *
     * @param tree
     * @return
     */
    private AVLTreeNode rotateLeft(AVLTreeNode tree) {
        AVLTreeNode right = tree.getRight();
        tree.setRight(right.getRight());
        right.setParent(tree.getParent());
        tree.setParent(right);
        setBalance(tree, tree.getRight());
        return right;
    }

    /**
     * 右旋
     *
     * @param tree
     * @return
     */
    private AVLTreeNode rotateRight(AVLTreeNode tree) {
        AVLTreeNode left = tree.getLeft();
        tree.setLeft(left.getRight());
        left.setParent(tree.getParent());
        tree.setParent(left);
        setBalance(tree, tree.getLeft());
        return left;
    }


    public static void main(String[] args) {
        AVLTreeOperate operation = new AVLTreeOperate();
        int[] a = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        AVLTreeNode node = null;
        for (int b : a) {
            node = operation.insert(node, b);
        }
        AVLTreeNode root = operation.getRoot();
        //遍历node
        inOrder(root);
    }

    public AVLTreeNode getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode root) {
        this.root = root;
    }

    private static void inOrder(AVLTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.err.println(node.getVal());
            inOrder(node.getRight());
        }
    }

    /**
     * 计算节点的高度
     *
     * @param node
     * @return
     */
    private int height(AVLTreeNode node) {
        return node == null ? -1 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /**
     * 调整树的平衡因子
     *
     * @param nodes
     * @return
     */
    private boolean setBalance(AVLTreeNode... nodes) {
        for (AVLTreeNode node : nodes) {
            node.setFactor(height(node.getLeft()) - height(node.getLeft()));
        }
        return true;
    }


}
