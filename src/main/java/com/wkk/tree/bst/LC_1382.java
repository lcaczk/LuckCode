package com.wkk.tree.bst;

import com.common.structure.ListNode;
import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * 1382 将二叉搜索树变平衡
 * 思路：
 * 1. 运用了二叉树的两个通用方法：遍历 + 构造二叉树
 * 2. 通用方式，构建AVL树
 *
 * @author weikunkun
 * @since 2021/3/11
 */
public class LC_1382 {
    private List<Integer> res;

    /**
     * 利用二叉搜索树的性质
     * 中序遍历 + 构造二叉树
     *
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        // 思路
        // 先遍历得到一个数组，之后，重新构造二叉树
        res = new ArrayList<>();
        inOrder(root);
        return buildTree(res, 0, res.size() - 1);
    }

    private void inOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    private TreeNode buildTree(List<Integer> arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(arr, left, mid - 1);
        root.right = buildTree(arr, mid + 1, right);
        return root;
    }

    /**
     * 通用方式
     * 1. 构建一个AVL树
     *
     * @param root
     * @return
     */
    public TreeNode balanceBSTII(TreeNode root) {
        if (root == null) {
            return null;
        }
        // node节点的高度缓存
        Map<TreeNode, Integer> nodeHeight = new HashMap<>();
        TreeNode newRoot = null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 先序遍历插入（其实用哪个遍历都行）
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 新树插入
                newRoot = insert(newRoot, node.val, nodeHeight);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return newRoot;
    }

    /**
     * 新节点插入
     *
     * @param root       root
     * @param val        新加入的值
     * @param nodeHeight 节点高度缓存
     * @return 新的root节点
     */
    private TreeNode insert(TreeNode root, int val, Map<TreeNode, Integer> nodeHeight) {
        if (root == null) {
            root = new TreeNode(val);
            nodeHeight.put(root, 1);// 新节点的高度
            return root;
        }
        TreeNode node = root;
        int cmp = val - node.val;
        if (cmp < 0) {
            // 左子树插入
            node.left = insert(root.left, val, nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.left, 0) - nodeHeight.getOrDefault(node.right, 0) > 1) {
                if (val > node.left.val) {
                    // 插入在左孩子右边，左孩子先左旋
                    node.left = rotateLeft(node.left, nodeHeight);
                }
                // 节点右旋
                node = rotateRight(node, nodeHeight);
            }
        } else if (cmp > 0) {
            // 右子树插入
            node.right = insert(root.right, val, nodeHeight);
            // 如果左右子树高度差超过1，进行旋转调整
            if (nodeHeight.getOrDefault(node.right, 0) - nodeHeight.getOrDefault(node.left, 0) > 1) {
                if (val < node.right.val) {
                    // 插入在右孩子左边，右孩子先右旋
                    node.right = rotateRight(node.right, nodeHeight);
                }
                // 节点左旋
                node = rotateLeft(node, nodeHeight);
            }
        } else {
            // 一样的节点，啥都没发生
            return node;
        }
        // 获取当前节点新高度
        int height = getCurNodeNewHeight(node, nodeHeight);
        // 更新当前节点高度
        nodeHeight.put(node, height);
        return node;
    }

    /**
     * node节点左旋
     *
     * @param node       node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateLeft(TreeNode node, Map<TreeNode, Integer> nodeHeight) {
        // ---指针调整
        TreeNode right = node.right;
        node.right = right.left;
        right.left = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node, nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node, newNodeHeight);
        // newNodeHeight是现在right节点左子树高度，原理一样，取现在right左右子树最大高度+1
        int newRightHeight = Math.max(newNodeHeight, nodeHeight.getOrDefault(right.right, 0)) + 1;
        // 更新原right节点高度
        nodeHeight.put(right, newRightHeight);
        return right;
    }

    /**
     * node节点右旋
     *
     * @param node       node
     * @param nodeHeight node高度缓存
     * @return 旋转后的当前节点
     */
    private TreeNode rotateRight(TreeNode node, Map<TreeNode, Integer> nodeHeight) {
        // ---指针调整
        TreeNode left = node.left;
        node.left = left.right;
        left.right = node;
        // ---高度更新
        // 先更新node节点的高度，这个时候node是right节点的左孩子
        int newNodeHeight = getCurNodeNewHeight(node, nodeHeight);
        // 更新node节点高度
        nodeHeight.put(node, newNodeHeight);
        // newNodeHeight是现在left节点右子树高度，原理一样，取现在right左右子树最大高度+1
        int newLeftHeight = Math.max(newNodeHeight, nodeHeight.getOrDefault(left.left, 0)) + 1;
        // 更新原left节点高度
        nodeHeight.put(left, newLeftHeight);
        return left;
    }

    /**
     * 获取当前节点的新高度
     *
     * @param node       node
     * @param nodeHeight node高度缓存
     * @return 当前node的新高度
     */
    private int getCurNodeNewHeight(TreeNode node, Map<TreeNode, Integer> nodeHeight) {
        // node节点的高度，为现在node左右子树最大高度+1
        return Math.max(nodeHeight.getOrDefault(node.left, 0), nodeHeight.getOrDefault(node.right, 0)) + 1;
    }

    private static void order(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        order(node1);
        System.out.println(node1.val);
        Queue<String> cities = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
    }

}
