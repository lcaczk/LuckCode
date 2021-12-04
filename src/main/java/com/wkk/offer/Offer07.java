package com.wkk.offer;

import com.common.structure.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author weikunkun
 * @since 2021/6/7
 */
public class Offer07 {
    private int[] preorder;
    private int[] inorder;
    private int starter;
    private Map<Integer, Integer> map; // key: num, value : idx

    /**
     * Java8
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        starter = 0;
        List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        map = IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toMap(list::get, i -> i));
        return buildTree(0, inorder.length -  1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[starter++];
        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        root.left = buildTree(left, idx - 1);
        root.right = buildTree(idx + 1, right);
        return root;
    }
}
