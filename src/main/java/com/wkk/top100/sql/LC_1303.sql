员工表：Employee

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| employee_id   | int     |
| team_id       | int     |
+---------------+---------+
employee_id 字段是这张表的主键，表中的每一行都包含每个员工的 ID 和他们所属的团队。
编写一个 SQL 查询，以求得每个员工所在团队的总人数。

查询结果中的顺序无特定要求。

查询结果格式示例如下：

Employee Table:
+-------------+------------+
| employee_id | team_id    |
+-------------+------------+
|     1       |     8      |
|     2       |     8      |
|     3       |     8      |
|     4       |     7      |
|     5       |     9      |
|     6       |     9      |
+-------------+------------+
Result table:
+-------------+------------+
| employee_id | team_size  |
+-------------+------------+
|     1       |     3      |
|     2       |     3      |
|     3       |     3      |
|     4       |     1      |
|     5       |     2      |
|     6       |     2      |
+-------------+------------+
ID 为 1、2、3 的员工是 team_id 为 8 的团队的成员，
ID 为 4 的员工是 team_id 为 7 的团队的成员，
ID 为 5、6 的员工是 team_id 为 9 的团队的成员。
-- 解法1
-- 1. 先查询每组的人数
SELECT team_id, COUNT(employee_id) AS team_size FROM Employee GROUP BY team_id;
-- 2. Employee联合查询1的表
SELECT e.employee_id, temp.team_size FROM Employee e LEFT JOIN (SELECT team_id, COUNT(employee_id) AS team_size FROM Employee GROUP BY team_id) AS temp ON e.team_id = temp.team_id;

--解法2 滑动窗口
SELECT EMPLOYEE_ID, COUNT(EMPLOYEE_ID) OVER(PARTITION BY TEAM_ID) AS TEAM_SIZE
FROM EMPLOYEE;


