package com.wkk.binarysearch;

/**
 * @Time: 20-4-2上午8:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right-left)/2 ;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        //TODO
        return true;
    }
}
