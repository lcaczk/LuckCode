package com.wkk.array;

/**
 * @Time: 20-2-23下午4:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for(int j = i+1; j<height.length; j++){
                int temp;
                if(height[i] <= height[j]){
                    temp = height[i];
                }else {
                    temp = height[j];
                }
                int curr = temp * (j-i);
                if(max < curr){
                    max = curr;
                }
            }
        }
        return max;
    }

    public static int maxAreaII(int[] height){
        int l = 0;
        int h = height.length-1;
        int max = 0;
        while (l<=h){
            int area = Math.min(height[l], height[h]) * (h-l);
            if(area > max){
                max = area;
            }
            if(height[l]<= height[h]){
                l++;
            }else {
                h--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(arr.length);
        int i = ContainerWithMostWater.maxAreaII(arr);
        System.out.println(i);
    }
}
