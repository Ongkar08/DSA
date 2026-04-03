class Solution {
    int count = 1; // root
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.right!=null){
            countNodes(root.right);
            count++;
        }
        if(root.left!=null){
            countNodes(root.left);
            count++;
        }
        return count;
    }
}