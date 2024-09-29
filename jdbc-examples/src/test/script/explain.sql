
EXPLAIN select * from address;

EXPLAIN select a.id from address a;

EXPLAIN
select * from user u
where exists(
    select a.id from address a where u.id=a.user_id and a.detail='1'
);

EXPLAIN
select * from user u
where u.id in (
    select a.id from address a where a.detail='1'
);

EXPLAIN
select u.* from address a, user u
where a.id='1' and a.user_id = u.id;

EXPLAIN
select * from user u join address a
    on u.id = a.user_id
where u.id='1285832708231036928'

select u.id as user_id,u.name,count(a.user_id) as count from user u left join address a
on u.id=a.user_id
group by u.id
order by count;

select u.id,u.name,count(a.user_id) as count from user u join address a
on u.id=a.user_id
group by u.id
order by count