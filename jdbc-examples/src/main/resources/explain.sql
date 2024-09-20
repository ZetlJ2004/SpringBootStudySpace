
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
