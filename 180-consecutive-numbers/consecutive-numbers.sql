# Write your MySQL query statement below
with cte as (select num, lag(num,1) over(order by id) as prev_num, 
lead(num,1) over(order by id) as next_num
from logs
)
select distinct num as consecutivenums
from cte
where num = prev_num
and num = next_num;