-- 至少有5名下属的经理
select
    Name
from
    Employee
where
    Id in (
select
    ManagerId
from
    Employee
group by
    ManagerId
having count(Id) >= 5);