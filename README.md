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

1. * [x] container with most water 
   
   1. 暴力破解法
   2. 双指针法
2. * [x] move zeroes
   
   1. 一次循环， 设置一个专门记录为0元素的索引变量
3. * [x] climbing stairs
   
   1. 递归
4. * [x] 3sum
   
   1. 双指针
   2. 暴力破解
   
5. * [x] 26Remove Duplicates from Sorted Array

6. * [x] 27Remove Element

7. * [x] 88Merge Sorted Array

8. * [x] 209Minimum Size Subarray Sum

9. * [ ] 238Product of Array Except Self

10. * [ ] 713Subarray Product Less Than K

11. * [ ] 7171-bit and 2-bit Characters

12. * [ ] 798Smallest Rotation with Highest Score

### 哈希

1. 242 Valid Anagram



### 二叉树

#### 1.构建树

- 用前序和中序建树105
- 用后序和中序建树106
- 数组构建BST 108
- 链表构建BST 109

#### 2.树的遍历

- 前序 144
- 中序 94
- 后序 145
- 层次 102 103 107

#### 3.树的属性

- 求深度 104
- 是否平衡是平衡树 110
- 最小深度 111

#### 4.BST树

- 判断BST是否合法 98
- 恢复BST 99
- BST实现迭代：173（用到某一遍历）

#### 5. 所有涉及题目

1. * [x] **94** Binary Tree Inorder Traversal
2. * [x] **95** Unique Binary Search Trees II
3. * [x] **96** Unique Binary Search Trees
4. * [x] **98** Validate Binary Search Tree
5. * [x] **99** Recover Binary Search Tree
6. * [x] **100** Same Tree
7. * [x] **101** Symmetric Tree
8. * [x] **102** Binary Tree Level Order Traversal
9. * [x] **103** Binary Tree Zigzag Level Order Traversal
10. * [x] **104** Maximum Depth of Binary Tree
11. * [x] **105** Construct Binary Tree from Preorder and Inorder Traversal
12. * [x] **106** Construct Binary Tree from Inorder and Postorder Traversal
13. * [x] **107** Binary Tree Level Order Traversal II
14. * [x] **108** Convert Sorted Array to Binary Search Tree
15. * [x] **109** Convert Sorted List to Binary Search Tree
16. * [x] **110** Balanced Binary Tree
17. * [x] **111** Minimum Depth of Binary Tree
18. * [x] **112** Path Sum
19. * [x] **113** Path Sum II
20. * [x] **114** Flatten Binary Tree to Linked List
21. * [x] **116** Populating Next Right Pointers in Each Node
22. * [x] **117** Populating Next Right Pointers in Each Node II
23. * [x] **124** Binary Tree Maximum Path Sum
24. * [x] **129** Sum Root to Leaf Numbers
25. * [x] **144** Binary Tree Preorder Traversal
26. * [x] **145** Binary Tree Postorder Traversal
27. * [x] **173** Binary Search Tree Iterator
28. * [x] **199** Binary Tree Right Side View
29. * [x] **222** Count Complete Tree Nodes
30. * [x] **226** Invert Binary Tree
31. * [x] **230** Kth Smallest Element in a BST
32. * [x] **235** Lowest Common Ancestor of a Binary Search Tree
33. * [x] **236** Lowest Common Ancestor of a Binary Tree
34. * [x] **257** Binary Tree Paths
35. * [x] **297** Serialize and Deserialize Binary Tree
36. * [x] **449**. Serialize and Deserialize BST



#### 总结

主要为二叉树的几种遍历， 熟悉每种遍历的写法即可

##### 前序遍历

```java
public void preOrder(TreeNode root){ // 写法1
    if(root != null){
        //
        root操作;
        preOrder(root.left);
        preOrder(root.right);
    }
}

public void preorderTrav(TreeNode root) {	//写法2
	if (root == NULL) return;
	printf("%d ", root->data);	
	preorderTrav(root->lchild);
	preorderTrav(root->rchild);
}

public void preorderTrav(TreeNode root) {	//写法3
	//if (root == NULL) return;	//只要能保证这棵树不是空树，这行代码就可以省略
	printf("%d ", root->data);
	if (root->lchild != NULL) {
		preorderTrav(root->lchild);
	}
	if (root->rchild != NULL) {
		preorderTrav(root->rchild);
	}
}

//非递归方式
// 非递归先序遍历
public static void preorderTraversal(TreeNode root) {
    // 用来暂存节点的栈
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
    // 新建一个游标节点为根节点
    TreeNode node = root;
    // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
    // 所以，只要不同时满足这两点，都需要进入循环
    while (node != null || !treeNodeStack.isEmpty()) {
        // 若当前考查节点非空，则输出该节点的值
        // 由考查顺序得知，需要一直往左走
        while (node != null) {
            System.out.print(node.val + " ");
            // 为了之后能找到该节点的右子树，暂存该节点
            treeNodeStack.push(node);
            node = node.left;
        }
        // 一直到左子树为空，则开始考虑右子树
        // 如果栈已空，就不需要再考虑
        // 弹出栈顶元素，将游标等于该节点的右子树
        if (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pop();
            node = node.right;
        }
    }
}
```

##### 中序遍历

```java
public void inOrder(TreeNode root){
    if(root != null){
        inOrder(root.left);
        root操作;
        inOrder(root.right);
    }
}


//非递归遍历
// 非递归中序遍历
public static void middleorderTraversal(TreeNode root) {
    Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
    TreeNode node = root;
    while (node != null || !treeNodeStack.isEmpty()) {
        while (node != null) {
            treeNodeStack.push(node);
            node = node.left;
        }
        if (!treeNodeStack.isEmpty()) {
            node = treeNodeStack.pop();
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
```

##### 后序遍历

```java
public void postOrder(TreeNode root){
    if(root != null){
        postOrder(root.left);
        postOrder(root.right);
        root操作;
    }
}
```

##### 层次遍历

```java
public void levelOrder(TreeNode root){
    Queue queue = new LinkedList();
    queue.offer(root);
    while(!queue.isEmpty()){
        p = queue.poll();
        if(p.left != null){
            queue.offer(p.left);
        }
        if(p.right != null){
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



#### 总结

##### 对于求所有结果的情况

1. 使用dfs
2. 调用递归

要求出所有结果的集合，一般都是用DFS调用递归来解。那么我们建立一个保存最终结果的大集合res，还要定义一个保存每一个组合的小集合out，每次放一个数到out里，如果out里数个数到了k个，则把out保存到最终结果中，否则在下一层中继续调用递归。网友[u010500263的博客](http://blog.csdn.net/u010500263/article/details/18435495)里有一张图很好的说明了递归调用的顺序，请点击[这里](http://blog.csdn.net/u010500263/article/details/18435495)。

```java
public void dfs(int start , List<List<XXX>> resutls, List<XXX> out, xx[] candiates){
    // 满足条件的处理(记得写终止条件)
    
    for (int i = start; i < candidates.length; i++){
        out.add(candiates[i]);
        dfs();// 这里的参数 具体情况具体分析（是否有重复）
        out.remove(out.size()-1)    
    }
    
}
```











