package tree;

public class BinarySearchTree {

    public TreeNode root;

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    public BinarySearchTree(int rootKey) {
        this(new TreeNode(null, null, null, rootKey));
    }

    private void insert(TreeNode node, int key) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new TreeNode(node, null, null, key);
            } else {
                insert(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(node, null, null, key);
            } else {
                insert(node.right, key);
            }
        }
    }

    public void insert(int key) {
        if (root == null)
            root = new TreeNode(null, null, null, key);

        insert(root, key);
    }

    public TreeNode search(TreeNode node, int key) {
        if (node == null)
            return null;

        if (node.key == key) {
            return node;
        }
        else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public TreeNode search(int key) {
        if (root == null)
            return null;

        return search(root, key);
    }

    public void delete(int key) {
        TreeNode node = search(key);
        if (node == null)
            return;


        if (node.left == null) {
            // No left child
            if (node.right == null) {
                if (node == root)
                    root = null;

                // No child
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }

            // Has right child
            if (node == root) {
                root = node.right;
                root.parent = null;
            }

            if (node.parent.left == node) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else {
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }

        } else {
            // Has left child
            if (node.right == null) {
                // Has only left child

                if (node == root) {
                    root = node.left;
                    root.parent = null;
                }
                if (node.parent.left == node) {
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                } else {
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            }

            // Has left and right child
            TreeNode swapNode = node.left;
            while (swapNode.right != null) {
                swapNode = swapNode.right;
            }

            node.key = swapNode.key;

            if (swapNode.left == null) {
                if (swapNode.parent.left == swapNode) {
                    swapNode.parent.left = null;
                } else {
                    swapNode.parent.right = null;
                }
            } else {
                if (swapNode.parent.left == swapNode) {
                    swapNode.parent.left = swapNode.left;
                    swapNode.left.parent = swapNode.parent;
                } else {
                    swapNode.left.parent = swapNode.parent;
                    swapNode.parent.right = swapNode.left;
                }
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTree T = new BinarySearchTree(5);
        T.insert(4);
        T.insert(7);
        T.insert(9);
        T.insert(6);

        T.delete(7);
    }
}
