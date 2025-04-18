Table: Teams

+---------------+----------+
| Column Name   | Type     |
+---------------+----------+
| team_id       | int      |
| team_name     | varchar  |
+---------------+----------+
此表的主键是 team_id，表中的每一行都代表一支独立足球队。
Table: Matches

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| match_id      | int     |
| host_team     | int     |
| guest_team    | int     |
| host_goals    | int     |
| guest_goals   | int     |
+---------------+---------+
此表的主键是 match_id，表中的每一行都代表一场已结束的比赛，比赛的主客队分别由它们自己的 id 表示，他们的进球由 host_goals 和 guest_goals 分别表示。
 

积分规则如下：

赢一场得三分；
平一场得一分；
输一场不得分。
写出一条SQL语句以查询每个队的 team_id，team_name 和 num_points。结果根据 num_points 降序排序，如果有两队积分相同，那么这两队按 team_id  升序排序。

查询结果格式如下：

Teams table:
+-----------+--------------+
| team_id   | team_name    |
+-----------+--------------+
| 10        | Leetcode FC  |
| 20        | NewYork FC   |
| 30        | Atlanta FC   |
| 40        | Chicago FC   |
| 50        | Toronto FC   |
+-----------+--------------+

Matches table:
+------------+--------------+---------------+-------------+--------------+
| match_id   | host_team    | guest_team    | host_goals  | guest_goals  |
+------------+--------------+---------------+-------------+--------------+
| 1          | 10           | 20            | 3           | 0            |
| 2          | 30           | 10            | 2           | 2            |
| 3          | 10           | 50            | 5           | 1            |
| 4          | 20           | 30            | 1           | 0            |
| 5          | 50           | 30            | 1           | 0            |
+------------+--------------+---------------+-------------+--------------+

Result table:
+------------+--------------+---------------+
| team_id    | team_name    | num_points    |
+------------+--------------+---------------+
| 10         | Leetcode FC  | 7             |
| 20         | NewYork FC   | 3             |
| 50         | Toronto FC   | 3             |
| 30         | Atlanta FC   | 1             |
| 40         | Chicago FC   | 0             |
+------------+--------------+---------------+
-- 思路
-- 先把问题拆解，这是所有复杂SQL题的基本思路
-- 主场球队的分数
select
    host_team team_id
    sum(case
    when host_goals > guest_goals then 3
    when host_goals < guest_goals then 0
    else 1
    end) score
from
    matches
group by host_name

-- 客场分数
select
    guest_team team_id
    sum(case
    when host_goals > guest_goals then 0
    when host_goals < guest_goals then 3
    else 1
    end) score
from
    matches
group by guest_team

-- 第三步：此时联合查询查出来的表是参赛的所有球队的总分，没参赛的也要算，
-- 所以这里用外连接，LEFT JOIN还是RIGHT JOIN都可以，看习惯
FROM
(
    SELECT team_id, SUM(score) score
    FROM (
        SELECT host_team team_id,
        SUM(CASE
        WHEN host_goals>guest_goals THEN 3
        WHEN host_goals<guest_goals THEN 0
        ELSE 1
        END) score
        FROM matches
        GROUP BY host_team
        UNION ALL
        SELECT guest_team team_id,
        SUM(CASE
        WHEN host_goals>guest_goals THEN 0
        WHEN host_goals<guest_goals THEN 3
        ELSE 1
        END) score
        FROM matches
        GROUP BY guest_team
    ) b
    GROUP BY team_id
) a
RIGHT JOIN teams t ON t.team_id=a.team_id

-- 结果
SELECT t.team_id, t.team_name, IFNULL(score,0) num_points
FROM
(
    SELECT team_id, SUM(score) score
    FROM (
        SELECT host_team team_id,
        SUM(CASE
        WHEN host_goals>guest_goals THEN 3
        WHEN host_goals<guest_goals THEN 0
        ELSE 1
        END) score
        FROM matches
        GROUP BY host_team
        UNION ALL
        SELECT guest_team team_id,
        SUM(CASE
        WHEN host_goals>guest_goals THEN 0
        WHEN host_goals<guest_goals THEN 3
        ELSE 1
        END) score
        FROM matches
        GROUP BY guest_team
    ) b
    GROUP BY team_id
) a
RIGHT JOIN teams t ON t.team_id=a.team_id
ORDER BY num_points DESC, t.team_id;
