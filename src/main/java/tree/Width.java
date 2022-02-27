package tree;


// Definition for a binary tree node.


import java.util.ArrayList;

class Width {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = null;
        node2.right = node5;

        Width width = new Width();
        System.out.println(width.widthOfBinaryTree(root));
    }

    int maxWidth = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 1, 1);
        return maxWidth;
    }

    ArrayList<Integer> firstId = new ArrayList<>();

    void traverse(TreeNode root, int id, int depth) {
        if (root == null) return;

        if (firstId.size() == depth - 1) {
            firstId.add(id);
        } else {
            maxWidth = Math.max(maxWidth, id - firstId.get(depth - 1) + 1);
        }

        traverse(root.left, id * 2, depth + 1);
        traverse(root.right, id * 2 + 1, depth + 1);
    }

}


