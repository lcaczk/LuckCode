## 导航

### 数据结构

TODO

### 算法

TODO

### 每日一题延伸题目

#### 2020/08

1. 图的深度和广度遍历题目

   不知道为什么，8月份经常做到图的遍历问题，并且就是DFS和BFS的基础使用

   1. [332. 重新安排行程](https://leetcode-cn.com/problems/reconstruct-itinerary/)

      根据题目来， 可以得出就是一个欧拉图问题，使用HashMap和PriorityQueue的方式

      ```java
      final Map<String, PriorityQueue<String>> map = new HashMap<>();
      final List<String> itinerary = new ArrayList<>();
      public List<String> findItineraryII(List<List<String>> tickets) {
          for (List<String> ticket : tickets) {
              String src = ticket.get(0), dst = ticket.get(1);
              if (!map.containsKey(src)) {
                  map.put(src, new PriorityQueue<>());
              }
              map.get(src).offer(dst);
          }
          dfs(start);
          Collections.reverse(itinerary);
          return itinerary;
      }
      public void dfs(String curr) {
          while (map.containsKey(curr) && map.get(curr).size() > 0) {
              String tmp = map.get(curr).poll();
              dfs(tmp);
          }
          itinerary.add(curr);
      }
      ```

      

   2. [841. 钥匙和房间](https://leetcode-cn.com/problems/keys-and-rooms/)

      很经典的图的遍历问题，使用**深度遍历**和**广度遍历**均可

      1. 深度优先遍历遍历整张图

         ```java
         boolean[] vis;
         int num;
         
         public boolean canVisitAllRooms(List<List<Integer>> rooms) {
           	int n = rooms.size();
             num = 0;
             vis = new boolean[n];
             dfs(rooms, 0);
             return num == n;
         }
         
         public void dfs(List<List<Integer>> rooms, int x) {
             vis[x] = true;
             num++;
             for (int it : rooms.get(x)) {
                 if (!vis[it]) {
                     dfs(rooms, it);
                }
             }
         }
         ```

      2. 广度优先遍历遍历整张图

         ```java
         public boolean canVisitAllRooms(List<List<Integer>> rooms) {
             int n = rooms.size(), num = 0;
             boolean[] vis = new boolean[n];
             Queue<Integer> que = new LinkedList<Integer>();
             vis[0] = true;
             que.offer(0);
             while (!que.isEmpty()) {
                 int x = que.poll();
                 num++;
                 for (int it : rooms.get(x)) {
                     if (!vis[it]) {
                         vis[it] = true;
                         que.offer(it);
                     }
                 }
             }
             return num == n;
         }
         ```

         

   3.  [753. 破解保险箱](https://leetcode-cn.com/problems/cracking-the-safe/)

      

2. 图的应用II： 拓扑排序

   1. [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)(**拓扑排序的经典应用**)

      * **简化思路：**[课程安排图是否是 **有向无环图(DAG)**。即课程间规定了前置条件，但不能构成任何环路，否则课程前置条件将不成立。](https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/)

      * 如何判断是否为有向无环图：使用[**拓扑排序**](https://oi-wiki.org/graph/topo/)

      * **实现步骤（常用方法）：**
        1. 从DAG（有向无环图）中选取一个没有前驱的顶点，并删除
        2. 从图中删除该顶点和所有以它为起点的所有有向边
        3. 重复步骤一和二直到当前的DAG图为空或当前图中不存在无前驱的顶点为止（为空说明无环，后一种情况则说明存在环）

      ```java
      public boolean canFinish(int numCourses, int[][] prerequisites) {
          // 入度数组
          int[] indegrees = new int[numCourses];
          // 图使用邻接表存储
          List<List<Integer>> adjaceny = new ArrayList<>();
          Queue<Integer> queue = new LinkedList<>();
          // 以下为构造邻接表和入度
          for (int i = 0; i < numCourses; i++) {
              adjaceny.add(new ArrayList<>());
          }
          // 根据题意： cps[1]为当前顶点，cps[0]为cps[1]指向顶点
          for (int[] cps : prerequisites) {
              indegrees[cps[0]]++;
              adjaceny.get(cps[1]).add(cps[0]);
          }
          // 寻找入度为0的顶点，也就是没有前驱的顶点，说明以改点作为起始点
          for (int i = 0; i < numCourses; i++) {
              if (indegrees[i] == 0) {
                  queue.add(i);
              }
          }
          // 从该点出发，在图中删除该点之后，检测下一个入度为0的顶点加入队列
          while (!queue.isEmpty()) {
              Integer pre = queue.poll();
              numCourses--;
              for (Integer integer : adjaceny.get(pre)) {
                  if (--indegrees[integer] == 0) {
                      queue.add(integer);
                  }
              }
          }
          return numCourses == 0;
      }
      ```

   2. [210. 课程表II](https://leetcode-cn.com/problems/course-schedule-ii/)

   

#### 2020/09

1. 09/07的题目：[347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) **难度中等**

   ```java
   // 优先队列 + HashMap
   public static int[] topKFrequent(int[] nums, int k) {
       int[] res = new int[k];
       if (nums == null || nums.length == 0 || k <= 0) {
           return res;
       }
       Map<Integer, Integer> map = new HashMap<>();
       // 构造统计词频的hashmap
       for (Integer num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
       }
       // 根据词频构建优先队列(大根堆)
       Queue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> (map.get(y) - map.get(x)));
       int count = 0;
       for (Integer key : map.keySet()) {
           priorityQueue.offer(key);
             //count++;
             //if (count > k) {
             //    priorityQueue.poll();
             //}
       }
       while (count < k) {
           res[count++] = priorityQueue.poll();
       }
       return res;
   }
   ```

   

   关于频率问题，使用`PriorityQueue + HashMap`的方式，感觉是一种很常规的思路

   相关题目：

   1. [192. 统计词频](https://leetcode-cn.com/problems/word-frequency/)

      这是一道写脚本的题目，感觉难度不大，跟着思路一步一步走即可

      ```bash
      cat words.txt | tr -s ' ' '\n' | sort| uniq -c | sort -r | awk '{print $2,$1}'
      1、首先cat命令查看words.txt
      2、tr -s ' ' '\n'将空格都替换为换行 实现分词
      3、sort排序 将分好的词按照顺序排序
      4、uniq -c 统计重复次数（此步骤与上一步息息相关，-c原理是字符串相同则加一，如果不进行先排序的话将无法统计数目）
      5、sort -r 将数目倒序排列
      6、awk '{print $2,$1}' 将词频和词语调换位置打印出来
      ```

   2. [451. 根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency/)

      同样的道理，使用`PriorityQueue+HashMap`的形式，这次PriortyQueue存储的是HashMap的Node节点，不再是单一的元素。

      ```java
      public static String frequencySort(String s) {
          Map<Character,Integer> map = new HashMap<>(16);
          char[] chs = s.toCharArray();
          for(char ch : chs){
              map.put(ch,map.getOrDefault(ch,0) + 1);
          }
          PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((o1, o2) -> {
              //按照出现次数高到低，出现次数相同相等按字符
              if(o1.getValue().equals(o2.getValue())){
                  return o1.getKey().compareTo(o2.getKey());
              }
              return o2.getValue() - o1.getValue();
          });
          for(Map.Entry<Character, Integer> entry : map.entrySet()){
              q.offer(entry);
          }
          StringBuilder stringBuilder = new StringBuilder();
          while(!q.isEmpty()){
              final Map.Entry<Character, Integer> item = q.poll();
              for (int i = 0; i < item.getValue(); i++) {
                  stringBuilder.append(item.getKey());
              }
          }
          return stringBuilder.toString();
      }
      ```

      