## LeetCode 归纳性刷题

### LinkedList
1. 206 reverse linked list
   1. 头插法
2. 24 Swap nodes in pairs
   1. 设置哨兵， 用于指向两两交换节点的前一个节点
3. 141 Linked list cycle 
   1. 使用set进行统计
   2. 快慢指针法
      1. 当快指针已经指完了， 还没有遇到慢指针，则该链表无环
      2. 快慢指针相遇， 则该链表有环
4. 142  Linked list cycle II 
   1. 同样使用set
   2. 使用快慢指针， 当快慢指针相遇之后， 再设置一个slowII指针
5. 25 Reverse nodes in k group
   1. 设置三个指针， 一个指向当前节点的头结点， 一个指向当前节点， 一个指向下一个节点

### Array

1. container with most water 
   1. 暴力破解法
   2. 双指针法
2. move zeroes
   1. 一次循环， 设置一个专门记录为0元素的索引变量
3. climbing stairs
   1. 递归
4. 3sum
   1. 双指针
   2. 暴力破解

### 哈希

1. 242 Valid Anagram



### 二叉树

1. 94 binary tree inorder traversal
2. 144 binary tree preorder traversal 
3. n ary tree postoder traversal 
4. n ary tree preorder traversal
5. n ary tree level order traversal
6. 226 Invert binary tree 
7. 173 Binary Search Treee Iterator
8. 110 Balanced Binary Tree 
9. 108 Convert Sorted Array To Binary Seach Tree(AVL)
10. 109 Convert Sorted List to Binary Search Tree(AVL)
11. 112 Path Sum
12. 437 Path Sum III



#### 总结

主要为二叉树的几种遍历， 熟悉每种遍历的写法即可

1. 前序遍历

   ```java
   public void preOrder(TreeNode root){
       if(root != null){
           //
           root操作;
           preOrder(root.left);
           preOrder(root.right);
       }
   }
   ```

2. 中序遍历

   ```java
   public void inOrder(TreeNode root){
       if(root != null){
           inOrder(root.left);
           root操作;
           inOrder(root.right);
       }
   }
   ```

3. 后序遍历

   ```java
   public void postOrder(TreeNode root){
       if(root != null){
           postOrder(root.left);
           postOrder(root.right);
           root操作;
       }
   }
   ```

   

4. 层次遍历

   ```java
   public void levelOrder(TreeNode root){
       Queue queue = new LinkedList();
       queue.offer(root);
       while(!p.isEmpty()){
           p = queue.poll();
           if(p.left != null){
               queue.offer(p.left);
           }else if(p.right != null){
               queue.offer(p.right);
           }
       }
   }
   ```

   

### 递归

某个函数直接或者间接的调用自己，这样将原问题的求解转换为许多性质相同但是规模更小的子问题

1. 如何给一堆数字排序? 答:分成两半,先排左半边再排右半边,最后
   合并就行了,至于怎么排左边和右边,请重新阅读这句话。
2. 孙悟空身上有多少根毛? 答:一根毛加剩下的毛。
3. 你今年几岁? 答:去年的岁数加一岁,1999 年我出生。

**特征：**

1. 结束条件

   最简单的子问题的解答

2. 自我调用

   解决子问题

如上述的第三问的递归求解方式：

```java
public int getAge(int year){
    if(year == 1999){
        return 0;
    }
    return getAge(year-1) + 1;
}
```

#### 要点

1. 不要人肉进行递归
2. 找到最近最简单的方法，将其拆解成可重复的子问题
3. 数学归纳法思维

#### 模板

```java
public xxx recursion(int level, int param){
    // 终止条件
    if(level > MAX_LEVEL){
        process_result;
        return 
    }
    //当前层所需要做的处理
    process(level, param);
    //下探下一层
    recursion(level+1, newParam);
    // 清理当前层（如果需要的话）
    
}
```



#### 实战

**22 Generate Parentheses**

```java

```







