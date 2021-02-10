表：Enrollments

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| student_id    | int     |
| course_id     | int     |
| grade         | int     |
+---------------+---------+
(student_id, course_id) 是该表的主键。

 

编写一个 SQL 查询，查询每位学生获得的最高成绩和它所对应的科目，若科目成绩并列，取 course_id 最小的一门。查询结果需按 student_id 增序进行排序。

查询结果格式如下所示：

Enrollments 表：
+------------+-------------------+
| student_id | course_id | grade |
+------------+-----------+-------+
| 2          | 2         | 95    |
| 2          | 3         | 95    |
| 1          | 1         | 90    |
| 1          | 2         | 99    |
| 3          | 1         | 80    |
| 3          | 2         | 75    |
| 3          | 3         | 82    |
+------------+-----------+-------+

Result 表：
+------------+-------------------+
| student_id | course_id | grade |
+------------+-----------+-------+
| 1          | 2         | 99    |
| 2          | 2         | 95    |
| 3          | 3         | 82    |

+------------+-----------+-------+
-- 先求出最大的成绩
SELECT student_id, MAX(grade) AS grade FROM Enrollments GROUP BY student_id
-- 第二步，（id,成绩）作为数组对应上述结果，可得对应的课程id
SELECT student_id, MIN(course_id) AS course_id, grade FROM Enrollments WHERE (student_id, grade) IN
(SELECT student_id, MAX(grade) AS grade FROM Enrollments GROUP BY student_id)
GROUP BY student_id, grade;