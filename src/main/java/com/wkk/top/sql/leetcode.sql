-- Big Countries
SELECT name, population, area
FROM World
WHERE area > 3000000
   OR population > 25000000;

-- 627. Swap Salary
UPDATE salary
SET sex = CHAR(ASCII(sex) ^ ASCII('m') ^ ASCII('f'));

-- 596. Classes More Than 5 Students
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;

-- 182. Duplicate Emails
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(DISTINCT Id) > 1;

-- 196. Delete Duplicate Emails
DELETE
FROM Person
WHERE id NOT IN (
    SELECT id
    FROM (
             SELECT min(id) AS id
             FROM Person
             GROUP BY email
         ) AS m
);

-- 175. 组合两个表
select FirstName, LastName, City, State
from Person
         left join Address
                   on Person.PersonId = Address.PersonId;

