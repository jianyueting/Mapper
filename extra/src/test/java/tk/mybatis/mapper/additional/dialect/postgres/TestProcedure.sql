create or replace function plus(in a int, in b int) as $$
select a + b ,a - b
$$ language sql;