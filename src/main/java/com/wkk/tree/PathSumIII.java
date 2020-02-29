package com.wkk.tree;

/**
 * @Time: 20-2-29上午10:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rootCount = count(root, sum);
        int leftCount = pathSum(root.left, sum);
        int rightCount = pathSum(root.right, sum);
        return rootCount + leftCount + rightCount;
    }

    public int count(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int isMe = (root.val == sum) ? 1 : 0;
        int left = count(root.left, sum-root.val);
        int right = count(root.right, sum - root.val);
        return isMe + left + right;
    }
}
