create or replace function plus(in a int, in b int)
returns int
as $$
begin
return a + b;
end;
$$ language plpgsql;

create or replace function minus(in a int, in b int)
returns int
as $$
begin
return a - b;
end;
$$ language plpgsql;
