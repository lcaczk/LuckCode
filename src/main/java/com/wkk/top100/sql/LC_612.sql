-- 表point_2d保存了所有点（多于 2 个点）的坐标 (x,y) ，这些点在平面上两两不重合。
-- 写一个查询语句找到两点之间的最近距离，保留 2 位小数。


| x  | y  |
|----|----|
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |

-- 最近距离在点 (-1,-1) 和(-1,2) 之间，距离为 1.00 。所以输出应该为：


| shortest |
|----------|
| 1.00     |

SELECT ROUND(SQRT(MIN((POW((p2.x-p1.x), 2) + POW((p2.y-p1.y), 2)))), 2) AS shortest FROM point_2d AS p1 JOIN point_2d AS p2 ON p1.x != p2.x OR p1.y != p2.y;