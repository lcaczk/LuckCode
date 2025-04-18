-- ActorDirector表：

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| actor_id    | int     |
| director_id | int     |
| timestamp   | int     |
+-------------+---------+
timestamp 是这张表的主键.

-- 写一条SQL查询语句获取合作过至少三次的演员和导演的 id 对(actor_id, director_id)

-- 示例：

-- ActorDirector 表：
+-------------+-------------+-------------+
| actor_id    | director_id | timestamp   |
+-------------+-------------+-------------+
| 1           | 1           | 0           |
| 1           | 1           | 1           |
| 1           | 1           | 2           |
| 1           | 2           | 3           |
| 1           | 2           | 4           |
| 2           | 1           | 5           |
| 2           | 1           | 6           |
+-------------+-------------+-------------+

-- Result 表：
+-------------+-------------+
| actor_id    | director_id |
+-------------+-------------+
| 1           | 1           |
+-------------+-------------+
-- 唯一的 id 对是 (1, 1)，他们恰好合作了 3 次
SELECT actor_id AS ACTOR_ID, director_id AS DIRECTOR_ID FROM ActorDirector GROUP BY 1, 2 HAVING COUNT(actor_id) >=3;