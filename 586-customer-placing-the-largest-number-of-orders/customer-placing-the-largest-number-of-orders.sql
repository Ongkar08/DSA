# Write your MySQL query statement below
Select customer_number
from orders
group by  customer_number
order by Count(customer_number) desc 
LIMIT 1;