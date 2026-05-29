# Write your MySQL query statement below
with recursive ranks as (
    select
        max(score) as score,
        1 as rnk
    from scores

    union all

    select
        (
            select max(score)
            from scores
            where score < r.score
        ),
        rnk + 1
    from ranks r
    where score is not null
)

select
    s.score,
    r.rnk as `rank`
from scores s
join ranks r
on s.score = r.score
order by s.score desc;