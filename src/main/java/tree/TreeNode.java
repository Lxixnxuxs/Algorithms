package tree;

public class TreeNode {

    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public int key;

    public TreeNode(TreeNode parent, TreeNode left, TreeNode right, int key) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
