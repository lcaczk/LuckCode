package com.wkk.everyday.july;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 2020/7/11上午8:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CountOfSmallerNumbersAfterSelf {
    // 超出时间限制
    // O(n^2)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return list;
        }
        for(int i = 0; i<nums.length-1; i++){
            int cur = nums[i];
            int count = 0;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < cur){
                    count++;
                }
            }
            list.add(count);
        }
        list.add(0);
        return list;
    }

    // 超出时间限制
    public static List<Integer> countSmallerII(int[] nums){
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        for(int i = 0; i<nums.length-1; i++){
            int cur = nums[i];
            int count = 0;
            int low = i+1;
            int high = nums.length-1;
            while(low <= high){
                if(nums[low] < cur){
                    count++;
                    low++;
                }
                else if(nums[high] < cur){
                    count++;
                    high--;
                }else {
                    low++;
                    high--;
                }
            }
            list.add(count);
        }
        list.add(0);
        return list;
    }
    // 构造二叉搜索树
    public static List<Integer> countSmallerIII(int[] nums) {
        //初始化
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        List<Integer> list = new ArrayList<>();
        //反向构造二叉树，统计右边的较小数
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--){
            root = addAndCount(root, new TreeNode(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }

    public static TreeNode addAndCount(TreeNode root, TreeNode node, Integer[] res, int i){
        if(root == null){
            root = node;
            return root;
        }
        //根节点的左边保存不大于根节点的元素
        if(root.val >= node.val){
            //统计左节点的元素个数
            root.count++;
            root.left = addAndCount(root.left, node, res, i);
        }else{
            //走到右边获取该元素左边的个数（根节点 1 + 左节点 root.count）
            res[i] += 1 + root.count;
            //统计右边是否还有更小的元素
            root.right = addAndCount(root.right, node, res, i);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        List<Integer> list = countSmallerIII(nums);
        System.out.println(list);
    }
}
