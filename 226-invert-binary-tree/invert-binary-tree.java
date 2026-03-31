/** Recursive Approach:**/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty...
        if(root == null){
            return root;
        }
        // Call the function recursively for the left subtree...
        invertTree(root.left);
        // Call the function recursively for the right subtree...
        invertTree(root.right);
        // Swapping process...
        TreeNode curr = root.left;
        root.left = root.right;
        root.right = curr;
        return root;        // Return the root...
    }
}

/**Iterative Approach:**/
// Runtime: 1 ms, faster than 90.96% of Java online submissions for Invert Binary Tree.
// Time Complexity : O(n)
// Space Complexity : O(n)
