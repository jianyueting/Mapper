delimiter $$
create procedure test_proc(in p1 varchar(10), out p2 varchar(10))
 begin
  set p2=concat('hello',p1);
 end$$
delimiter ;
