package com.wkk.tree;

/**
 * @Time: 20-3-3上午7:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// n: 节点个数
// d: 度
// n=d+1;

public class VerifyPreorderSerializationOfABinaryTre {
    public static boolean isValidSerialization(String preOrder){
        String[] preOrderSplit = preOrder.split(",");
        int diff = 1;
        for (String s : preOrderSplit) {
            if(diff-- < 0){
                return false;
            }
            if(!"#".equals(s)){
                diff += 2;
            }
        }
        return diff == 0;

    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = isValidSerialization(s);
        System.out.println(validSerialization);
    }
}
