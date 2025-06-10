// Time Complexity (TC):
// O(n) – Every node is visited once.

// Space Complexity (SC):
// O(n) – At most, the queue holds all nodes at the largest level, and the result stores all nodes.

// Approach :
// Initialize a queue and add the root node to start the BFS traversal.
// Iterate level by level, tracking the size of the current level; for each node, add its value to a list and enqueue its children.
// After each level, add the list of that level to the result.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            while(size > 0){
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                li.add(node.val);
                size--;
            }
            result.add(li);
        }
        return result;
    }
}
