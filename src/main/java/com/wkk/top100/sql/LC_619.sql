-- 表my_numbers的 num字段包含很多数字，其中包括很多重复的数字。
-- 你能写一个 SQL 查询语句，找到只出现过一次的数字中，最大的一个数字吗？

+---+
|num|
+---+
| 8 |
| 8 |
| 3 |
| 3 |
| 1 |
| 4 |
| 5 |
| 6 |
-- 对于上面给出的样例数据，你的查询语句应该返回如下结果：

+---+
|num|
+---+
| 6 |
-- 注意：

-- 如果没有只出现一次的数字，输出null。
-- 不存在不重复的元素时，出问题
SELECT num FROM my_numbers GROUP BY num  HAVING COUNT(num) = 1 ORDER BY num DESC LIMIT 0, 1;
-- 使用max
SELECT MAX(num) FROM my_numbers WHERE num IN (
SELECT num FROM my_numbers GROUP BY num  HAVING COUNT(num) = 1)
